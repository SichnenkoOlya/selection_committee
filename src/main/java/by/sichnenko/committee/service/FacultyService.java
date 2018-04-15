package by.sichnenko.committee.service;

import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Country;
import by.sichnenko.committee.model.Faculty;

import java.util.List;

public interface FacultyService {
    List<Faculty> findAllFaculties(SessionRequestContent sessionRequestContent) throws ServiceException;

}
