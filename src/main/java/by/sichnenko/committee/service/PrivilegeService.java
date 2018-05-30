package by.sichnenko.committee.service;

import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Privilege;

import java.util.List;

/**
 * The interface PrivilegeService
 */
public interface PrivilegeService {
    /**
     * Find all privileges
     *
     * @return list of privileges
     * @throws ServiceException the service exception
     */
    List<Privilege> findAllPrivileges() throws ServiceException;
}
