package by.sichnenko.committee.service.impl;

import by.sichnenko.committee.constant.RequestNameConstant;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.dao.CityDAO;
import by.sichnenko.committee.dao.CountryDAO;
import by.sichnenko.committee.dao.impl.CityDAOImpl;
import by.sichnenko.committee.dao.impl.CountryDAOImpl;
import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.City;
import by.sichnenko.committee.model.Country;
import by.sichnenko.committee.service.CountryService;
import by.sichnenko.committee.validator.GeneralValidator;

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

    @Override
    public void addCountry(SessionRequestContent sessionRequestContent) throws ServiceException {
        CountryDAO countryDAO = new CountryDAOImpl();
        String[] countryName = sessionRequestContent.getRequestParameters().get(RequestNameConstant.COUNTRY_NAME);
        if (GeneralValidator.isVarExist(countryName)) {
            try {
                Country country = new Country();
                country.setName(countryName[0]);
                countryDAO.create(country);
            } catch (DAOException e) {
                throw new ServiceException("Sorry, technical error", e);
            }
        }
        throw new ServiceException("Sorry, technical error");
    }
}
