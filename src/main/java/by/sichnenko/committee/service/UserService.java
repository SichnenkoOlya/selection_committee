package by.sichnenko.committee.service;

import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.User;

import java.util.HashMap;
import java.util.List;

/**
 * The interface UserService
 */
public interface UserService {
    /**
     * Sign in
     *
     * @param sessionRequestContent request content
     * @return user
     * @throws ServiceException the service exception
     */
    User signIn(SessionRequestContent sessionRequestContent) throws ServiceException;

    /**
     * Sign up
     *
     * @param sessionRequestContent request content
     * @return user
     * @throws ServiceException the service exception
     */
    User signUp(SessionRequestContent sessionRequestContent) throws ServiceException;

    /**
     * Change role for user
     *
     * @param sessionRequestContent request content
     * @throws ServiceException the service exception
     */
    void changeUserRole(SessionRequestContent sessionRequestContent) throws ServiceException;

    /**
     * Edit user profile
     *
     * @param sessionRequestContent request content
     * @throws ServiceException the service exception
     */
    User editProfile(SessionRequestContent sessionRequestContent) throws ServiceException;

    /**
     * Change password for user
     *
     * @param sessionRequestContent request content
     * @throws ServiceException the service exception
     */
    void changeUserPassword(SessionRequestContent sessionRequestContent) throws ServiceException;

    /**
     * Change lock for user
     *
     * @param sessionRequestContent request content
     * @throws ServiceException the service exception
     */
    void changeUserLock(SessionRequestContent sessionRequestContent) throws ServiceException;

    /**
     * Change avatar for user
     *
     * @param sessionRequestContent request content
     * @throws ServiceException the service exception
     */
    void changeAvatar(SessionRequestContent sessionRequestContent) throws ServiceException;

    List<User> findAllUsers() throws ServiceException;

    /**
     * Find user
     *
     * @param sessionRequestContent request content
     * @return user
     * @throws ServiceException the service exception
     */
    User findUser(SessionRequestContent sessionRequestContent) throws ServiceException;

    /**
     * Find users by status
     *
     * @param sessionRequestContent request content
     * @return list of users
     * @throws ServiceException the service exception
     */
    List<User> findUsersByStatus(SessionRequestContent sessionRequestContent) throws ServiceException;

    /**
     * Find all users and their status
     *
     * @return map where key - user, value - user's status
     * @throws ServiceException the service exception
     */
    HashMap<User, Long> findAllUsersAndStatus() throws ServiceException;

}
