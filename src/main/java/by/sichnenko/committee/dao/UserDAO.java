package by.sichnenko.committee.dao;

import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.model.RoleType;
import by.sichnenko.committee.model.User;

import java.util.List;

public interface UserDAO extends DAO<User> {

    User findUserByLogin(String login) throws DAOException;

    void updateRole(Long userId, RoleType newRole) throws DAOException;

    void updateLock(Long userId, Boolean newLock) throws DAOException;

    void updatePassword(Long userId, String newPassword) throws DAOException;

    List<User> findAllUsersByStatus(Long statusId) throws DAOException;

    void changeAvatar(Long userId, String imagePath) throws DAOException;
}

