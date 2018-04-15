package by.sichnenko.committee.dao;

import by.sichnenko.committee.connection.ProxyConnection;
import by.sichnenko.committee.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    List<T> findAll() throws DAOException;

    boolean create(T item) throws DAOException;

    void update(T item) throws DAOException;

    default void closeConnection(ProxyConnection proxyConnection){
        if (proxyConnection != null) {
            try {
                proxyConnection.close();
            } catch (SQLException e) {
                Logger logger = LogManager.getLogger();
                logger.error("Error return connection to connection pool", e);
            }
        }
    }
}

