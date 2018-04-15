package by.sichnenko.committee.service;

import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> findAllCountries(SessionRequestContent sessionRequestContent) throws ServiceException;
}
