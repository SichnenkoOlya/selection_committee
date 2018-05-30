package by.sichnenko.committee.service;

import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Country;

import java.util.List;

/**
 * The interface CountryService
 */
public interface CountryService {
    /**
     * Find all countries service
     *
     * @return list if countries
     * @throws ServiceException the service exception
     */
    List<Country> findAllCountries() throws ServiceException;

    /**
     * Add new country
     *
     * @param sessionRequestContent request content
     * @throws ServiceException the service exception
     */
    void addCountry(SessionRequestContent sessionRequestContent) throws ServiceException;
}
