package by.sichnenko.committee.service.impl;

import by.sichnenko.committee.constant.GeneralConstant;
import by.sichnenko.committee.constant.RequestNameConstant;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.dao.*;
import by.sichnenko.committee.dao.impl.*;
import by.sichnenko.committee.exception.DAOException;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Enrollee;
import by.sichnenko.committee.model.Faculty;
import by.sichnenko.committee.model.User;
import by.sichnenko.committee.service.EnrolleeService;
import by.sichnenko.committee.validator.EnrolleeValidator;
import by.sichnenko.committee.validator.GeneralValidator;

import java.util.ArrayList;
import java.util.List;

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
        String[] passport = sessionRequestContent.getRequestParameters().get(PASSPORT);
        String[] sertificateScore = sessionRequestContent.getRequestParameters().get(SERTIFICATE_SCORE);
        String[] countScore = sessionRequestContent.getRequestParameters().get(COUNT_SCORE);
        String[] idSubjects = sessionRequestContent.getRequestParameters().get(SUBJECT_ID);
        String[] idPrivileges = sessionRequestContent.getRequestParameters().get(PRIVILEGE_ID);
        int ctScore = 0;
        List<Long> subject_ids = new ArrayList<>();
        List<Long> privilege_ids = new ArrayList<>();
        if (!GeneralValidator.isVarExist(name) || !GeneralValidator.isVarExist(surname)
                || !GeneralValidator.isVarExist(patronymic) || !GeneralValidator.isVarExist(phoneNumber)
                || !GeneralValidator.isPositiveNumber(facultyId)
                || !GeneralValidator.isPositiveNumber(cityId)
                || !GeneralValidator.isVarExist(passport) || !GeneralValidator.isPositiveNumber(sertificateScore)
                || !GeneralValidator.isPositiveNumber(countScore) || !GeneralValidator.isVarExist(idSubjects)) {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
            throw new ServiceException("Incorrect data");
        }

        if (!EnrolleeValidator.validateName(name[0]) || !EnrolleeValidator.validateName(surname[0])
                || !EnrolleeValidator.validateName(patronymic[0])
                || !EnrolleeValidator.validatePhoneNumber(phoneNumber[0])
                || !EnrolleeValidator.validatePassportNumber(passport[0])
                || !EnrolleeValidator.validateCertificateScore(Integer.valueOf(sertificateScore[0]))) {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
            throw new ServiceException("Incorrect data ");
        }


        for (String scoreOnSubject : countScore) {
            if (EnrolleeValidator.validateCertificateScore(Integer.valueOf(scoreOnSubject))) {
                ctScore += Integer.valueOf(scoreOnSubject);
            }
        }
        if (GeneralValidator.isVarExist(idPrivileges)) {
            for (String privilege_id : idPrivileges) {
                if (GeneralValidator.isPositiveNumber(privilege_id)) {
                    privilege_ids.add(Long.valueOf(privilege_id));
                }
            }
        }

        for (String subject_id : idSubjects) {
            if (GeneralValidator.isPositiveNumber(subject_id)) {
                subject_ids.add(Long.valueOf(subject_id));
            }
        }

        if (!EnrolleeValidator.validateScoreOnCT(ctScore, countScore.length)) {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
            throw new ServiceException("Incorrect data ");
        }

        try {
            EnrolleeDAO enrolleeDAO = new EnrolleeDAOImpl();
            UserDAO userDAO = new UserDAOImpl();
            SubjectDAO subjectDAO = new SubjectDAOImpl();
            PrivilegeDAO privilegeDAO = new PrivilegeDAOImpl();
            User user = userDAO.findUserByLogin(login);

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
            enrollee.setScoreOnCT(ctScore);
            enrolleeDAO.create(enrollee);

            Enrollee findEnrollee = enrolleeDAO.findEnrolleeByUserId(user.getUserId());
            subjectDAO.addSubjectsForEnrollee(findEnrollee.getEnrolleeId(), subject_ids);
            if (GeneralValidator.isVarExist(idPrivileges)) {
                privilegeDAO.addPrivilegesForEnrollee(findEnrollee.getEnrolleeId(), privilege_ids);
            }
            return findEnrollee;

        } catch (DAOException e) {
            throw new ServiceException("Fill enrollee error ", e);
        }
    }

    @Override
    public Enrollee editEnrollee(SessionRequestContent sessionRequestContent) throws ServiceException {
        String[] name = sessionRequestContent.getRequestParameters().get(NAME);
        String[] surname = sessionRequestContent.getRequestParameters().get(SURNAME);
        String[] patronymic = sessionRequestContent.getRequestParameters().get(PATRONYMIC);
        String[] phoneNumber = sessionRequestContent.getRequestParameters().get(PHONE_NUMBER);
        String[] facultyId = sessionRequestContent.getRequestParameters().get(FACULTY);
        String login = sessionRequestContent.getSessionAttributes().get(LOGIN).toString();
        String[] cityId = sessionRequestContent.getRequestParameters().get(CITY);
        String[] passport = sessionRequestContent.getRequestParameters().get(PASSPORT);
        String[] sertificateScore = sessionRequestContent.getRequestParameters().get(SERTIFICATE_SCORE);
        String[] countScore = sessionRequestContent.getRequestParameters().get(COUNT_SCORE);
        String[] idSubjects = sessionRequestContent.getRequestParameters().get(SUBJECT_ID);
        String[] idPrivileges = sessionRequestContent.getRequestParameters().get(PRIVILEGE_ID);
        String[] idEnrollee = sessionRequestContent.getRequestParameters().get(ENROLLEE_ID);

        int ctScore = 0;
        List<Long> subject_ids = new ArrayList<>();
        List<Long> privilege_ids = new ArrayList<>();
        if (!GeneralValidator.isVarExist(name) || !GeneralValidator.isVarExist(surname)
                || !GeneralValidator.isVarExist(patronymic) || !GeneralValidator.isVarExist(phoneNumber)
                || !GeneralValidator.isPositiveNumber(facultyId)
                || !GeneralValidator.isPositiveNumber(cityId)
                || !GeneralValidator.isVarExist(passport) || !GeneralValidator.isPositiveNumber(sertificateScore)
                || !GeneralValidator.isPositiveNumber(countScore) || !GeneralValidator.isPositiveNumber(idEnrollee)
                || !GeneralValidator.isVarExist(idSubjects)) {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
            throw new ServiceException("Incorrect data");
        }

        if (!EnrolleeValidator.validateName(name[0]) || !EnrolleeValidator.validateName(surname[0])
                || !EnrolleeValidator.validateName(patronymic[0])
                || !EnrolleeValidator.validatePhoneNumber(phoneNumber[0])
                || !EnrolleeValidator.validatePassportNumber(passport[0])
                || !EnrolleeValidator.validateCertificateScore(Integer.valueOf(sertificateScore[0]))) {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
            throw new ServiceException("Incorrect data ");
        }


        for (String scoreOnSubject : countScore) {
            if (EnrolleeValidator.validateCertificateScore(Integer.valueOf(scoreOnSubject))) {
                ctScore += Integer.valueOf(scoreOnSubject);
            }
        }
        for (String subject_id : idSubjects) {
            if (GeneralValidator.isPositiveNumber(subject_id)) {
                subject_ids.add(Long.valueOf(subject_id));
            }
        }

        if (GeneralValidator.isVarExist(idPrivileges)) {
            for (String privilege_id : idPrivileges) {
                if (GeneralValidator.isPositiveNumber(privilege_id)) {
                    privilege_ids.add(Long.valueOf(privilege_id));
                }
            }
        }

        if (!EnrolleeValidator.validateScoreOnCT(ctScore, countScore.length)) {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
            throw new ServiceException("Incorrect data ");
        }

        try {
            EnrolleeDAO enrolleeDAO = new EnrolleeDAOImpl();
            UserDAO userDAO = new UserDAOImpl();
            SubjectDAO subjectDAO = new SubjectDAOImpl();
            PrivilegeDAO privilegeDAO = new PrivilegeDAOImpl();
            User user = userDAO.findUserByLogin(login);

            Enrollee enrollee = new Enrollee();
            enrollee.setName(name[0]);
            enrollee.setSurname(surname[0]);
            enrollee.setPatronymic(patronymic[0]);
            enrollee.setPhoneNumber(phoneNumber[0]);
            enrollee.setUserId(user.getUserId());
            enrollee.setCityId(Long.valueOf(cityId[0]));
            enrollee.setFacultyId(Long.valueOf(facultyId[0]));
            enrollee.setStatusId(6);
            enrollee.setEnrolleeId(Long.valueOf(idEnrollee[0]));
            enrollee.setInfoMessage("");
            enrollee.setPassport(passport[0]);
            enrollee.setAvarageCertificateScore(Integer.valueOf(sertificateScore[0]));
            enrollee.setScoreOnCT(ctScore);
            enrolleeDAO.update(enrollee);

            Enrollee findEnrollee = enrolleeDAO.findEnrolleeByUserId(user.getUserId());

            subjectDAO.deleteSubjectsForEnrollee(findEnrollee.getEnrolleeId());
            subjectDAO.addSubjectsForEnrollee(findEnrollee.getEnrolleeId(), subject_ids);
            if (GeneralValidator.isVarExist(idPrivileges)) {
                privilegeDAO.deletePrivilegesForEnrollee(findEnrollee.getEnrolleeId());
                privilegeDAO.addPrivilegesForEnrollee(findEnrollee.getEnrolleeId(), privilege_ids);
            }
            return findEnrollee;

        } catch (DAOException e) {
            throw new ServiceException("Edit enrollee error ", e);
        }
    }

    @Override
    public void changeAllEnrolleesStatus(SessionRequestContent sessionRequestContent) throws ServiceException {
        String[] oldStatusId = sessionRequestContent.getRequestParameters().get(OLD_STATUS_ID);
        String[] newStatusId = sessionRequestContent.getRequestParameters().get(NEW_STATUS_ID);

        if (!GeneralValidator.isPositiveNumber(oldStatusId) || !GeneralValidator.isPositiveNumber(newStatusId)) {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
            throw new ServiceException("Incorrect data  ");
        }
        try {
            EnrolleeDAO enrolleeDAO = new EnrolleeDAOImpl();
            enrolleeDAO.changeAllEnrolleesStatus(Long.valueOf(oldStatusId[0]), Long.valueOf(newStatusId[0]));
        } catch (DAOException e) {
            throw new ServiceException("Change status error ", e);
        }
    }

    @Override
    public void changeStatus(SessionRequestContent sessionRequestContent) throws ServiceException {
        String[] userId = sessionRequestContent.getRequestParameters().get(USER_ID);
        String[] newStatusId = sessionRequestContent.getRequestParameters().get(NEW_STATUS_ID);
        String[] message = sessionRequestContent.getRequestParameters().get(MESSAGE);
        if (!GeneralValidator.isPositiveNumber(userId) || !GeneralValidator.isPositiveNumber(newStatusId)) {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
            throw new ServiceException("Incorrect data");
        }
        try {
            EnrolleeDAO enrolleeDAO = new EnrolleeDAOImpl();
            Enrollee enrollee = enrolleeDAO.findEnrolleeByUserId(Long.valueOf(userId[0]));
            if (GeneralValidator.isVarExist(message)) {
                enrolleeDAO.changeStatus(enrollee.getEnrolleeId(), Long.valueOf(newStatusId[0]), message[0]);
            } else {
                enrolleeDAO.changeStatus(enrollee.getEnrolleeId(), Long.valueOf(newStatusId[0]), "");
            }

        } catch (DAOException e) {
            throw new ServiceException("Change status error ", e);
        }
    }

    @Override
    public Enrollee findEnrolleeByUser(SessionRequestContent sessionRequestContent) throws ServiceException {
        String[] login = sessionRequestContent.getRequestParameters().get(RequestNameConstant.LOGIN);
        if (!GeneralValidator.isVarExist(login)) {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
            throw new ServiceException("Incorrect data");
        }
        if (!GeneralValidator.isVarExist(login)) {
            throw new ServiceException("Incorrect data");
        }
        try {
            UserDAO userDAO = new UserDAOImpl();
            User user = userDAO.findUserByLogin(login[0]);
            EnrolleeDAO enrolleeDAO = new EnrolleeDAOImpl();
            return enrolleeDAO.findEnrolleeByUserId(user.getUserId());
        } catch (DAOException e) {
            throw new ServiceException("Find enrollee error ", e);
        }
    }

    @Override
    public List<Enrollee> findEnrolleesEnteredFacultyBudjet(SessionRequestContent sessionRequestContent) throws ServiceException {
        String[] facultyId = sessionRequestContent.getRequestParameters().get(FACULTY_ID);

        if (!GeneralValidator.isPositiveNumber(facultyId)) {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
            throw new ServiceException("Incorrect data");
        }
        try {
            FacultyDAO facultyDAO = new FacultyDAOImpl();
            Faculty faculty = facultyDAO.findFacultyById(Long.valueOf(facultyId[0]));
            EnrolleeDAO enrolleeDAO = new EnrolleeDAOImpl();
            return enrolleeDAO.findEnrolleesEnteredFacultyBudjet(faculty);
        } catch (DAOException e) {
            throw new ServiceException("Find enrollee error ", e);
        }
    }

    @Override
    public List<Enrollee> findEnrolleesEnteredFacultyPaid(SessionRequestContent sessionRequestContent) throws ServiceException {
        String[] facultyId = sessionRequestContent.getRequestParameters().get(FACULTY_ID);

        if (!GeneralValidator.isPositiveNumber(facultyId)) {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
            throw new ServiceException("Incorrect data");
        }
        try {
            FacultyDAO facultyDAO = new FacultyDAOImpl();
            Faculty faculty = facultyDAO.findFacultyById(Long.valueOf(facultyId[0]));
            EnrolleeDAO enrolleeDAO = new EnrolleeDAOImpl();
            return enrolleeDAO.findEnrolleesEnteredFacultyPaid(faculty);
        } catch (DAOException e) {
            throw new ServiceException("Find enrollee error ", e);
        }
    }

    @Override
    public void enrollToAllFaculty(SessionRequestContent sessionRequestContent) throws ServiceException {
        FacultyDAO facultyDAO = new FacultyDAOImpl();
        try {
            List<Faculty> faculties = facultyDAO.findAll();
            for (Faculty faculty : faculties) {
                enroll(faculty);
            }

        } catch (DAOException e) {
            throw new ServiceException("Enroll to faculty error ", e);
        }
    }

    @Override
    public void enrollToFaculty(SessionRequestContent sessionRequestContent) throws ServiceException {
        FacultyDAO facultyDAO = new FacultyDAOImpl();
        String[] facultyId = sessionRequestContent.getRequestParameters().get(FACULTY_ID);

        if (!GeneralValidator.isPositiveNumber(facultyId)) {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
            throw new ServiceException("Incorrect data");
        }
        try {
            Faculty faculty = facultyDAO.findFacultyById(Long.valueOf(facultyId[0]));
            if (!faculty.getIsFinish()) {
                enroll(faculty);
            }
            facultyDAO.updateIsFinish(true, faculty.getFacultyId());
        } catch (DAOException e) {
            throw new ServiceException("Enroll to faculty error ", e);
        }
    }

    private void enroll(Faculty faculty) throws ServiceException {
        try {
            FacultyDAO facultyDAO = new FacultyDAOImpl();
            EnrolleeDAO enrolleeDAO = new EnrolleeDAOImpl();
            List<Enrollee> budjetEnrollees = enrolleeDAO.findEnrolleesEnteredFacultyBudjet(faculty);
            for (Enrollee enrollee : budjetEnrollees) {
                enrolleeDAO.changeStatus(enrollee.getEnrolleeId(), 2L, "");
            }
            List<Enrollee> paidEnrolles = enrolleeDAO.findEnrolleesEnteredFacultyPaid(faculty);
            for (Enrollee enrollee : paidEnrolles) {
                enrolleeDAO.changeStatus(enrollee.getEnrolleeId(), 3L, "");
            }
            List<Enrollee> notEnteredEnrolles = enrolleeDAO.findEnrolleesNotEntered(faculty);
            for (Enrollee enrollee : notEnteredEnrolles) {
                enrolleeDAO.changeStatus(enrollee.getEnrolleeId(), 5L, "");
            }
            if (budjetEnrollees.size() < faculty.getBudjetPlaceCount() || budjetEnrollees.size() == 0) {
                faculty.setPassingScoreBudjet((short) 0);
            } else {
                Enrollee lastEnrollee = budjetEnrollees.get(budjetEnrollees.size() - 1);
                int scoreBudjet = lastEnrollee.getAvarageCertificateScore() + lastEnrollee.getScoreOnCT();
                faculty.setPassingScoreBudjet((short) scoreBudjet);
            }

            if (paidEnrolles.size() < faculty.getPaidPlaceCount() || paidEnrolles.size() == 0) {
                faculty.setPassingScorePaid((short) 0);
            } else {
                Enrollee lastEnrollee = paidEnrolles.get(paidEnrolles.size() - 1);
                int scorePaid = lastEnrollee.getAvarageCertificateScore() + lastEnrollee.getScoreOnCT();
                faculty.setPassingScoreBudjet((short) scorePaid);
            }
            facultyDAO.updateScore(faculty);

        } catch (DAOException e) {
            throw new ServiceException("Enroll to faculty error ", e);
        }
    }
}
