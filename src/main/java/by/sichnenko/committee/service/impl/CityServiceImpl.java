package by.sichnenko.committee.service.impl;

import by.sichnenko.committee.constant.RequestNameConstant;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.dao.CityDAO;
import by.sichnenko.committee.dao.FacultyDAO;
import by.sichnenko.committee.dao.SubjectDAO;
import by.sichnenko.committee.dao.impl.CityDAOImpl;
import by.sichnenko.committee.dao.impl.FacultyDAOImpl;
import by.sichnenko.committee.dao.impl.SubjectDAOImpl;
import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.City;
import by.sichnenko.committee.model.Faculty;
import by.sichnenko.committee.service.CityService;
import by.sichnenko.committee.validator.GeneralValidator;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

public class CityServiceImpl implements CityService {
    @Override
    public void addCity(SessionRequestContent sessionRequestContent) throws ServiceException {
        CityDAO cityDAO = new CityDAOImpl();
        String[] cityName = sessionRequestContent.getRequestParameters().get(RequestNameConstant.CITY_NAME);
        String[] countryId = sessionRequestContent.getRequestParameters().get(RequestNameConstant.COUNTRY_ID);
        if (GeneralValidator.isVarExist(countryId) && GeneralValidator.isVarExist(cityName)) {
            try {
                City city = new City();
                city.setCountryId(Long.valueOf(countryId[0]));
                city.setName(cityName[0]);
                cityDAO.create(city);
            } catch (DAOException e) {
                throw new ServiceException("Sorry, technical error", e);
            }
        }
        throw new ServiceException("Sorry, technical error");
    }


    @Override
    public List<City> findAllCities() throws ServiceException {
        CityDAO cityDAO;
        try {
            cityDAO = new CityDAOImpl();
            return cityDAO.findAll();
        } catch (DAOException e) {
            throw new ServiceException("Sorry, technical error", e);
        }
    }

    @Override
    public List<City> findCitiesByCountryId(SessionRequestContent sessionRequestContent) throws ServiceException {
        CityDAO cityDAO = new CityDAOImpl();

        String[] countryId = sessionRequestContent.getRequestParameters().get(RequestNameConstant.COUNTRY_ID);
        if (GeneralValidator.isVarExist(countryId)) {
            try {
                List<City> cities = cityDAO.findCitiesByCountryId(Long.valueOf(countryId[0]));
                sessionRequestContent.setAjaxParameter(JSONArray.fromObject(cities));
                return cities;
            } catch (DAOException e) {
                throw new ServiceException("Sorry, technical error", e);
            }
        }
        throw new ServiceException("Sorry, technical error");
    }
}
