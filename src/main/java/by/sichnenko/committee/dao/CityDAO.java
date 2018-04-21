package by.sichnenko.committee.dao;

import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.model.City;

import java.util.List;

public interface CityDAO extends DAO<City> {
    City findCityByName(String name) throws DAOException;

    List<City> findCitiesByCountryId(Long countryId) throws DAOException;
}
