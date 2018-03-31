package by.sichnenko.committee.service;

import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.User;

public interface UserService {
    User authentification(User user);
    User registration(User user) throws ServiceException;
}
