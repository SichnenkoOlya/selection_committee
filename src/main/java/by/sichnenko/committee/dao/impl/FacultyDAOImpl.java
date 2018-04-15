package by.sichnenko.committee.dao.impl;

import by.sichnenko.committee.connection.ConnectionPoolImpl;
import by.sichnenko.committee.connection.ProxyConnection;
import by.sichnenko.committee.constant.SQLFieldConstant;
import by.sichnenko.committee.constant.SQLQueryConstant;
import by.sichnenko.committee.dao.FacultyDAO;
import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.model.Enrollee;
import by.sichnenko.committee.model.Faculty;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacultyDAOImpl implements FacultyDAO {
    @Override
    public List<Enrollee> findAllUsers() {
        return null;
    }

    @Override
    public List<Faculty> findAll() throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.SELECT_ALL_FACULTIES)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                List<Faculty> faculties = new ArrayList<>();
                while (resultSet.next()) {
                    Faculty faculty = new Faculty();
                    faculty.setFacultyId(resultSet.getLong(SQLFieldConstant.ID));
                    faculty.setName(resultSet.getString(SQLFieldConstant.NAME));
                    faculties.add(faculty);
                }
                return faculties;
            } catch (SQLException e) {
                throw new DAOException("Find privileges error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public boolean create(Faculty item) throws DAOException {
        return false;
    }

    @Override
    public void update(Faculty item) throws DAOException {

    }
}
