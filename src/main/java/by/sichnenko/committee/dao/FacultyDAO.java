package by.sichnenko.committee.dao;

import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.model.Faculty;

import java.util.List;

public interface FacultyDAO extends DAO<Faculty> {
    Faculty findFacultyById(Long facultyId) throws DAOException;

    Faculty findFacultyByName(String facultyName) throws DAOException;

    void updateImage(Long facultyId, String imagePath) throws DAOException;

    void updateScore(Faculty faculty) throws DAOException;

    void updateIsFinish(Boolean newValue, Long facultyId) throws DAOException;

    List<Faculty> findAllAvaliableFaculties() throws DAOException;
}
