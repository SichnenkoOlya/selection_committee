package by.sichnenko.committee.service.impl;

import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.dao.CityDAO;
import by.sichnenko.committee.dao.impl.CityDAOImpl;
import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.City;
import by.sichnenko.committee.service.CityService;

import java.util.List;

public class CityServiceImpl implements CityService {
    @Override
    public List<City> findAllCities(SessionRequestContent sessionRequestContent) throws ServiceException {
        CityDAO cityDAO;
        try {
            cityDAO = new CityDAOImpl();
            return cityDAO.findAll();
        } catch (DAOException e) {
            throw new ServiceException("Sorry, technical error", e);
        }
    }
}
