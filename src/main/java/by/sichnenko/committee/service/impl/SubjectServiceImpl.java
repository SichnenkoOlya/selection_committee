package by.sichnenko.committee.service.impl;

import by.sichnenko.committee.constant.GeneralConstant;
import by.sichnenko.committee.constant.RequestNameConstant;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.dao.SubjectDAO;
import by.sichnenko.committee.dao.impl.SubjectDAOImpl;
import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Subject;
import by.sichnenko.committee.service.SubjectService;
import by.sichnenko.committee.validator.GeneralValidator;

import java.util.List;

public class SubjectServiceImpl implements SubjectService {
    @Override
    public List<Subject> findSubjetsForFaculty(SessionRequestContent sessionRequestContent) throws ServiceException {
        String[] facultyId = sessionRequestContent.getRequestParameters().get(RequestNameConstant.FACULTY_ID);
        if (GeneralValidator.isPositiveNumber(facultyId)) {
            SubjectDAO subjectDAO = new SubjectDAOImpl();
            try {
                return subjectDAO.findSubjetsForFaculty(Long.valueOf(facultyId[0]));
            } catch (DAOException e) {
                throw new ServiceException("Find subjects error ", e);
            }
        } else {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
            throw new ServiceException("Incorrect data");
        }
    }

    @Override
    public List<Subject> findAllSubjects() throws ServiceException {
        try {
            SubjectDAO subjectDAO = new SubjectDAOImpl();
            return subjectDAO.findAll();
        } catch (DAOException e) {
            throw new ServiceException("Find subjects error ", e);
        }
    }
}
