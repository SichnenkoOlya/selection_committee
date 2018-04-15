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
}
