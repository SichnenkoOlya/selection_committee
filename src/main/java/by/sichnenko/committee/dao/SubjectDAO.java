package by.sichnenko.committee.dao;

import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.model.Subject;

import java.util.List;

/**
 * The interface SubjectDAO
 *
 * @see DAO
 * @see Subject
 */
public interface SubjectDAO extends DAO<Subject> {
    /**
     * Find subjects for faculty(on which subjects pupil must pass exam on CT)
     *
     * @param facultyId id od the faculty
     * @return list of subjects
     * @throws DAOException when sql exception occurs
     */
    List<Subject> findSubjetsForFaculty(Long facultyId) throws DAOException;

    /**
     * Delete subjects, on which enrollee pass exams
     *
     * @param enrolleeId id of the enrollee
     * @throws DAOException when sql exception occurs
     */
    void deleteSubjectsForEnrollee(Long enrolleeId) throws DAOException;

    /**
     * Add subjects, on which enroollee passed exams
     *
     * @param enrolleeId id of enrollee
     * @param subjectsId list of ids of subjects
     * @throws DAOException when sql exception occurs
     */
    void addSubjectsForEnrollee(Long enrolleeId, List<Long> subjectsId) throws DAOException;

    /**
     * Add subjects, on which enroollee must pass exams to enroll this faculty
     *
     * @param facultyId  id of faculty
     * @param subjectsId list of ids of subjects
     * @throws DAOException when sql exception occurs
     */
    void addSubjectsForFaculty(Long facultyId, List<Long> subjectsId) throws DAOException;

}

