package by.sichnenko.committee.dao.impl;

import by.sichnenko.committee.connection.ConnectionPoolImpl;
import by.sichnenko.committee.connection.ProxyConnection;
import by.sichnenko.committee.constant.SQLFieldConstant;
import by.sichnenko.committee.constant.SQLQueryConstant;
import by.sichnenko.committee.dao.CountryDAO;
import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.model.Country;
import by.sichnenko.committee.model.RoleType;
import by.sichnenko.committee.model.User;

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
    public boolean create(Country country) throws DAOException {
        ProxyConnection connection = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            try (PreparedStatement preparedStatement = connection.prepareStatement(SQLQueryConstant.CREATE_COUNTRY)) {
                preparedStatement.setString(1,country.getName());
                preparedStatement.execute();
                return true;
            } catch (SQLException e) {
                throw new DAOException("Find countries error ", e);
            }
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(Country item) throws DAOException {

    }
}
