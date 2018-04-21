package by.sichnenko.committee.service;

import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Privilege;

import java.util.List;

public interface PrivilegeService {
    List<Privilege> findAllPrivileges() throws ServiceException;
}
