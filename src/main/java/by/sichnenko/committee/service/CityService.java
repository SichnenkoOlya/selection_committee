package by.sichnenko.committee.service;

import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.City;

import java.util.List;

/**
 * The interface CityService
 */
public interface CityService {
    /**
     * Add new city
     *
     * @param sessionRequestContent request content
     * @throws ServiceException the service exception
     */
    void addCity(SessionRequestContent sessionRequestContent) throws ServiceException;

    /**
     * Find all cities
     *
     * @return list of cities
     * @throws ServiceException the service exception
     */
    List<City> findAllCities() throws ServiceException;

    /**
     * Find cities by country id
     *
     * @param sessionRequestContent request content
     * @return list of cities
     * @throws ServiceException the service exception
     */
    List<City> findCitiesByCountryId(SessionRequestContent sessionRequestContent) throws ServiceException;
}
