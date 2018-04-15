package by.sichnenko.committee.service.impl;

import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.dao.CountryDAO;
import by.sichnenko.committee.dao.SubjectDAO;
import by.sichnenko.committee.dao.impl.CountryDAOImpl;
import by.sichnenko.committee.dao.impl.SubjectDAOImpl;
import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Subject;
import by.sichnenko.committee.service.SubjectService;

import java.util.List;

public class SubjectServiceImpl implements SubjectService {
    @Override
    public List<Subject> findAllSubjects(SessionRequestContent sessionRequestContent) throws ServiceException {
        SubjectDAO subjectDAO;
        try {
            subjectDAO = new SubjectDAOImpl();
            return subjectDAO.findAll();
        } catch (DAOException e) {
            throw new ServiceException("Sorry, technical error", e);
        }
    }
}
