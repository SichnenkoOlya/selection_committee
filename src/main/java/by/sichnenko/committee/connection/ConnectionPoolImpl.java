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


public class ConnectionPoolImpl implements ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPoolImpl.class);
    private static ConnectionPool instance;
    private static AtomicBoolean isCreated = new AtomicBoolean();
    private static ReentrantLock lock = new ReentrantLock();

    private static final String DB_FILE_PROPERTIES_NAME = "dataBase";
    private final String DRIVER_NAME;
    private final String URL;
    private final String USER;
    private final String PASSWORD;
    private int POOL_SIZE;
    private final static int DEFAULT_POOL_SIZE = 12;
    private LinkedBlockingQueue<ProxyConnection> availableConnections;
    private ArrayDeque<ProxyConnection> usedConnections;//

    private ConnectionPoolImpl() {
        DRIVER_NAME = ResourceManager.readProperty("db_driver_name", DB_FILE_PROPERTIES_NAME);
        URL = ResourceManager.readProperty("db_url", DB_FILE_PROPERTIES_NAME);
        USER = ResourceManager.readProperty("db_user", DB_FILE_PROPERTIES_NAME);
        PASSWORD = ResourceManager.readProperty("db_password", DB_FILE_PROPERTIES_NAME);
        try {
            POOL_SIZE = Integer.parseInt(ResourceManager.readProperty("db_pool_size", DB_FILE_PROPERTIES_NAME));
        } catch (NumberFormatException ex) {
            POOL_SIZE = DEFAULT_POOL_SIZE;
        }
        try {
            initConnectionPool();
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionPool getInstance() {
        if (!isCreated.get()) {
            lock.lock();
            try {
                if (instance == null) {
                    instance = new ConnectionPoolImpl();
                    isCreated.set(true);
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    @Override
    public void initConnectionPool() throws ConnectionPoolException {
        try {
            Class.forName(DRIVER_NAME);
            usedConnections = new ArrayDeque<>(POOL_SIZE);
            availableConnections = new LinkedBlockingQueue<>(POOL_SIZE);
            for (int i = 0; i < POOL_SIZE; i++) {
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                ProxyConnection proxyConnection = new ProxyConnection(connection);
                availableConnections.offer(proxyConnection);
            }
            ///Проверка сколько создалось
        } catch (SQLException e) {
            throw new ConnectionPoolException("Error creating connection", e);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Class not found", e);///RunTime
        }
    }

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
            throw new ConnectionPoolException(e);
        } catch (InterruptedException e) {
            throw new ConnectionPoolException(e);
        }
    }

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
