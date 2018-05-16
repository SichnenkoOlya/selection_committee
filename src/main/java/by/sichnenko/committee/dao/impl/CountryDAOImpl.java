package by.sichnenko.committee.dao.impl;

import by.sichnenko.committee.connection.ConnectionPoolImpl;
import by.sichnenko.committee.connection.ProxyConnection;
import by.sichnenko.committee.constant.SQLFieldConstant;
import by.sichnenko.committee.constant.SQLQueryConstant;
import by.sichnenko.committee.dao.CountryDAO;
import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.model.Country;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDAOImpl implements CountryDAO {
    @Override
    public List<Country> findAll() throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.SELECT_ALL_COUNTRIES)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                List<Country> countries = new ArrayList<>();
                while (resultSet.next()) {
                    Country country = new Country();
                    country.setCountryId(resultSet.getLong(SQLFieldConstant.ID));
                    country.setName(resultSet.getString(SQLFieldConstant.NAME));
                    countries.add(country);
                }
                return countries;
            } catch (SQLException e) {
                throw new DAOException("Find countries error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void create(Country country) throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.CREATE_COUNTRY)) {
                preparedStatement.setString(1, country.getName());
                preparedStatement.execute();
            } catch (SQLException e) {
                throw new DAOException("Create country error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(Country item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Country findCountryByName(String countrName) throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.SELECT_COUNTRY_BY_NAME)) {
                preparedStatement.setString(1, countrName);
                ResultSet resultSet = preparedStatement.executeQuery();
                Country country = null;
                if (resultSet.next()) {
                    country=new Country();
                    country.setCountryId(resultSet.getLong(SQLFieldConstant.ID));
                    country.setName(resultSet.getString(SQLFieldConstant.NAME));
                }
                return country;
            } catch (SQLException e) {
                throw new DAOException("Find country error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }
}
