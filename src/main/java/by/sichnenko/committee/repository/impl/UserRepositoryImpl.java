package by.sichnenko.committee.repository.impl;

import by.sichnenko.committee.connection.ConnectionPoolImpl;
import by.sichnenko.committee.connection.ProxyConnection;
import by.sichnenko.committee.constant.SQLConstant;
import by.sichnenko.committee.exception.ConnectionPoolException;
import by.sichnenko.committee.exception.RepositoryException;
import by.sichnenko.committee.model.RoleType;
import by.sichnenko.committee.model.User;
import by.sichnenko.committee.repository.Repository;
import by.sichnenko.committee.repository.Specification;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserRepositoryImpl implements Repository<User> {
    @Override
    public boolean add(User user) throws RepositoryException {
        ProxyConnection proxyConnection;
        try {
            proxyConnection = ConnectionPoolImpl.getInstance().takeConnection();

        } catch (ConnectionPoolException e) {
            throw new RepositoryException("Create user error ", e);
        }
        try (PreparedStatement statement = proxyConnection.prepareStatement(SQLConstant.CREATE_USER)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getHashPassword());
            statement.setString(3, user.getRole().toString());
            statement.setString(4, user.getEmail());

            return statement.executeUpdate() == 1;

        } catch (SQLException e) {
            throw new RepositoryException("Create user error ", e);
        }
    }

    @Override
    public void update(User user) throws RepositoryException {
        ProxyConnection proxyConnection;
        try {
            proxyConnection = ConnectionPoolImpl.getInstance().takeConnection();

        } catch (ConnectionPoolException e) {
            throw new RepositoryException("Create user error ", e);
        }
        try (PreparedStatement statement = proxyConnection.prepareStatement(SQLConstant.UPDATE_USER)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getHashPassword());
            statement.setString(3, user.getRole().toString());
            statement.setString(4, user.getEmail());
            statement.setString(5, String.valueOf(user.getUserId()));

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RepositoryException("Create user error ", e);
        }
    }

    @Override
    public boolean remove(User user) throws RepositoryException {
        return true;
    }

    @Override
    public List<User> query(Specification<User> specification) throws RepositoryException {

        ProxyConnection proxyConnection;
        try {
            proxyConnection = ConnectionPoolImpl.getInstance().takeConnection();

        } catch (ConnectionPoolException e) {
            throw new RepositoryException("Create user error ", e);
        }
        try (PreparedStatement statement = proxyConnection.prepareStatement(specification.toSqlQuery())) {
            ResultSet resultSet = statement.executeQuery();
            List<User> userList = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("id"));
                user.setRole(RoleType.valueOf(resultSet.getString("role").toUpperCase()));
                user.setEmail(resultSet.getString("email"));
                user.setLogin(resultSet.getString("login"));
                user.setHashPassword(resultSet.getString("hash_password"));
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            throw new RepositoryException("Create user error ", e);
        }
    }

}
