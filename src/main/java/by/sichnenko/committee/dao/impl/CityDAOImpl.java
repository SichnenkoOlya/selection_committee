package by.sichnenko.committee.dao.impl;

import by.sichnenko.committee.connection.ConnectionPoolImpl;
import by.sichnenko.committee.connection.ProxyConnection;
import by.sichnenko.committee.constant.SQLFieldConstant;
import by.sichnenko.committee.constant.SQLQueryConstant;
import by.sichnenko.committee.dao.CityDAO;
import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.model.City;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * The CityDAOImpl class. Implementation of interface CityDAO.
 *
 * @see CityDAO
 * @see City
 */
public class CityDAOImpl implements CityDAO {
    @Override
    public List<City> findAll() throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.SELECT_ALL_CITIES)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                return extractCities(resultSet);
            } catch (SQLException e) {
                throw new DAOException("Find countries error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void create(City city) throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.CREATE_CITY)) {
                preparedStatement.setString(1, city.getName());
                preparedStatement.setLong(2, city.getCountryId());
                preparedStatement.execute();
            } catch (SQLException e) {
                throw new DAOException("Find countries error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(City item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<City> findCitiesByName(String name) throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();

            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.SELECT_CITY_BY_NAME)) {
                preparedStatement.setString(1, name);
                ResultSet resultSet = preparedStatement.executeQuery();
                return extractCities(resultSet);
            } catch (SQLException e) {
                throw new DAOException("Find city error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<City> findCitiesByCountryId(Long countryId) throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();

            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.SELECT_CITY_BY_COUNTRY_ID)) {
                preparedStatement.setLong(1, countryId);
                ResultSet resultSet = preparedStatement.executeQuery();

                return extractCities(resultSet);
            } catch (SQLException e) {
                throw new DAOException("Find city error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    private List<City> extractCities(ResultSet resultSet) throws SQLException {
        List<City> cities = new ArrayList<>();
        while (resultSet.next()) {
            City city = new City();
            city.setCityId(resultSet.getLong(SQLFieldConstant.ID));
            city.setName(resultSet.getString(SQLFieldConstant.NAME));
            city.setCountryId(resultSet.getLong(SQLFieldConstant.City.COUNTRY_ID));
            cities.add(city);
        }
        return cities;
    }
}
