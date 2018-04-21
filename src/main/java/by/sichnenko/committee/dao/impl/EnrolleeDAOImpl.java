package by.sichnenko.committee.dao.impl;

import by.sichnenko.committee.connection.ConnectionPoolImpl;
import by.sichnenko.committee.connection.ProxyConnection;
import by.sichnenko.committee.constant.SQLFieldConstant;
import by.sichnenko.committee.constant.SQLQueryConstant;
import by.sichnenko.committee.dao.EnrolleeDAO;
import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.model.Enrollee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnrolleeDAOImpl implements EnrolleeDAO {
    @Override
    public List<Enrollee> findAll() throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.SELECT_ALL_ENROLLEES)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                List<by.sichnenko.committee.model.Enrollee> enrolleeList = new ArrayList<>();
                while (resultSet.next()) {
                    by.sichnenko.committee.model.Enrollee enrollee = new by.sichnenko.committee.model.Enrollee();
                    enrollee.setEnrolleeId(resultSet.getLong(SQLFieldConstant.Enrollee.ID));
                    enrollee.setName(resultSet.getString(SQLFieldConstant.Enrollee.NAME));
                    enrollee.setSurname(resultSet.getString(SQLFieldConstant.Enrollee.SURNAME));
                    enrollee.setPatronymic(resultSet.getString(SQLFieldConstant.Enrollee.PATRONYMIC));
                    enrollee.setPhoneNumber(resultSet.getString(SQLFieldConstant.Enrollee.PHONE_NUMBER));
                    enrollee.setFacultyId(resultSet.getLong(SQLFieldConstant.Enrollee.FACULTY_ID));
                    enrollee.setCityId(resultSet.getLong(SQLFieldConstant.Enrollee.CITY_ID));
                    enrollee.setStatusId(resultSet.getLong(SQLFieldConstant.Enrollee.STATUS_ID));
                    enrollee.setUserId(resultSet.getLong(SQLFieldConstant.Enrollee.USER_ID));
                    enrolleeList.add(enrollee);
                }
                return enrolleeList;
            } catch (SQLException e) {
                throw new DAOException("Find enrollees error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public boolean create(Enrollee enrollee) throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement statement = connection.prepareStatement(SQLQueryConstant.CREATE_ENROLLEE)) {
                statement.setString(1, enrollee.getName());
                statement.setString(2, enrollee.getSurname());
                statement.setString(3, enrollee.getPatronymic());
                statement.setString(4, enrollee.getPhoneNumber());
                statement.setLong(5, enrollee.getFacultyId());
                statement.setLong(6, enrollee.getStatusId());
                statement.setLong(7, enrollee.getUserId());
                statement.setLong(8, enrollee.getCityId());
                statement.setString(9, enrollee.getPassport());
                statement.setInt(10, enrollee.getAvarageCertificateScore());
                statement.setInt(11, enrollee.getScoreOnCT());
                return statement.executeUpdate() == 1;

            } catch (SQLException e) {
                throw new DAOException("Create enrollee error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    public static final String UPDATE_ENROLLEE = "UPDATE enrollee SET name=?, surname=?, patronymic=?," +
            " phone_namber=?, faculty_id=?, status_id=?, user_id=?, city_id=? WHERE id=?";

    @Override
    public void update(by.sichnenko.committee.model.Enrollee enrollee) throws DAOException {
        ProxyConnection proxyConnection = null;
        try {
            proxyConnection = ConnectionPoolImpl.getInstance().takeConnection();

            try (PreparedStatement statement = proxyConnection.prepareStatement(SQLQueryConstant.UPDATE_USER)) {
                statement.setString(1, enrollee.getName());
                statement.setString(2, enrollee.getSurname());
                statement.setString(3, enrollee.getPatronymic());
                statement.setString(4, enrollee.getPhoneNumber());
                statement.setLong(5, enrollee.getFacultyId());
                statement.setLong(6, enrollee.getStatusId());
                statement.setLong(7, enrollee.getUserId());
                statement.setLong(8, enrollee.getCityId());
                statement.executeUpdate();

            } catch (SQLException e) {
                throw new DAOException("Update enrollee error ", e);
            }
        } finally {
            closeConnection(proxyConnection);
        }
    }

    @Override
    public void changeAllEnrolleesStatus(Long oldStatusId, Long newStatusId) throws DAOException {
        ProxyConnection proxyConnection = null;
        try {
            proxyConnection = ConnectionPoolImpl.getInstance().takeConnection();

            try (PreparedStatement statement = proxyConnection.prepareStatement(SQLQueryConstant.UPDATE_All_ENROLLEE_STATUS)) {
                statement.setLong(1, newStatusId);
                statement.setLong(2, oldStatusId);
                statement.executeUpdate();

            } catch (SQLException e) {
                throw new DAOException("Update enrollee error ", e);
            }
        } finally {
            closeConnection(proxyConnection);
        }
    }

    @Override
    public void changeStatus(Long enrolleeId, Long newStatusId) throws DAOException {
        ProxyConnection proxyConnection = null;
        try {
            proxyConnection = ConnectionPoolImpl.getInstance().takeConnection();

            try (PreparedStatement statement = proxyConnection.prepareStatement(SQLQueryConstant.UPDATE_ENROLLEE_STATUS)) {
                statement.setLong(1, newStatusId);
                statement.setLong(2, enrolleeId);
                statement.executeUpdate();

            } catch (SQLException e) {
                throw new DAOException("Update enrollee status error ", e);
            }
        } finally {
            closeConnection(proxyConnection);
        }
    }

    @Override
    public Enrollee findEnrolleeByUserId(Long userId) throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.SELECT_ENROLLEE_BY_USER_ID)) {
                preparedStatement.setLong(1,userId);
                ResultSet resultSet = preparedStatement.executeQuery();
                Enrollee enrollee = null;
                if (resultSet.next()) {
                    enrollee = new by.sichnenko.committee.model.Enrollee();
                    enrollee.setEnrolleeId(resultSet.getLong(SQLFieldConstant.Enrollee.ID));
                    enrollee.setName(resultSet.getString(SQLFieldConstant.Enrollee.NAME));
                    enrollee.setSurname(resultSet.getString(SQLFieldConstant.Enrollee.SURNAME));
                    enrollee.setPatronymic(resultSet.getString(SQLFieldConstant.Enrollee.PATRONYMIC));
                    enrollee.setPhoneNumber(resultSet.getString(SQLFieldConstant.Enrollee.PHONE_NUMBER));
                    enrollee.setFacultyId(resultSet.getLong(SQLFieldConstant.Enrollee.FACULTY_ID));
                    enrollee.setCityId(resultSet.getLong(SQLFieldConstant.Enrollee.CITY_ID));
                    enrollee.setStatusId(resultSet.getLong(SQLFieldConstant.Enrollee.STATUS_ID));
                    enrollee.setUserId(resultSet.getLong(SQLFieldConstant.Enrollee.USER_ID));
                }
                return enrollee;
            } catch (SQLException e) {
                throw new DAOException("Find enrollees error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

}
