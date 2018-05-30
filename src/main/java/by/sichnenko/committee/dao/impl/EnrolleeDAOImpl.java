package by.sichnenko.committee.dao.impl;

import by.sichnenko.committee.connection.ConnectionPoolImpl;
import by.sichnenko.committee.connection.ProxyConnection;
import by.sichnenko.committee.constant.SQLFieldConstant;
import by.sichnenko.committee.constant.SQLQueryConstant;
import by.sichnenko.committee.dao.EnrolleeDAO;
import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.model.Enrollee;
import by.sichnenko.committee.model.Faculty;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The EnrolleeDAOImpl class. Implementation of interface EnrolleeDAO.
 *
 * @see EnrolleeDAO
 * @see Enrollee
 */
public class EnrolleeDAOImpl implements EnrolleeDAO {
    @Override
    public List<Enrollee> findAll() throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.SELECT_ALL_ENROLLEES)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                List<Enrollee> enrolleeList = new ArrayList<>();
                while (resultSet.next()) {
                    Enrollee enrollee = new Enrollee();
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
    public void create(Enrollee enrollee) throws DAOException {
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
                statement.executeUpdate();

            } catch (SQLException e) {
                throw new DAOException("Create enrollee error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(Enrollee enrollee) throws DAOException {
        ProxyConnection proxyConnection = null;
        try {
            proxyConnection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement statement = proxyConnection.prepareStatement(SQLQueryConstant.UPDATE_ENROLLEE)) {
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
                statement.setString(12, enrollee.getInfoMessage());
                statement.setLong(13, enrollee.getEnrolleeId());
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
    public void changeStatus(Long enrolleeId, Long newStatusId, String message) throws DAOException {
        ProxyConnection proxyConnection = null;
        try {
            proxyConnection = ConnectionPoolImpl.getInstance().takeConnection();

            try (PreparedStatement statement = proxyConnection.prepareStatement(SQLQueryConstant.UPDATE_ENROLLEE_STATUS)) {
                statement.setLong(1, newStatusId);
                statement.setString(2, message);
                statement.setLong(3, enrolleeId);
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
                preparedStatement.setLong(1, userId);
                ResultSet resultSet = preparedStatement.executeQuery();
                Enrollee enrollee = null;
                if (resultSet.next()) {
                    enrollee = new Enrollee();
                    enrollee.setEnrolleeId(resultSet.getLong(SQLFieldConstant.Enrollee.ID));
                    enrollee.setName(resultSet.getString(SQLFieldConstant.Enrollee.NAME));
                    enrollee.setSurname(resultSet.getString(SQLFieldConstant.Enrollee.SURNAME));
                    enrollee.setPatronymic(resultSet.getString(SQLFieldConstant.Enrollee.PATRONYMIC));
                    enrollee.setPhoneNumber(resultSet.getString(SQLFieldConstant.Enrollee.PHONE_NUMBER));
                    enrollee.setFacultyId(resultSet.getLong(SQLFieldConstant.Enrollee.FACULTY_ID));
                    enrollee.setCityId(resultSet.getLong(SQLFieldConstant.Enrollee.CITY_ID));
                    enrollee.setStatusId(resultSet.getLong(SQLFieldConstant.Enrollee.STATUS_ID));
                    enrollee.setUserId(resultSet.getLong(SQLFieldConstant.Enrollee.USER_ID));
                    enrollee.setAvarageCertificateScore(resultSet.getInt(SQLFieldConstant.Enrollee.AVERAGE_CERTIVICATE_SCORE));
                    enrollee.setScoreOnCT(resultSet.getInt(SQLFieldConstant.Enrollee.SCORE_ON_CT));
                    enrollee.setInfoMessage(resultSet.getString(SQLFieldConstant.Enrollee.MESSAGE));
                }
                return enrollee;
            } catch (SQLException e) {
                throw new DAOException("Find enrollees error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Enrollee> findEnrolleesEnteredFacultyBudjet(Faculty faculty) throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.SELECT_ENROLLE_ENTERED_ON_FACULTY)) {
                preparedStatement.setLong(1, faculty.getFacultyId());
                preparedStatement.setInt(2, 0);
                preparedStatement.setInt(3, faculty.getBudjetPlaceCount());
                ResultSet resultSet = preparedStatement.executeQuery();
                List<Enrollee> enrolleeList = new ArrayList<>();
                while (resultSet.next()) {
                    Enrollee enrollee = new Enrollee();
                    enrollee.setEnrolleeId(resultSet.getLong(SQLFieldConstant.Enrollee.ID));
                    enrollee.setName(resultSet.getString(SQLFieldConstant.Enrollee.NAME));
                    enrollee.setSurname(resultSet.getString(SQLFieldConstant.Enrollee.SURNAME));
                    enrollee.setPatronymic(resultSet.getString(SQLFieldConstant.Enrollee.PATRONYMIC));
                    enrollee.setPhoneNumber(resultSet.getString(SQLFieldConstant.Enrollee.PHONE_NUMBER));
                    enrollee.setAvarageCertificateScore(resultSet.getInt(SQLFieldConstant.Enrollee.AVERAGE_CERTIVICATE_SCORE));
                    enrollee.setScoreOnCT(resultSet.getInt(SQLFieldConstant.Enrollee.SCORE_ON_CT));
                    enrollee.setUserId(resultSet.getLong(SQLFieldConstant.Enrollee.USER_ID));
                    enrollee.setFacultyId(resultSet.getLong(SQLFieldConstant.Enrollee.FACULTY_ID));
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
    public List<Long> findSubjectsForEnrollee(Long enrolleeId) throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.SELECT_SUBJECTS_FOR_ENROLLEE)) {
                preparedStatement.setLong(1, enrolleeId);
                ResultSet resultSet = preparedStatement.executeQuery();
                List<Long> subjectsId = new ArrayList<>();
                while (resultSet.next()) {
                    Long subjectId=resultSet.getLong(SQLFieldConstant.Subject.SUBJECT_ID);
                    subjectsId.add(subjectId);
                }
                return subjectsId;
            } catch (SQLException e) {
                throw new DAOException("Find subjects error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Enrollee> findEnrolleesEnteredFacultyPaid(Faculty faculty) throws DAOException {

        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.SELECT_ENROLLE_ENTERED_ON_FACULTY)) {
                preparedStatement.setLong(1, faculty.getFacultyId());
                preparedStatement.setInt(2, faculty.getBudjetPlaceCount());
                preparedStatement.setInt(3, faculty.getBudjetPlaceCount() + faculty.getPaidPlaceCount());
                ResultSet resultSet = preparedStatement.executeQuery();
                return extractEnrollees(resultSet);
            } catch (SQLException e) {
                throw new DAOException("Find enrollees error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Enrollee> findEnrolleesNotEntered(Faculty faculty) throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.SELECT_ENROLLE_NOT_ENTERED_ON_FACULTY)) {
                preparedStatement.setLong(1, faculty.getFacultyId());
                ResultSet resultSet = preparedStatement.executeQuery();
                return extractEnrollees(resultSet);
            } catch (SQLException e) {
                throw new DAOException("Find enrollees error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    private List<Enrollee> extractEnrollees(ResultSet resultSet) throws SQLException {
        List<Enrollee> enrolleeList = new ArrayList<>();
        while (resultSet.next()) {
            Enrollee enrollee = new Enrollee();
            enrollee.setEnrolleeId(resultSet.getLong(SQLFieldConstant.Enrollee.ID));
            enrollee.setName(resultSet.getString(SQLFieldConstant.Enrollee.NAME));
            enrollee.setSurname(resultSet.getString(SQLFieldConstant.Enrollee.SURNAME));
            enrollee.setPatronymic(resultSet.getString(SQLFieldConstant.Enrollee.PATRONYMIC));
            enrollee.setPhoneNumber(resultSet.getString(SQLFieldConstant.Enrollee.PHONE_NUMBER));
            enrollee.setAvarageCertificateScore(resultSet.getInt(SQLFieldConstant.Enrollee.AVERAGE_CERTIVICATE_SCORE));
            enrollee.setScoreOnCT(resultSet.getInt(SQLFieldConstant.Enrollee.SCORE_ON_CT));
            enrollee.setUserId(resultSet.getLong(SQLFieldConstant.Enrollee.USER_ID));
            enrolleeList.add(enrollee);
        }
        return enrolleeList;
    }

}
