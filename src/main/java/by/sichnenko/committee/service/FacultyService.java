package by.sichnenko.committee.service;

import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Faculty;

import java.util.List;

/**
 * The interface FacultyService
 */
public interface FacultyService {
    /**
     * Find all faculties
     *
     * @return list of faculties
     * @throws ServiceException the service exception
     */
    List<Faculty> findAllFaculties() throws ServiceException;

    /**
     * Find all avaliable faculties
     *
     * @return list of faculties
     * @throws ServiceException the service exception
     */
    List<Faculty> findAllAvaliableFaculties() throws ServiceException;

    /**
     * Find faculty by id
     *
     * @param sessionRequestContent request content
     * @return faculty
     * @throws ServiceException the service exception
     */
    Faculty findFacultyById(SessionRequestContent sessionRequestContent) throws ServiceException;

    /**
     * Add new faculty
     *
     * @param sessionRequestContent request content
     * @throws ServiceException the service exception
     */
    void addFaculty(SessionRequestContent sessionRequestContent) throws ServiceException;

    /**
     * Load image for faculty
     *
     * @param sessionRequestContent request content
     * @throws ServiceException the service exception
     */
    void loadImage(SessionRequestContent sessionRequestContent) throws ServiceException;
}
