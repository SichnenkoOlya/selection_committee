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
    public Faculty findFacultyById(Long facultyId) throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.SELECT_FACULTY_BY_ID)) {
                preparedStatement.setLong(1, facultyId);
                ResultSet resultSet = preparedStatement.executeQuery();
                Faculty faculty=new Faculty();
                if (resultSet.next()) {
                    faculty.setFacultyId(resultSet.getLong(SQLFieldConstant.ID));
                    faculty.setName(resultSet.getString(SQLFieldConstant.NAME));
                    faculty.setImagePath(resultSet.getString(SQLFieldConstant.IMAGE_PATH));
                    faculty.setDescription(resultSet.getString(SQLFieldConstant.DESCRIPTION));
                    faculty.setBudjetPlaceCount(resultSet.getInt(SQLFieldConstant.Faculty.BUDJET_PLACE_COUNT));
                    faculty.setTotalPlaceCount(resultSet.getInt(SQLFieldConstant.Faculty.TOTAL_PLACE_COUNT));
                    faculty.setPaidPlaceCount(faculty.getTotalPlaceCount()-faculty.getBudjetPlaceCount());
                    faculty.setPassingScoreBudjet(resultSet.getShort(SQLFieldConstant.Faculty.PASSING_SCORE_BUDJET));
                    faculty.setPassingScorePaid(resultSet.getShort(SQLFieldConstant.Faculty.PASSING_SCORE_PAID));
                }
                return faculty;
            } catch (SQLException e) {
                throw new DAOException("Find privileges error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public Faculty findFacultyByName(String facultyName) throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.SELECT_FACULTY_BY_NAME)) {
                preparedStatement.setString(1, facultyName);
                ResultSet resultSet = preparedStatement.executeQuery();
                Faculty faculty=new Faculty();
                if (resultSet.next()) {
                    faculty.setFacultyId(resultSet.getLong(SQLFieldConstant.ID));
                    faculty.setName(resultSet.getString(SQLFieldConstant.NAME));
                    faculty.setImagePath(resultSet.getString(SQLFieldConstant.IMAGE_PATH));
                    faculty.setDescription(resultSet.getString(SQLFieldConstant.DESCRIPTION));
                    faculty.setBudjetPlaceCount(resultSet.getInt(SQLFieldConstant.Faculty.BUDJET_PLACE_COUNT));
                    faculty.setTotalPlaceCount(resultSet.getInt(SQLFieldConstant.Faculty.TOTAL_PLACE_COUNT));
                    faculty.setPaidPlaceCount(faculty.getTotalPlaceCount()-faculty.getBudjetPlaceCount());
                    faculty.setPassingScoreBudjet(resultSet.getShort(SQLFieldConstant.Faculty.PASSING_SCORE_BUDJET));
                    faculty.setPassingScorePaid(resultSet.getShort(SQLFieldConstant.Faculty.PASSING_SCORE_PAID));
                }
                return faculty;
            } catch (SQLException e) {
                throw new DAOException("Find privileges error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void upfdateImage(Long facultyId, String imagePath) throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.UPDATE_FACULTY_IMAGE)) {
                preparedStatement.setString(1, imagePath);
                preparedStatement.setLong(2, facultyId);

                preparedStatement.execute();
            } catch (SQLException e) {
                throw new DAOException("Find privileges error ", e);
            }
        } finally {
            closeConnection(connection);
        }
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
                    faculty.setImagePath(resultSet.getString(SQLFieldConstant.IMAGE_PATH));
                    faculty.setDescription(resultSet.getString(SQLFieldConstant.DESCRIPTION));

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
    public boolean create(Faculty faculty) throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.CREATE_FACULTY)) {
                preparedStatement.setString(1, faculty.getName());
                preparedStatement.setInt(2, faculty.getBudjetPlaceCount());
                preparedStatement.setInt(3, faculty.getTotalPlaceCount());
                preparedStatement.setString(4, faculty.getDescription());
                preparedStatement.execute();
                return true;
            } catch (SQLException e) {
                throw new DAOException("Find privileges error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(Faculty item) throws DAOException {

    }
}
