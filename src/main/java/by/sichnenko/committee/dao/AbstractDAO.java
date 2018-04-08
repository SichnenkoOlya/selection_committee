package by.sichnenko.committee.dao;

import by.sichnenko.committee.connection.ProxyConnection;
import by.sichnenko.committee.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDAO<T> {
    protected final static Logger LOGGER = LogManager.getLogger();

    protected ProxyConnection connection;

    public AbstractDAO(ProxyConnection connection) {
        this.connection = connection;
    }

    public void closeConnection(ProxyConnection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            LOGGER.error("Error during connection to pull return", e);
        }
    }

    public abstract List<T> findAll() throws DAOException;
    public abstract boolean create(T item) throws DAOException;
    public abstract void update(T item) throws DAOException;
}

