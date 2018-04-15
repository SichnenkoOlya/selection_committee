package by.sichnenko.committee.service;

import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.City;


import java.util.List;

public interface CityService {
    List<City> findAllCities(SessionRequestContent sessionRequestContent) throws ServiceException;

}
