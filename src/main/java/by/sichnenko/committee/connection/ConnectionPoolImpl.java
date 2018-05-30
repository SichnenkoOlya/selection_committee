package by.sichnenko.committee.connection;

import by.sichnenko.committee.exception.ConnectionPoolException;
import by.sichnenko.committee.util.ResourceManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/**
 * The ConnectionPoolImpl class.
 * Implementation of interface ConnectionPool.
 */
public class ConnectionPoolImpl implements ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPoolImpl.class);

    private static final String DB_FILE_PROPERTIES_NAME = "dataBase";
    private static final String DB_URL = "db_url";
    private static final String DB_DRIVER_NAME = "db_driver_name";
    private static final String DB_USER = "db_user";
    private static final String DB_PASSWORD = "db_password";
    private static final String DB_POOL_SIZE = "db_pool_size";

    private final static int DEFAULT_POOL_SIZE = 12;
    private static ConnectionPool instance;
    private static AtomicBoolean isCreated = new AtomicBoolean();
    private static ReentrantLock lock = new ReentrantLock();
    private final String DRIVER_NAME;
    private final String URL;
    private final String USER;
    private final String PASSWORD;
    private int POOL_SIZE;
    private LinkedBlockingQueue<ProxyConnection> availableConnections;
    private ArrayDeque<ProxyConnection> usedConnections;//

    private ConnectionPoolImpl() throws SQLException {
        DRIVER_NAME = ResourceManager.readProperty(DB_DRIVER_NAME, DB_FILE_PROPERTIES_NAME);
        URL = ResourceManager.readProperty(DB_URL, DB_FILE_PROPERTIES_NAME);
        USER = ResourceManager.readProperty(DB_USER, DB_FILE_PROPERTIES_NAME);
        PASSWORD = ResourceManager.readProperty(DB_PASSWORD, DB_FILE_PROPERTIES_NAME);

        try {
            POOL_SIZE = Integer.parseInt(ResourceManager.readProperty(DB_POOL_SIZE, DB_FILE_PROPERTIES_NAME));
        } catch (NumberFormatException ex) {
            POOL_SIZE = DEFAULT_POOL_SIZE;
        }
        try {
            initConnectionPool();
        } catch (SQLException e) {
            throw new SQLException("Error to init connection pool", e);
        }
    }

    /**
     * Get instance of connection pool
     *
     * @return connection pool
     */
    public static ConnectionPool getInstance() {
        if (!isCreated.get()) {
            lock.lock();
            try {
                if (instance == null) {
                    instance = new ConnectionPoolImpl();
                    isCreated.set(true);
                }
            } catch (SQLException e) {
                LOGGER.fatal(e);
                throw new RuntimeException("Error to get instance of connection pool", e);
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }


    private void initConnectionPool() throws SQLException {
        try {
            Class.forName(DRIVER_NAME);
            usedConnections = new ArrayDeque<>(POOL_SIZE);
            availableConnections = new LinkedBlockingQueue<>(POOL_SIZE);
            for (int i = 0; i < POOL_SIZE; i++) {
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                ProxyConnection proxyConnection = new ProxyConnection(connection);
                availableConnections.offer(proxyConnection);
            }
        } catch (SQLException e) {
            throw new SQLException("Error creating connection", e);

        } catch (ClassNotFoundException e) {
            LOGGER.fatal(e);
            throw new RuntimeException("Class not found exception", e);
        }
    }

    /**
     * Dispose connection pool
     *
     * @throws ConnectionPoolException if was exception during disposing
     */
    @Override
    public void disposeConnectionPool() throws ConnectionPoolException {
        try {
            ProxyConnection proxyConnection;
            for (int i = 0; i < POOL_SIZE; i++) {
                proxyConnection = availableConnections.take();
                if (proxyConnection != null) {
                    if (!proxyConnection.getAutoCommit()) {
                        proxyConnection.commit();
                    }
                    proxyConnection.realClose();
                }
            }
        } catch (SQLException e) {
            throw new ConnectionPoolException("Error to dispose connection pool", e);
        } catch (InterruptedException e) {
            throw new ConnectionPoolException("Error to take avaliable connection", e);
        }
    }

    /**
     * Take connection from connection pool
     *
     * @return proxy connection
     * @see ProxyConnection
     */
    @Override
    public ProxyConnection takeConnection() {
        ProxyConnection connection = null;
        try {
            connection = availableConnections.take();
            usedConnections.push(connection);
        } catch (InterruptedException e) {
            LOGGER.error(e);
        }
        return connection;
    }

    /**
     * Return connection to connection pool
     *
     * @param connection proxy connection
     * @see ProxyConnection
     */
    @Override
    public void returnConnection(ProxyConnection connection) {
        if (connection != null) {
            if (usedConnections.remove(connection)) {
                availableConnections.offer(connection);
            }
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Invalid action");
    }
}
