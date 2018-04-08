package by.sichnenko.committee.dao.impl;

import by.sichnenko.committee.connection.ConnectionPoolImpl;
import by.sichnenko.committee.connection.ProxyConnection;
import by.sichnenko.committee.constant.SQLFieldConstant;
import by.sichnenko.committee.constant.SQLQueryConstant;
import by.sichnenko.committee.dao.AbstractUserDAO;
import by.sichnenko.committee.exception.ConnectionPoolException;
import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.exception.RepositoryException;
import by.sichnenko.committee.model.RoleType;
import by.sichnenko.committee.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractUserDAO {

    public UserDAO(ProxyConnection connection) {
        super(connection);
    }

    @Override
    public User findUserByLogin(String login) throws DAOException {
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();

        } catch (ConnectionPoolException e) {
            throw new DAOException("Find user error ", e);
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.SELECT_USER_BY_LOGIN)) {
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = new User();
            if (resultSet.next()) {
                user.setUserId(resultSet.getInt(SQLFieldConstant.User.ID));
                user.setRole(RoleType.valueOf(resultSet.getString(SQLFieldConstant.User.ROLE).toUpperCase()));
                user.setEmail(resultSet.getString(SQLFieldConstant.User.EMAIL));
                user.setLogin(resultSet.getString(SQLFieldConstant.User.LOGIN));
                user.setHashPassword(resultSet.getString(SQLFieldConstant.User.HASH_PASSWORD));
            }
            return user;
        } catch (SQLException e) {
            throw new DAOException("Find user error ", e);
        }
    }

    @Override
    public void updateRole(User user) throws DAOException {
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();

        } catch (ConnectionPoolException e) {
            throw new DAOException("Update user error ", e);
        }
        try (PreparedStatement statement = connection.prepareStatement(SQLQueryConstant.UPDATE_USER_ROLE)) {
            statement.setString(1, user.getRole().name().toLowerCase());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Update user error ", e);
        }
    }

    @Override
    public void updateLock(User user) throws DAOException {
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();

        } catch (ConnectionPoolException e) {
            throw new DAOException("Update user error ", e);
        }
        try (PreparedStatement statement = connection.prepareStatement(SQLQueryConstant.UPDATE_USER_LOCK)) {
            statement.setBoolean(1, user.getIsLocked());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Update user error ", e);
        }
    }

    @Override
    public List<User> findAll() throws DAOException {
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();

        } catch (ConnectionPoolException e) {
            throw new DAOException("Find user error ", e);
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.SELECT_ALL_USERS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> userList = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt(SQLFieldConstant.User.ID));
                user.setRole(RoleType.valueOf(SQLFieldConstant.User.ROLE.toUpperCase()));
                user.setEmail(resultSet.getString(SQLFieldConstant.User.EMAIL));
                user.setLogin(resultSet.getString(SQLFieldConstant.User.LOGIN));
                user.setHashPassword(resultSet.getString(SQLFieldConstant.User.HASH_PASSWORD));
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            throw new DAOException("Find user error ", e);
        }
    }

    @Override
    public boolean create(User user) throws DAOException {
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();

        } catch (ConnectionPoolException e) {
            throw new DAOException("Create user error ", e);
        }
        try (PreparedStatement statement = connection.prepareStatement(SQLQueryConstant.CREATE_USER)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getHashPassword());
            statement.setString(3, user.getRole().toString());
            statement.setString(4, user.getEmail());
            return statement.executeUpdate() == 1;

        } catch (SQLException e) {
            throw new DAOException("Create user error ", e);
        }

    }

    @Override
    public void update(User user) throws DAOException {
        ProxyConnection proxyConnection;
        try {
            proxyConnection = ConnectionPoolImpl.getInstance().takeConnection();

        } catch (ConnectionPoolException e) {
            throw new DAOException("Update user error ", e);
        }
        try (PreparedStatement statement = proxyConnection.prepareStatement(SQLQueryConstant.UPDATE_USER)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getHashPassword());
            statement.setString(3, user.getRole().toString());
            statement.setString(4, user.getEmail());
            statement.setString(5, String.valueOf(user.getUserId()));
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Update user error ", e);
        }
    }

}