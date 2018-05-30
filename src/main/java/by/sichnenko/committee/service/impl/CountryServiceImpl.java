package by.sichnenko.committee.service.impl;

import by.sichnenko.committee.constant.GeneralConstant;
import by.sichnenko.committee.constant.RequestNameConstant;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.dao.CountryDAO;
import by.sichnenko.committee.dao.impl.CountryDAOImpl;
import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Country;
import by.sichnenko.committee.service.CountryService;
import by.sichnenko.committee.validator.GeneralValidator;

import java.util.List;

/**
 * The CountryServiceImpl class. Implementation of interface CountryService.
 *
 * @see CountryService
 * @see Country
 */
public class CountryServiceImpl implements CountryService {
    @Override
    public List<Country> findAllCountries() throws ServiceException {
        ;
        try {
            CountryDAO countryDAO = new CountryDAOImpl();
            return countryDAO.findAll();
        } catch (DAOException e) {
            throw new ServiceException("Find countries error ", e);
        }
    }

    @Override
    public void addCountry(SessionRequestContent sessionRequestContent) throws ServiceException {
        String[] countryName = sessionRequestContent.getRequestParameters().get(RequestNameConstant.COUNTRY_NAME);
        if (GeneralValidator.isVarExist(countryName)) {
            try {
                CountryDAO countryDAO = new CountryDAOImpl();
                Country existCountry = countryDAO.findCountryByName(countryName[0]);
                if (existCountry != null) {
                    sessionRequestContent.getRequestAttributes().put(GeneralConstant.COUNTRY_EXIST, true);
                    throw new ServiceException("Country already exist ");
                }
                Country country = new Country();
                country.setName(countryName[0]);
                countryDAO.create(country);
            } catch (DAOException e) {
                throw new ServiceException("Add country error ", e);
            }
        } else {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
            throw new ServiceException("Incorrect data ");
        }
    }
}
