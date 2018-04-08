package by.sichnenko.committee.dao;

import by.sichnenko.committee.connection.ProxyConnection;
import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.model.User;

public abstract class AbstractUserDAO extends AbstractDAO<User> {
    public AbstractUserDAO(ProxyConnection connection) {
        super(connection);
    }

    public abstract User findUserByLogin(String login) throws DAOException;
    public abstract void updateRole(User user) throws DAOException;
    public abstract void updateLock(User user) throws DAOException;
}

