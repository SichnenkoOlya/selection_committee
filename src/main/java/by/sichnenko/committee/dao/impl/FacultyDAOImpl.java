package by.sichnenko.committee.dao.impl;

import by.sichnenko.committee.connection.ConnectionPoolImpl;
import by.sichnenko.committee.connection.ProxyConnection;
import by.sichnenko.committee.constant.SQLFieldConstant;
import by.sichnenko.committee.constant.SQLQueryConstant;
import by.sichnenko.committee.dao.FacultyDAO;
import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.model.Faculty;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacultyDAOImpl implements FacultyDAO {

    @Override
    public Faculty findFacultyById(Long facultyId) throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.SELECT_FACULTY_BY_ID)) {
                preparedStatement.setLong(1, facultyId);
                ResultSet resultSet = preparedStatement.executeQuery();
                return extractFaculty(resultSet);
            } catch (SQLException e) {
                throw new DAOException("Find faculty error ", e);
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
                return extractFaculty(resultSet);
            } catch (SQLException e) {
                throw new DAOException("Find faculty error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void updateImage(Long facultyId, String imagePath) throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.UPDATE_FACULTY_IMAGE)) {
                preparedStatement.setString(1, imagePath);
                preparedStatement.setLong(2, facultyId);

                preparedStatement.execute();
            } catch (SQLException e) {
                throw new DAOException("Update faculty image error ", e);
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
                    faculty.setBudjetPlaceCount(resultSet.getInt(SQLFieldConstant.Faculty.BUDJET_PLACE_COUNT));
                    faculty.setTotalPlaceCount(resultSet.getInt(SQLFieldConstant.Faculty.TOTAL_PLACE_COUNT));
                    faculty.setIsFinish(resultSet.getBoolean(SQLFieldConstant.Faculty.IS_FINISH));
                    faculties.add(faculty);
                }
                return faculties;
            } catch (SQLException e) {
                throw new DAOException("Find faculties error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void create(Faculty faculty) throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.CREATE_FACULTY)) {
                preparedStatement.setString(1, faculty.getName());
                preparedStatement.setInt(2, faculty.getBudjetPlaceCount());
                preparedStatement.setInt(3, faculty.getTotalPlaceCount());
                preparedStatement.setString(4, faculty.getDescription());
                preparedStatement.setDate(5, new Date(faculty.getFinishDate().getTime()));
                preparedStatement.execute();
            } catch (SQLException e) {
                throw new DAOException("Create faculty error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void updateScore(Faculty faculty) throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.UPDATE_FACULTY_SCORE)) {
                preparedStatement.setInt(1, faculty.getPassingScoreBudjet());
                preparedStatement.setInt(2, faculty.getPassingScorePaid());
                preparedStatement.setLong(3, faculty.getFacultyId());
                preparedStatement.execute();
            } catch (SQLException e) {
                throw new DAOException("Update faculty's scores error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void updateIsFinish(Boolean newValue, Long facultyId) throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.UPDATE_FACULTY_IS_FINISH)) {
                preparedStatement.setBoolean(1, newValue);
                preparedStatement.setLong(2, facultyId);
                preparedStatement.execute();
            } catch (SQLException e) {
                throw new DAOException("Update faculty's scores error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Faculty> findAllAvaliableFaculties() throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.SELECT_ALL_AVALIABLE_FACULTIES)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                List<Faculty> faculties = new ArrayList<>();
                while (resultSet.next()) {
                    Faculty faculty = new Faculty();
                    faculty.setFacultyId(resultSet.getLong(SQLFieldConstant.ID));
                    faculty.setName(resultSet.getString(SQLFieldConstant.NAME));
                    faculty.setImagePath(resultSet.getString(SQLFieldConstant.IMAGE_PATH));
                    faculty.setDescription(resultSet.getString(SQLFieldConstant.DESCRIPTION));
                    faculty.setBudjetPlaceCount(resultSet.getInt(SQLFieldConstant.Faculty.BUDJET_PLACE_COUNT));
                    faculty.setTotalPlaceCount(resultSet.getInt(SQLFieldConstant.Faculty.TOTAL_PLACE_COUNT));
                    faculty.setIsFinish(resultSet.getBoolean(SQLFieldConstant.Faculty.IS_FINISH));
                    faculty.setFinishDate(resultSet.getDate(SQLFieldConstant.Faculty.FINISH_DATE));
                    faculties.add(faculty);
                }
                return faculties;
            } catch (SQLException e) {
                throw new DAOException("Find faculties error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(Faculty faculty) {
        //TODO: нормально ли такое бросать?
        throw new UnsupportedOperationException();
    }

    private Faculty extractFaculty(ResultSet resultSet) throws SQLException {
        Faculty faculty = null;
        if (resultSet.next()) {
            faculty = new Faculty();
            faculty.setFacultyId(resultSet.getLong(SQLFieldConstant.ID));
            faculty.setName(resultSet.getString(SQLFieldConstant.NAME));
            faculty.setImagePath(resultSet.getString(SQLFieldConstant.IMAGE_PATH));
            faculty.setDescription(resultSet.getString(SQLFieldConstant.DESCRIPTION));
            faculty.setBudjetPlaceCount(resultSet.getInt(SQLFieldConstant.Faculty.BUDJET_PLACE_COUNT));
            faculty.setTotalPlaceCount(resultSet.getInt(SQLFieldConstant.Faculty.TOTAL_PLACE_COUNT));
            faculty.setPaidPlaceCount(faculty.getTotalPlaceCount() - faculty.getBudjetPlaceCount());
            faculty.setPassingScoreBudjet(resultSet.getShort(SQLFieldConstant.Faculty.PASSING_SCORE_BUDJET));
            faculty.setPassingScorePaid(resultSet.getShort(SQLFieldConstant.Faculty.PASSING_SCORE_PAID));
            faculty.setFinishDate(resultSet.getDate(SQLFieldConstant.Faculty.FINISH_DATE));
            faculty.setIsFinish(resultSet.getBoolean(SQLFieldConstant.Faculty.IS_FINISH));
        }
        return faculty;
    }
}
