package by.sichnenko.committee.dao;

import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.model.Privilege;

import java.util.List;

public interface PrivilegeDAO extends DAO<Privilege> {
    void addPrivilegesForEnrollee(Long enrolleeId, List<Long> privileges_id) throws DAOException;
    void deletePrivilegesForEnrollee(Long enrolleeId) throws DAOException;
}
