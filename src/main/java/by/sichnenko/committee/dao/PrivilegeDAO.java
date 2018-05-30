package by.sichnenko.committee.dao;

import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.model.Privilege;

import java.util.List;

/**
 * The interface PrivilegeDAO
 *
 * @see DAO
 * @see Privilege
 */
public interface PrivilegeDAO extends DAO<Privilege> {
    /**
     * Add list of privileges for enrollee
     *
     * @param enrolleeId   id of enrollee
     * @param privilegesId list of ids of privileges
     * @throws DAOException when sql exception occurs
     */
    void addPrivilegesForEnrollee(Long enrolleeId, List<Long> privilegesId) throws DAOException;

    /**
     * Delete all privileges for enrollee
     *
     * @param enrolleeId id of enrollee
     * @throws DAOException when sql exception occurs
     */
    void deletePrivilegesForEnrollee(Long enrolleeId) throws DAOException;
}
