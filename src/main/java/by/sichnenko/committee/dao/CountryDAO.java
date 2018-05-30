package by.sichnenko.committee.dao;

import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.model.Country;

/**
 * The interface CountryDAO
 *
 * @see DAO
 * @see Country
 */
public interface CountryDAO extends DAO<Country> {
    /**
     * Find country by name
     *
     * @param countryName name of the country
     * @return country
     * @throws DAOException when sql exception occurs
     */
    Country findCountryByName(String countryName) throws DAOException;
}
