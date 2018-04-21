package by.sichnenko.committee.service;

import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Enrollee;

import java.util.List;

public interface EnrolleeService {
    Enrollee fillEnrollee(SessionRequestContent sessionRequestContent) throws ServiceException;

    void changeAllEnrolleesStatus(SessionRequestContent sessionRequestContent) throws ServiceException;

    void changeStatus(SessionRequestContent sessionRequestContent) throws ServiceException;
    Enrollee findEnrolleeByUser(String login) throws ServiceException;
}
