package by.sichnenko.committee.service.impl;

import by.sichnenko.committee.dao.PrivilegeDAO;
import by.sichnenko.committee.dao.impl.PrivilegeDAOImpl;
import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Privilege;
import by.sichnenko.committee.service.PrivilegeService;

import java.util.List;

/**
 * The PrivilegeServiceImpl class. Implementation of interface PrivilegeService.
 *
 * @see PrivilegeService
 * @see Privilege
 */
public class PrivilegeServiceImpl implements PrivilegeService {

    @Override
    public List<Privilege> findAllPrivileges() throws ServiceException {
        try {
            PrivilegeDAO privilegeDAO = new PrivilegeDAOImpl();
            return privilegeDAO.findAll();
        } catch (DAOException e) {
            throw new ServiceException("Find privileges error ", e);
        }
    }
}
