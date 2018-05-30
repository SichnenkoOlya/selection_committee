package by.sichnenko.committee.dao;

import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.model.Faculty;

import java.util.List;

/**
 * The interface FacultyDAO
 *
 * @see DAO
 * @see Faculty
 */
public interface FacultyDAO extends DAO<Faculty> {
    /**
     * Find faculty by id
     *
     * @param facultyId id of the faculty
     * @return faculty
     * @throws DAOException when sql exception occurs
     */
    Faculty findFacultyById(Long facultyId) throws DAOException;

    /**
     * Find faculty by name
     *
     * @param facultyName id of the faculty
     * @return faculty
     * @throws DAOException when sql exception occurs
     */
    Faculty findFacultyByName(String facultyName) throws DAOException;

    /**
     * Update image path for faculty
     *
     * @param facultyId id of the faculty
     * @param imagePath image path
     * @throws DAOException when sql exception occurs
     */
    void updateImage(Long facultyId, String imagePath) throws DAOException;

    /**
     * Update passing score for faculty
     *
     * @param faculty faculty
     * @throws DAOException when sql exception occurs
     */
    void updateScore(Faculty faculty) throws DAOException;

    /**
     * Update value if there is committee for this faculty finished
     *
     * @param newValue  new value of there is committee for this faculty finished
     * @param facultyId id of the faculty
     * @throws DAOException when sql exception occurs
     */
    void updateIsFinish(Boolean newValue, Long facultyId) throws DAOException;

    /**
     * Find all faculties in which committee hasn't finished
     *
     * @return faculties
     * @throws DAOException when sql exception occurs
     */
    List<Faculty> findAllAvaliableFaculties() throws DAOException;
}
