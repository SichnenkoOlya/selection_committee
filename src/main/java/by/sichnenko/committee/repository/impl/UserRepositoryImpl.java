package by.sichnenko.committee.repository.impl;

import by.sichnenko.committee.connection.ConnectionPoolImpl;
import by.sichnenko.committee.connection.ProxyConnection;
import by.sichnenko.committee.constant.SQLQueryConstant;
import by.sichnenko.committee.constant.SQLFieldConstant;
import by.sichnenko.committee.exception.ConnectionPoolException;
import by.sichnenko.committee.exception.RepositoryException;
import by.sichnenko.committee.model.RoleType;
import by.sichnenko.committee.model.User;
import by.sichnenko.committee.repository.Repository;
import by.sichnenko.committee.specification.Specification;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements Repository<User> {

    @Override
    public boolean add(User user) throws RepositoryException {
      /*  ProxyConnection proxyConnection;
        try {
            proxyConnection = ConnectionPoolImpl.getInstance().takeConnection();

        } catch (ConnectionPoolException e) {
            throw new RepositoryException("Create user error ", e);
        }
        try (PreparedStatement statement = proxyConnection.prepareStatement(SQLQueryConstant.CREATE_USER)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getHashPassword());
            statement.setString(3, user.getRole().toString());
            statement.setString(4, user.getEmail());
            return statement.executeUpdate() == 1;

        } catch (SQLException e) {
            throw new RepositoryException("Create user error ", e);
        }*/
      return true;
    }

    @Override
    public void update(User user) throws RepositoryException {
       /* ProxyConnection proxyConnection;
        try {
            proxyConnection = ConnectionPoolImpl.getInstance().takeConnection();

        } catch (ConnectionPoolException e) {
            throw new RepositoryException("Update user error ", e);
        }
        try (PreparedStatement statement = proxyConnection.prepareStatement(SQLQueryConstant.UPDATE_USER)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getHashPassword());
            statement.setString(3, user.getRole().toString());
            statement.setString(4, user.getEmail());
            statement.setString(5, String.valueOf(user.getUserId()));
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RepositoryException("Update user error ", e);
        }*/
    }

    @Override
    public boolean remove(User user) {
        return false;
        //throw new TechnicalException("Invalid action");
    }

    @Override
    public List<User> query(Specification specification) throws RepositoryException {

       /* ProxyConnection proxyConnection;
        try {
            proxyConnection = ConnectionPoolImpl.getInstance().takeConnection();

        } catch (ConnectionPoolException e) {
            throw new RepositoryException("Find user error ", e);
        }

        try (PreparedStatement preparedStatement = proxyConnection.prepareStatement(specification.toSqlQuery())) {
            specification.fillPreparedStatement(preparedStatement);
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
            throw new RepositoryException("Find user error ", e);
        }*/
       return null;
    }


}
