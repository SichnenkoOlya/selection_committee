package by.sichnenko.committee.dao;

import by.sichnenko.committee.model.Enrollee;
import by.sichnenko.committee.model.Faculty;

import java.util.List;

public interface FacultyDAO extends DAO<Faculty> {
    List<Enrollee> findAllUsers();
}
