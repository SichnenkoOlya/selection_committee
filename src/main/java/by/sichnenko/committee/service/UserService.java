package by.sichnenko.committee.service;

import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.User;

import java.util.HashMap;
import java.util.List;

public interface UserService {
    User signIn(SessionRequestContent sessionRequestContent) throws ServiceException;

    User signUp(SessionRequestContent sessionRequestContent) throws ServiceException;

    void changeUserRole(SessionRequestContent sessionRequestContent) throws ServiceException;

    void editProfile(SessionRequestContent sessionRequestContent) throws ServiceException;

    void changeUserPassword(SessionRequestContent sessionRequestContent) throws ServiceException;

    void changeUserLock(SessionRequestContent sessionRequestContent) throws ServiceException;

    void changeAvatar(SessionRequestContent sessionRequestContent) throws ServiceException;

    List<User> findAllUsers() throws ServiceException;

    User findUser(SessionRequestContent sessionRequestContent) throws ServiceException;

    List<User> findUsersByStatus(SessionRequestContent sessionRequestContent) throws ServiceException;

    HashMap<User, Long> findAllUsersAndStatus() throws ServiceException;

}
