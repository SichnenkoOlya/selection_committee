package by.sichnenko.committee.service;

import by.sichnenko.committee.content.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.StatusType;
import by.sichnenko.committee.model.User;

public interface UserService {
    User signIn(SessionRequestContent sessionRequestContent) throws ServiceException;
    User signUp(SessionRequestContent sessionRequestContent) throws ServiceException;
}
