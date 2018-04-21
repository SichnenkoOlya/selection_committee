package by.sichnenko.committee.service.impl;

import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.dao.CountryDAO;
import by.sichnenko.committee.dao.impl.CountryDAOImpl;
import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Country;
import by.sichnenko.committee.service.CountryService;

import java.util.List;

public class CountryServiceImpl implements CountryService {
    @Override
    public List<Country> findAllCountries() throws ServiceException {
        CountryDAO countryDAO;
        try {
            countryDAO = new CountryDAOImpl();
            return countryDAO.findAll();
        } catch (DAOException e) {
            throw new ServiceException("Sorry, technical error", e);
        }
    }
}
