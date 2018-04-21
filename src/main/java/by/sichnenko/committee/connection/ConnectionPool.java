package by.sichnenko.committee.connection;

import by.sichnenko.committee.exception.ConnectionPoolException;

public interface ConnectionPool {
    void disposeConnectionPool() throws ConnectionPoolException;

    ProxyConnection takeConnection();

    void returnConnection(ProxyConnection connection);
}