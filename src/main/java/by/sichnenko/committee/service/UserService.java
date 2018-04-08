package by.sichnenko.committee.service;

import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.StatusType;
import by.sichnenko.committee.model.User;

public interface UserService {
    User signIn(String login, String password) throws ServiceException;
    User signUp(String login, String password, String email) throws ServiceException;
}
