package by.sichnenko.committee.service.impl;

import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.dao.CountryDAO;
import by.sichnenko.committee.dao.FacultyDAO;
import by.sichnenko.committee.dao.impl.CountryDAOImpl;
import by.sichnenko.committee.dao.impl.FacultyDAOImpl;
import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Faculty;
import by.sichnenko.committee.service.FacultyService;

import java.util.List;

public class FacultyServiceImpl implements FacultyService{
    @Override
    public List<Faculty> findAllFaculties(SessionRequestContent sessionRequestContent) throws ServiceException {
        FacultyDAO facultyDAO;
        try {
            facultyDAO = new FacultyDAOImpl();
            return facultyDAO.findAll();
        } catch (DAOException e) {
            throw new ServiceException("Sorry, technical error", e);
        }
    }
}
