package by.sichnenko.committee.dao;

import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.model.User;

public interface UserDAO extends DAO<User> {

    User findUserByLogin(String login) throws DAOException;

    void updateRole(User user) throws DAOException;

    void updateLock(User user) throws DAOException;
}

