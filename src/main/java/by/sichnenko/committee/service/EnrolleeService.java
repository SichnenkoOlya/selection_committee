package by.sichnenko.committee.service;

import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Enrollee;

import java.util.List;

public interface EnrolleeService {
    Enrollee fillEnrollee(SessionRequestContent sessionRequestContent) throws ServiceException;

    Enrollee editEnrollee(SessionRequestContent sessionRequestContent) throws ServiceException;

    void changeAllEnrolleesStatus(SessionRequestContent sessionRequestContent) throws ServiceException;

    void changeStatus(SessionRequestContent sessionRequestContent) throws ServiceException;

    Enrollee findEnrolleeByUser(SessionRequestContent sessionRequestContent) throws ServiceException;

    List<Enrollee> findEnrolleesEnteredFacultyBudjet(SessionRequestContent sessionRequestContent) throws ServiceException;

    List<Enrollee> findEnrolleesEnteredFacultyPaid(SessionRequestContent sessionRequestContent) throws ServiceException;

    void enrollToAllFaculty(SessionRequestContent sessionRequestContent) throws ServiceException;

    void enrollToFaculty(SessionRequestContent sessionRequestContent) throws ServiceException;
}
