package by.sichnenko.committee.connection.pool;

import by.sichnenko.committee.exception.ConnectionPoolException;

import java.sql.Connection;

public interface ConnectionPool {
    void initConnectionPool() throws ConnectionPoolException;

    void disposeConnectionPool() throws ConnectionPoolException;

    ProxyConnection takeConnection() throws ConnectionPoolException;

    void returnConnection(ProxyConnection con) throws ConnectionPoolException;
}