package by.sichnenko.committee.dao.impl;

import by.sichnenko.committee.connection.ConnectionPoolImpl;
import by.sichnenko.committee.connection.ProxyConnection;
import by.sichnenko.committee.constant.SQLFieldConstant;
import by.sichnenko.committee.constant.SQLQueryConstant;
import by.sichnenko.committee.dao.SubjectDAO;
import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.model.Country;
import by.sichnenko.committee.model.Subject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public boolean create(Subject item) throws DAOException {
        return false;
    }

    @Override
    public void update(Subject item) throws DAOException {

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
    public void addSubjectsForFaculty(Long facultyId,List<Long> subjectsId) throws DAOException {
        ProxyConnection connection ;

        connection = ConnectionPoolImpl.getInstance().takeConnection();
        for (Long subjectId : subjectsId) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.INSERT_SUBJECTS_FOR_FACULTY)) {
                preparedStatement.setLong(1, subjectId);
                preparedStatement.setLong(2, facultyId);

                preparedStatement.execute();
            } catch (SQLException e) {
                throw new DAOException("Find subjects error ", e);
            } finally {
                closeConnection(connection);
            }
        }
    }

    @Override
    public Subject findSubjectByName(String subjectName) throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.SELECT_SUBJECT_BY_NAME)) {
                preparedStatement.setString(1, subjectName);
                ResultSet resultSet = preparedStatement.executeQuery();
                Subject subject = new Subject();
                if (resultSet.next()) {
                    subject.setSubjectId(resultSet.getLong(SQLFieldConstant.ID));
                    subject.setName(resultSet.getString(SQLFieldConstant.NAME));
                }
                return subject;
            } catch (SQLException e) {
                throw new DAOException("Find subjects error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }
}
