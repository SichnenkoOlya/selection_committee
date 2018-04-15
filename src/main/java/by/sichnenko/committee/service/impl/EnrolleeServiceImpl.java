package by.sichnenko.committee.service.impl;

import by.sichnenko.committee.constant.GeneralConstant;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.dao.CityDAO;
import by.sichnenko.committee.dao.EnrolleeDAO;
import by.sichnenko.committee.dao.FacultyDAO;
import by.sichnenko.committee.dao.UserDAO;
import by.sichnenko.committee.dao.impl.CityDAOImpl;
import by.sichnenko.committee.dao.impl.EnrolleeDAOImpl;
import by.sichnenko.committee.dao.impl.FacultyDAOImpl;
import by.sichnenko.committee.dao.impl.UserDAOImpl;
import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Enrollee;
import by.sichnenko.committee.model.Faculty;
import by.sichnenko.committee.model.User;
import by.sichnenko.committee.service.EnrolleeService;
import by.sichnenko.committee.validator.GeneralValidator;
import by.sichnenko.committee.validator.UserValidator;

import static by.sichnenko.committee.constant.RequestNameConstant.*;

public class EnrolleeServiceImpl implements EnrolleeService {

    @Override
    public Enrollee fillEnrollee(SessionRequestContent sessionRequestContent) throws ServiceException {
        String[] name = sessionRequestContent.getRequestParameters().get(NAME);
        String[] surname = sessionRequestContent.getRequestParameters().get(SURNAME);
        String[] patronymic = sessionRequestContent.getRequestParameters().get(PATRONYMIC);
        String[] phoneNumber = sessionRequestContent.getRequestParameters().get(PHONE_NUMBER);
        String[] facultyId = sessionRequestContent.getRequestParameters().get(FACULTY);
        String login = sessionRequestContent.getSessionAttributes().get(LOGIN).toString();
        String[] cityId = sessionRequestContent.getRequestParameters().get(CITY);
        String[] country = sessionRequestContent.getRequestParameters().get(COUNTRY);
        String[] passport = sessionRequestContent.getRequestParameters().get(PASSPORT);
        String[] sertificateScore = sessionRequestContent.getRequestParameters().get("sertificateScore");
        String[] ctScore = sessionRequestContent.getRequestParameters().get("ctScore");
        if (!GeneralValidator.isVarExist(name) || !GeneralValidator.isVarExist(surname)
                || !GeneralValidator.isVarExist(patronymic) || !GeneralValidator.isVarExist(phoneNumber)
                || !GeneralValidator.isVarExist(facultyId)
                || !GeneralValidator.isVarExist(cityId) || !GeneralValidator.isVarExist(country)
                || !GeneralValidator.isVarExist(passport)) {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
            throw new ServiceException("Incorrect data");
        }
        try {
            EnrolleeDAO enrolleeDAO = new EnrolleeDAOImpl();
            UserDAO userDAO = new UserDAOImpl();

            User user = userDAO.findUserByLogin(login);

            if (UserValidator.validateName(login)) {
                Enrollee enrollee = new Enrollee();
                enrollee.setName(name[0]);
                enrollee.setSurname(surname[0]);
                enrollee.setPatronymic(patronymic[0]);
                enrollee.setPhoneNumber(phoneNumber[0]);
                enrollee.setUserId(user.getUserId());
                enrollee.setCityId(Long.valueOf(cityId[0]));
                enrollee.setFacultyId(Long.valueOf(facultyId[0]));
                enrollee.setStatusId(1);
                enrollee.setPassport(passport[0]);
                enrollee.setAvarageCertificateScore(Integer.valueOf(sertificateScore[0]));
                enrollee.setScoreOnCT(Integer.valueOf(ctScore[0]));
                enrolleeDAO.create(enrollee);
                return enrollee;
            } else {
                throw new ServiceException("Invalid name");
            }
        }    catch (DAOException e) {
            throw new ServiceException("Invalid name", e);
        }
    }
}
