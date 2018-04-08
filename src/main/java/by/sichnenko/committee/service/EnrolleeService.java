package by.sichnenko.committee.service;

import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Enrollee;
import by.sichnenko.committee.model.User;

public interface EnrolleeService {
    Enrollee fillEnrollee(String name, String surname, String patronymic,
                          String faculty, String city, String country, String phoneNumber) throws ServiceException;

}
