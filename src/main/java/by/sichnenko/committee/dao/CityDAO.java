package by.sichnenko.committee.dao;

import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.model.City;

import java.util.List;

/**
 * The interface CityDAO
 *
 * @see DAO
 * @see City
 */
public interface CityDAO extends DAO<City> {
    /**
     * Find city by name
     *
     * @param name name of the city
     * @return list of cities
     * @throws DAOException when sql exception occurs
     */
    List<City> findCitiesByName(String name) throws DAOException;

    /**
     * Find city by id of the country
     *
     * @param countryId id of the country
     * @return list of cities
     * @throws DAOException when sql exception occurs
     */
    List<City> findCitiesByCountryId(Long countryId) throws DAOException;
}
