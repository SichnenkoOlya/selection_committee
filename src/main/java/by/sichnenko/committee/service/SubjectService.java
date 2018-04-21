package by.sichnenko.committee.service;

import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> findAllSubjects() throws ServiceException;
}
