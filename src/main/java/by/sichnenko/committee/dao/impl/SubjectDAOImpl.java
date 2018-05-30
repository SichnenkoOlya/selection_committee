package by.sichnenko.committee.dao.impl;

import by.sichnenko.committee.connection.ConnectionPoolImpl;
import by.sichnenko.committee.connection.ProxyConnection;
import by.sichnenko.committee.constant.SQLFieldConstant;
import by.sichnenko.committee.constant.SQLQueryConstant;
import by.sichnenko.committee.dao.SubjectDAO;
import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.model.Subject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The SubjectDAOImpl class. Implementation of interface SubjectDAO.
 *
 * @see SubjectDAO
 * @see Subject
 */
public class SubjectDAOImpl implements SubjectDAO {

    @Override
    public List<Subject> findAll() throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.SELECT_ALL_SUBJECTS)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                List<Subject> subjects = new ArrayList<>();
                while (resultSet.next()) {
                    Subject subject = new Subject();
                    subject.setSubjectId(resultSet.getLong(SQLFieldConstant.ID));
                    subject.setName(resultSet.getString(SQLFieldConstant.NAME));
                    subjects.add(subject);
                }
                return subjects;
            } catch (SQLException e) {
                throw new DAOException("Find subjects error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void create(Subject item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Subject item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Subject> findSubjetsForFaculty(Long facultyId) throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.SELECT_SUBJECTS_FOR_FACULTY)) {
                preparedStatement.setLong(1, facultyId);
                ResultSet resultSet = preparedStatement.executeQuery();
                List<Subject> subjects = new ArrayList<>();
                while (resultSet.next()) {
                    Subject subject = new Subject();
                    subject.setSubjectId(resultSet.getLong(SQLFieldConstant.ID));
                    subject.setName(resultSet.getString(SQLFieldConstant.NAME));
                    subject.setGroupNumber(resultSet.getShort(SQLFieldConstant.Subject.GROUP_NUMBER));
                    subjects.add(subject);
                }
                return subjects;
            } catch (SQLException e) {
                throw new DAOException("Find subjects error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void addSubjectsForEnrollee(Long enrolleeId, List<Long> subjectsId) throws DAOException {
        ProxyConnection connection;

        connection = ConnectionPoolImpl.getInstance().takeConnection();
        for (Long subjectId : subjectsId) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.INSERT_SUBJECTS_FOR_ENROLLEE)) {
                preparedStatement.setLong(1, subjectId);
                preparedStatement.setLong(2, enrolleeId);
                preparedStatement.execute();
            } catch (SQLException e) {
                throw new DAOException("Add subjects for enrollee error ", e);
            } finally {
                closeConnection(connection);
            }
        }
    }

    @Override
    public void deleteSubjectsForEnrollee(Long enrolleeId) throws DAOException {
        ProxyConnection connection;

        connection = ConnectionPoolImpl.getInstance().takeConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.DELETE_SUBJECTS_FOR_ENROLLEE)) {
            preparedStatement.setLong(1, enrolleeId);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DAOException("Add subjects for enrollee error ", e);
        } finally {
            closeConnection(connection);
        }

    }

    @Override
    public void addSubjectsForFaculty(Long facultyId, List<Long> subjectsId) throws DAOException {
        ProxyConnection connection;

        connection = ConnectionPoolImpl.getInstance().takeConnection();
        for (Long subjectId : subjectsId) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.INSERT_SUBJECTS_FOR_FACULTY)) {
                preparedStatement.setLong(1, subjectId);
                preparedStatement.setLong(2, facultyId);
                preparedStatement.execute();
            } catch (SQLException e) {
                throw new DAOException("Add subjects for faculty error ", e);
            } finally {
                closeConnection(connection);
            }
        }
    }
}
