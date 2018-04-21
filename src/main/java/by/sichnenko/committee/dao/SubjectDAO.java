package by.sichnenko.committee.dao;

import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.model.Subject;

import java.util.List;

public interface SubjectDAO extends DAO<Subject> {
    List<Subject> findSubjetsForFaculty(Long facultyId) throws DAOException;
    void addSubjectsForFaculty(Long facultyId, List<Long> subjectsId) throws DAOException;
    Subject findSubjectByName(String subjectName) throws DAOException;
}

