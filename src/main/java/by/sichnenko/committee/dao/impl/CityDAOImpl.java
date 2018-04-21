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

public class  CityDAOImpl implements CityDAO {
    @Override
    public List<City> findAll() throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.SELECT_ALL_CITIES)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                List<City> cities = new ArrayList<>();
                while (resultSet.next()) {
                    City city = new City();
                    city.setCityId(resultSet.getLong(SQLFieldConstant.ID));
                    city.setName(resultSet.getString(SQLFieldConstant.NAME));
                    city.setCountryId(resultSet.getLong(SQLFieldConstant.City.COUNTRY_ID));
                    cities.add(city);
                }
                return cities;
            } catch (SQLException e) {
                throw new DAOException("Find countries error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public boolean create(City item) throws DAOException {
        return false;
    }

    @Override
    public void update(City item) throws DAOException {

    }

    @Override
    public City findCityByName(String name) throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();

            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.SELECT_CITY_BY_NAME)) {
                preparedStatement.setString(1, name);
                ResultSet resultSet = preparedStatement.executeQuery();
                City city = new City();
                if (resultSet.next()) {
                    city.setCityId(resultSet.getLong(SQLFieldConstant.ID));
                    city.setName(resultSet.getString(SQLFieldConstant.NAME));
                    city.setCountryId(resultSet.getLong(SQLFieldConstant.City.COUNTRY_ID));
                }
                return city;
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
                List<City> cities=new ArrayList<>();
                while (resultSet.next()) {
                    City city = new City();
                    city.setCityId(resultSet.getLong(SQLFieldConstant.ID));
                    city.setName(resultSet.getString(SQLFieldConstant.NAME));
                    city.setCountryId(resultSet.getLong(SQLFieldConstant.City.COUNTRY_ID));
                    cities.add(city);
                }
                return cities;
            } catch (SQLException e) {
                throw new DAOException("Find city error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }
}
