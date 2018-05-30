package by.sichnenko.committee.dao;

import by.sichnenko.committee.connection.ProxyConnection;
import by.sichnenko.committee.exception.DAOException;

import java.util.List;

/**
 * The interface DAO
 *
 * @param <T>
 */
public interface DAO<T> {
    /**
     * Find all objects
     *
     * @return list of objects
     * @throws DAOException when sql exception occurs
     */
    List<T> findAll() throws DAOException;

    /**
     * Create object
     *
     * @param item item of type T
     * @throws DAOException when sql exception occurs
     */
    void create(T item) throws DAOException;

    /**
     * Update item of type T
     *
     * @param item item of type T
     * @throws DAOException when sql exception occurs
     */
    void update(T item) throws DAOException;

    /**
     * Close connection
     *
     * @param proxyConnection connection
     * @see ProxyConnection
     */
    default void closeConnection(ProxyConnection proxyConnection) {
        if (proxyConnection != null) {
            proxyConnection.close();
        }
    }
}


