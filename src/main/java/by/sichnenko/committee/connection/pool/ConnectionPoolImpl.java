package by.sichnenko.committee.connection.pool;

import by.sichnenko.committee.exception.ConnectionPoolException;
import by.sichnenko.committee.util.ResourceManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
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
    private final int POOL_SIZE;
    private BlockingQueue<ProxyConnection> availableConnections;
    private BlockingQueue<ProxyConnection> usedConnections;

    private ConnectionPoolImpl() {
        DRIVER_NAME = ResourceManager.readProperty("driver_name", DB_FILE_PROPERTIES_NAME);
        URL = ResourceManager.readProperty("url", DB_FILE_PROPERTIES_NAME);
        USER = ResourceManager.readProperty("user", DB_FILE_PROPERTIES_NAME);
        PASSWORD = ResourceManager.readProperty("password", DB_FILE_PROPERTIES_NAME);
        ///???
        POOL_SIZE = Integer.parseInt(ResourceManager.readProperty("pool_size", DB_FILE_PROPERTIES_NAME));

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
            usedConnections = new ArrayBlockingQueue<>(POOL_SIZE);
            availableConnections = new ArrayBlockingQueue<>(POOL_SIZE);
            for (int i = 0; i < POOL_SIZE; i++) {
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                ProxyConnection proxyConnection = new ProxyConnection(connection);
                availableConnections.offer(proxyConnection);
            }
        } catch (SQLException e) {
            throw new ConnectionPoolException("2", e);

        } catch (ClassNotFoundException e) {
            throw new ConnectionPoolException("1", e);
        }
    }

    @Override
    public void disposeConnectionPool() throws ConnectionPoolException {
        try {
            closeConnectionsQueue(availableConnections);
        } catch (SQLException e) {
            throw new ConnectionPoolException(e);
        }
    }

    @Override
    public ProxyConnection takeConnection() throws ConnectionPoolException {
        ProxyConnection connection;
        try {
            connection = availableConnections.take();
            usedConnections.put(connection);
            return connection;
        } catch (InterruptedException e) {
            throw new ConnectionPoolException("1", e);
        }
    }

    @Override
    public void returnConnection(ProxyConnection connection) throws ConnectionPoolException {
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

    private void closeConnectionsQueue(BlockingQueue<ProxyConnection> queue) throws SQLException {
        Connection connection;
        for (int i = 0; i < POOL_SIZE; i++) {
            connection = queue.poll();
            if (connection != null) {
                if (!connection.getAutoCommit()) {
                    connection.commit();
                }
                connection.close();
            }
        }
    }
}
