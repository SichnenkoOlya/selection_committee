package by.sichnenko.committee.service.impl;

import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.dao.FacultyDAO;
import by.sichnenko.committee.dao.PrivilegeDAO;
import by.sichnenko.committee.dao.impl.FacultyDAOImpl;
import by.sichnenko.committee.dao.impl.PrivilegeDAOImpl;
import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Privilege;
import by.sichnenko.committee.service.PrivilegeService;

import java.util.List;

public class PrivilegeServiceImpl implements PrivilegeService {

    @Override
    public List<Privilege> findAllPrivileges(SessionRequestContent sessionRequestContent) throws ServiceException {
        PrivilegeDAO privilegeDAO;
        try {
            privilegeDAO = new PrivilegeDAOImpl();
            return privilegeDAO.findAll();
        } catch (DAOException e) {
            throw new ServiceException("Sorry, technical error", e);
        }
    }
}
