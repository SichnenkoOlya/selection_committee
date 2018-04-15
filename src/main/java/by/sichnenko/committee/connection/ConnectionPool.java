package by.sichnenko.committee.connection;

import by.sichnenko.committee.exception.ConnectionPoolException;

public interface ConnectionPool {
    void initConnectionPool() throws ConnectionPoolException;

    void disposeConnectionPool() throws ConnectionPoolException;

    ProxyConnection takeConnection();

    void returnConnection(ProxyConnection connection);
}