package by.sichnenko.committee.service;

import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Enrollee;

import java.util.List;

/**
 * The interface EnrolleeService
 */
public interface EnrolleeService {
    /**
     * Fill enrollee's profile
     *
     * @param sessionRequestContent request content
     * @return enrollee
     * @throws ServiceException the service exception
     */
    Enrollee fillEnrollee(SessionRequestContent sessionRequestContent) throws ServiceException;

    /**
     * Edit enrollee's profile
     *
     * @param sessionRequestContent request content
     * @return enrollee
     * @throws ServiceException the service exception
     */
    Enrollee editEnrollee(SessionRequestContent sessionRequestContent) throws ServiceException;

    /**
     * Change status for all enrollees
     *
     * @param sessionRequestContent request content
     * @throws ServiceException the service exception
     */
    void changeAllEnrolleesStatus(SessionRequestContent sessionRequestContent) throws ServiceException;

    /**
     * Change status for enrollee
     *
     * @param sessionRequestContent request content
     * @throws ServiceException the service exception
     */
    void changeStatus(SessionRequestContent sessionRequestContent) throws ServiceException;

    /**
     * Find enrollee by user
     *
     * @param sessionRequestContent request content
     * @return enrollee
     * @throws ServiceException the service exception
     */
    Enrollee findEnrolleeByUser(SessionRequestContent sessionRequestContent) throws ServiceException;

    /**
     * Find enrollees entered for faculty on budjet
     *
     * @param sessionRequestContent request content
     * @return list of enrollees
     * @throws ServiceException the service exception
     */
    List<Enrollee> findEnrolleesEnteredFacultyBudjet(SessionRequestContent sessionRequestContent) throws ServiceException;

    /**
     * Find enrollees entered for faculty on paid
     *
     * @param sessionRequestContent request content
     * @return list of enrollees
     * @throws ServiceException the service exception
     */
    List<Enrollee> findEnrolleesEnteredFacultyPaid(SessionRequestContent sessionRequestContent) throws ServiceException;

    void enrollToAllFaculty(SessionRequestContent sessionRequestContent) throws ServiceException;

    /**
     * Enroll pupils to faculyt
     *
     * @param sessionRequestContent request content
     * @throws ServiceException the service exception
     */
    void enrollToFaculty(SessionRequestContent sessionRequestContent) throws ServiceException;
}
