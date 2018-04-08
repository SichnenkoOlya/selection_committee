package by.sichnenko.committee.repository.impl;

import by.sichnenko.committee.connection.ConnectionPoolImpl;
import by.sichnenko.committee.connection.ProxyConnection;
import by.sichnenko.committee.constant.SQLQueryConstant;
import by.sichnenko.committee.exception.ConnectionPoolException;
import by.sichnenko.committee.exception.RepositoryException;
import by.sichnenko.committee.model.Enrollee;
import by.sichnenko.committee.repository.Repository;
import by.sichnenko.committee.specification.Specification;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EnrolleeRepositoryImpl implements Repository<Enrollee> {
    @Override
    public boolean add(Enrollee enrollee) throws RepositoryException {
      /*  ProxyConnection proxyConnection;
        try {
            proxyConnection = ConnectionPoolImpl.getInstance().takeConnection();

        } catch (ConnectionPoolException e) {
            throw new RepositoryException("Create user error ", e);
        }
      //  "INSERT INTO enrollee (name, surname, patronymic, phone_namber, faculty_id," +
            //    "status_id, user_id, city_id) VALUES  (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = proxyConnection.prepareStatement(SQLQueryConstant.CREATE_ENROLLEE)) {
            statement.setString(1, enrollee.getName());
            statement.setString(2, enrollee.getSurname());
            statement.setString(3, enrollee.getPatronymic());
            statement.setString(4, enrollee.getPhoneNumber());
            return statement.executeUpdate() == 1;

        } catch (SQLException e) {
            throw new RepositoryException("Create user error ", e);
        }*/
      return false;
    }

    @Override
    public void update(Enrollee item) throws RepositoryException {

    }

    @Override
    public boolean remove(Enrollee item) throws RepositoryException {
        return false;
    }

    @Override
    public List<Enrollee> query(Specification specification) throws RepositoryException {
        return null;
    }
}
