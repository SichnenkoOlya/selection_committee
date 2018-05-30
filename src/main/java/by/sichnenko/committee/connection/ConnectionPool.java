package by.sichnenko.committee.connection;

import by.sichnenko.committee.exception.ConnectionPoolException;

/**
 * The ConnectionPool class
 */
public interface ConnectionPool {
    /**
     * Dispose connection pool
     *
     * @throws ConnectionPoolException if was exception during disposing
     */
    void disposeConnectionPool() throws ConnectionPoolException;

    /**
     * Take connection from connection pool
     *
     * @return proxy connection
     * @see ProxyConnection
     */
    ProxyConnection takeConnection();

    /**
     * Return connection to connection pool
     *
     * @param connection proxy connection
     * @see ProxyConnection
     */
    void returnConnection(ProxyConnection connection);
}