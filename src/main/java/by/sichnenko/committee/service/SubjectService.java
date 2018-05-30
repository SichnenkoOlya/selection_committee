package by.sichnenko.committee.service;

import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Subject;

import java.util.List;

/**
 * The interface SubjectService
 */
public interface SubjectService {
    /**
     * Find subjects on which pupil must pass exem to enroll this faculty
     *
     * @param sessionRequestContent request content
     * @return list of subjects
     * @throws ServiceException the service exception
     */
    List<Subject> findSubjetsForFaculty(SessionRequestContent sessionRequestContent) throws ServiceException;

    /**
     * Find all subjects
     *
     * @return list of subjects
     * @throws ServiceException the service exception
     */
    List<Subject> findAllSubjects() throws ServiceException;
}
