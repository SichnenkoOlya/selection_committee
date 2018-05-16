package by.sichnenko.committee.dao.impl;

import by.sichnenko.committee.connection.ConnectionPoolImpl;
import by.sichnenko.committee.connection.ProxyConnection;
import by.sichnenko.committee.constant.SQLFieldConstant;
import by.sichnenko.committee.constant.SQLQueryConstant;
import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.model.RoleType;
import by.sichnenko.committee.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements by.sichnenko.committee.dao.UserDAO {

    @Override
    public User findUserByLogin(String login) throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();

            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.SELECT_USER_BY_LOGIN)) {
                //TODO: 1 это нормально?
                preparedStatement.setString(1, login);
                ResultSet resultSet = preparedStatement.executeQuery();
                //TODO: null или optional
                User user = null;
                if (resultSet.next()) {
                    user = new User();
                    user.setUserId(resultSet.getLong(SQLFieldConstant.ID));
                    user.setRole(RoleType.valueOf(resultSet.getString(SQLFieldConstant.User.ROLE).toUpperCase()));
                    user.setEmail(resultSet.getString(SQLFieldConstant.User.EMAIL));
                    user.setLogin(resultSet.getString(SQLFieldConstant.User.LOGIN));
                    user.setIsBlocked(resultSet.getBoolean(SQLFieldConstant.User.LOCK));
                    user.setHashPassword(resultSet.getString(SQLFieldConstant.User.HASH_PASSWORD));
                    user.setImagePath(resultSet.getString(SQLFieldConstant.User.IMAGE_PATH));
                }
                return user;
            } catch (SQLException e) {
                throw new DAOException("Find user error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void updateRole(Long userId, RoleType newRole) throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();

            try (PreparedStatement statement = connection.prepareStatement(SQLQueryConstant.UPDATE_USER_ROLE)) {
                statement.setString(1, newRole.name().toLowerCase());
                statement.setLong(2, userId);
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new DAOException("Update user's role error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void updateLock(Long userId, Boolean newLock) throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();

            try (PreparedStatement statement = connection.prepareStatement(SQLQueryConstant.UPDATE_USER_LOCK)) {
                statement.setBoolean(1, newLock);
                statement.setLong(2, userId);
                statement.executeUpdate();

            } catch (SQLException e) {
                throw new DAOException("Update user's lock error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void updatePassword(Long userId, String newPassword) throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();

            try (PreparedStatement statement = connection.prepareStatement(SQLQueryConstant.UPDATE_USER_PASSWORD)) {
                statement.setString(1, newPassword);
                statement.setLong(2, userId);
                statement.executeUpdate();

            } catch (SQLException e) {
                throw new DAOException("Update user's password error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<User> findAll() throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.SELECT_ALL_USERS)) {

                ResultSet resultSet = preparedStatement.executeQuery();
                List<User> userList = new ArrayList<>();
                while (resultSet.next()) {
                    User user = new User();
                    user.setUserId(resultSet.getLong(SQLFieldConstant.User.ID));
                    user.setRole(RoleType.valueOf(resultSet.getString(SQLFieldConstant.User.ROLE).toUpperCase()));
                    user.setEmail(resultSet.getString(SQLFieldConstant.User.EMAIL));
                    user.setLogin(resultSet.getString(SQLFieldConstant.User.LOGIN));
                    user.setHashPassword(resultSet.getString(SQLFieldConstant.User.HASH_PASSWORD));
                    user.setIsBlocked(resultSet.getBoolean(SQLFieldConstant.User.LOCK));
                    user.setImagePath(resultSet.getString(SQLFieldConstant.User.IMAGE_PATH));
                    userList.add(user);
                }
                return userList;
            } catch (SQLException e) {
                throw new DAOException("Find users error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<User> findAllUsersByStatus(Long statusId) throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.SELECT_ALL_USERS_BY_STATUS)) {
                preparedStatement.setLong(1, statusId);
                ResultSet resultSet = preparedStatement.executeQuery();
                List<User> userList = new ArrayList<>();
                while (resultSet.next()) {
                    User user = new User();
                    user.setUserId(resultSet.getLong(SQLFieldConstant.User.ID));
                    user.setRole(RoleType.valueOf(resultSet.getString(SQLFieldConstant.User.ROLE).toUpperCase()));
                    user.setEmail(resultSet.getString(SQLFieldConstant.User.EMAIL));
                    user.setLogin(resultSet.getString(SQLFieldConstant.User.LOGIN));
                    user.setHashPassword(resultSet.getString(SQLFieldConstant.User.HASH_PASSWORD));
                    user.setIsBlocked(resultSet.getBoolean(SQLFieldConstant.User.LOCK));
                    user.setImagePath(resultSet.getString(SQLFieldConstant.IMAGE_PATH));
                    userList.add(user);
                }
                return userList;
            } catch (SQLException e) {
                throw new DAOException("Find user error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void updateImagePath(Long userId, String imagePath) throws DAOException {
        ProxyConnection proxyConnection = null;
        try {
            proxyConnection = ConnectionPoolImpl.getInstance().takeConnection();

            try (PreparedStatement statement = proxyConnection.prepareStatement(SQLQueryConstant.UPDATE_USER_AVATER)) {
                statement.setString(1, imagePath);
                statement.setLong(2, userId);
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new DAOException("Update user's image error ", e);
            }
        } finally {
            closeConnection(proxyConnection);
        }
    }

    @Override
    public void create(User user) throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();

            try (PreparedStatement statement = connection.prepareStatement(SQLQueryConstant.CREATE_USER)) {
                statement.setString(1, user.getLogin());
                statement.setString(2, user.getHashPassword());
                statement.setString(3, user.getRole().toString());
                statement.setString(4, user.getEmail());
                statement.executeUpdate();

            } catch (SQLException e) {
                throw new DAOException("Create user error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(User user) throws DAOException {
        ProxyConnection proxyConnection = null;
        try {
            proxyConnection = ConnectionPoolImpl.getInstance().takeConnection();

            try (PreparedStatement statement = proxyConnection.prepareStatement(SQLQueryConstant.UPDATE_USER)) {
                statement.setString(1, user.getLogin());
                statement.setString(2, user.getHashPassword());
                statement.setString(3, user.getRole().name().toLowerCase());
                statement.setString(4, user.getEmail());
                statement.setBoolean(5, user.getIsBlocked());
                statement.setString(6, user.getImagePath());
                statement.setLong(7, user.getUserId());
                statement.executeUpdate();

            } catch (SQLException e) {
                throw new DAOException("Update user error ", e);
            }
        } finally {
            closeConnection(proxyConnection);
        }
    }
}