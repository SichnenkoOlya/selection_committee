package by.sichnenko.committee.service.impl;

import by.sichnenko.committee.constant.GeneralConstant;
import by.sichnenko.committee.constant.RequestNameConstant;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.dao.CityDAO;
import by.sichnenko.committee.dao.impl.CityDAOImpl;
import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.City;
import by.sichnenko.committee.service.CityService;
import by.sichnenko.committee.validator.GeneralValidator;

import java.util.List;

public class CityServiceImpl implements CityService {
    @Override
    public void addCity(SessionRequestContent sessionRequestContent) throws ServiceException {
        String[] cityName = sessionRequestContent.getRequestParameters().get(RequestNameConstant.CITY_NAME);
        String[] countryId = sessionRequestContent.getRequestParameters().get(RequestNameConstant.COUNTRY_ID);

        if (GeneralValidator.isPositiveNumber(countryId) && GeneralValidator.isVarExist(cityName)) {
            try {
                CityDAO cityDAO = new CityDAOImpl();
                List<City> citiesWithName=cityDAO.findCityByName(cityName[0]);
                if(!citiesWithName.isEmpty()){
                    for(City city:citiesWithName){
                        if(city.getCountryId()==Long.valueOf(countryId[0])){
                            sessionRequestContent.getRequestAttributes().put(GeneralConstant.CITY_EXIST, true);
                            throw new ServiceException("City with such name already  exist ");
                        }
                    }
                }
                City city = new City();
                city.setCountryId(Long.valueOf(countryId[0]));
                city.setName(cityName[0]);
                cityDAO.create(city);
            } catch (DAOException e) {
                throw new ServiceException("Add city error ", e);
            }
        } else {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
            throw new ServiceException("Incorrect data ");
        }
    }

    @Override
    public List<City> findAllCities() throws ServiceException {
        try {
            CityDAO cityDAO = new CityDAOImpl();
            return cityDAO.findAll();
        } catch (DAOException e) {
            throw new ServiceException("Find cities error ", e);
        }
    }

    @Override
    public List<City> findCitiesByCountryId(SessionRequestContent sessionRequestContent) throws ServiceException {
        String[] countryId = sessionRequestContent.getRequestParameters().get(RequestNameConstant.COUNTRY_ID);
        if (GeneralValidator.isPositiveNumber(countryId)) {
            try {
                CityDAO cityDAO = new CityDAOImpl();
                return cityDAO.findCitiesByCountryId(Long.valueOf(countryId[0]));
            } catch (DAOException e) {
                throw new ServiceException("Find cities error ", e);
            }
        } else {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
            throw new ServiceException("Incorrect data ");
        }
    }
}
