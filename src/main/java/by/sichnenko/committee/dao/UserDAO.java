package by.sichnenko.committee.dao;

import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.model.RoleType;
import by.sichnenko.committee.model.User;

import java.util.List;

/**
 * The interface UserDAO
 *
 * @see DAO
 * @see User
 */
public interface UserDAO extends DAO<User> {

    /**
     * Find user by login
     *
     * @param login login of the user
     * @return user
     * @throws DAOException when sql exception occurs
     */
    User findUserByLogin(String login) throws DAOException;

    /**
     * Find users by status id
     *
     * @param statusId id of the status
     * @return list of users
     * @throws DAOException when sql exception occurs
     */
    List<User> findAllUsersByStatus(Long statusId) throws DAOException;

    /**
     * Update role of user
     *
     * @param userId  id of user
     * @param newRole new role for user
     * @throws DAOException when sql exception occurs
     * @see RoleType
     */
    void updateRole(Long userId, RoleType newRole) throws DAOException;

    /**
     * Update lock of user
     *
     * @param userId  id of user
     * @param newLock new type of block for user( true if user will be blocked, else when unblocked)
     * @throws DAOException when sql exception occurs
     */
    void updateLock(Long userId, Boolean newLock) throws DAOException;

    /**
     * Update password of user
     *
     * @param userId      id of user
     * @param newPassword new password for user
     * @throws DAOException when sql exception occurs
     */
    void updatePassword(Long userId, String newPassword) throws DAOException;

    /**
     * Update path of image of user
     *
     * @param userId    id of user
     * @param imagePath new image path for user
     * @throws DAOException when sql exception occurs
     */
    void updateImagePath(Long userId, String imagePath) throws DAOException;
}

