package by.sichnenko.committee.dao;

import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.model.Enrollee;
import by.sichnenko.committee.model.Faculty;

import java.util.List;

/**
 * The interface EnrolleeDAO
 *
 * @see DAO
 * @see Enrollee
 */
public interface EnrolleeDAO extends DAO<Enrollee> {
    /**
     * Change status for all enrollees
     *
     * @param oldStatusId old value of status's id
     * @param newStatusId new value of status's id
     * @throws DAOException when sql exception occurs
     */
    void changeAllEnrolleesStatus(Long oldStatusId, Long newStatusId) throws DAOException;

    /**
     * Change status for enrollee
     *
     * @param enrolleeId  id of the enrollee
     * @param newStatusId new value of status's id
     * @param message     info message from admin for enrollee
     * @throws DAOException when sql exception occurs
     */
    void changeStatus(Long enrolleeId, Long newStatusId, String message) throws DAOException;

    /**
     * Find enrollee by login
     *
     * @param userId id of user
     * @return enrollee
     * @throws DAOException when sql exception occurs
     */
    Enrollee findEnrolleeByUserId(Long userId) throws DAOException;

    /**
     * Find enrollees entered for faculty for budjet
     *
     * @param faculty faculty
     * @return list of enrollees
     * @throws DAOException when sql exception occurs
     * @see Faculty
     */
    List<Enrollee> findEnrolleesEnteredFacultyBudjet(Faculty faculty) throws DAOException;

    /**
     * Find enrollees entered for faculty for paid
     *
     * @param faculty faculty
     * @return list of enrollees
     * @throws DAOException when sql exception occurs
     * @see Faculty
     */
    List<Enrollee> findEnrolleesEnteredFacultyPaid(Faculty faculty) throws DAOException;

    /**
     * Find enrollees not entered to the faculty
     *
     * @param faculty faculty
     * @return list of enrollees
     * @throws DAOException when sql exception occurs
     * @see Faculty
     */
    List<Enrollee> findEnrolleesNotEntered(Faculty faculty) throws DAOException;

}
