package by.sichnenko.committee.service;

import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.City;


import java.util.List;

public interface CityService {
    void addCity(SessionRequestContent sessionRequestContent) throws ServiceException;
    List<City> findAllCities() throws ServiceException;
    List<City> findCitiesByCountryId(SessionRequestContent sessionRequestContent) throws ServiceException;
}
