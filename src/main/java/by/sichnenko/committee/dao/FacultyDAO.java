package by.sichnenko.committee.dao;

import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.model.Enrollee;
import by.sichnenko.committee.model.Faculty;

import java.util.List;

public interface FacultyDAO extends DAO<Faculty> {
    List<Enrollee> findAllUsers();

    Faculty findFacultyById(Long facultyId) throws DAOException;

    Faculty findFacultyByName(String facultyName) throws DAOException;

    void upfdateImage(Long facultyId, String imagePath) throws DAOException;
}
