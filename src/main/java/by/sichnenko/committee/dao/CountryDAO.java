package by.sichnenko.committee.dao;

import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.model.Country;

public interface CountryDAO extends DAO<Country> {
    Country findCountryByName(String countrName) throws DAOException;
}
