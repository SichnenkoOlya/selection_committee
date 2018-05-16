package by.sichnenko.committee.service;

import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Faculty;

import java.util.List;

public interface FacultyService {
    List<Faculty> findAllFaculties() throws ServiceException;

    List<Faculty> findAllAvaliableFaculties() throws ServiceException;

    Faculty findFacultyById(SessionRequestContent sessionRequestContent) throws ServiceException;

    void addFaculty(SessionRequestContent sessionRequestContent) throws ServiceException;

    boolean loadImage(SessionRequestContent sessionRequestContent) throws ServiceException;
}
