package by.sichnenko.committee.service.impl;

import by.sichnenko.committee.constant.GeneralConstant;
import by.sichnenko.committee.constant.RequestNameConstant;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.dao.SubjectDAO;
import by.sichnenko.committee.dao.UserDAO;
import by.sichnenko.committee.dao.impl.SubjectDAOImpl;
import by.sichnenko.committee.dao.impl.UserDAOImpl;
import by.sichnenko.committee.exception.*;
import by.sichnenko.committee.model.RoleType;
import by.sichnenko.committee.model.User;
import by.sichnenko.committee.service.UserService;
import by.sichnenko.committee.util.MD5Generator;
import by.sichnenko.committee.validator.GeneralValidator;
import by.sichnenko.committee.validator.UserValidator;

import java.util.List;


public class UserServiceImpl implements UserService {

    @Override
    public User signIn(SessionRequestContent sessionRequestContent) throws ServiceException {

        String[] login = sessionRequestContent.getRequestParameters().get(RequestNameConstant.LOGIN);
        String[] password = sessionRequestContent.getRequestParameters().get(RequestNameConstant.PASSWORD);
        if (!GeneralValidator.isVarExist(login) || !GeneralValidator.isVarExist(password)) {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
            throw new ServiceException("Incorrect data");
        }
        UserDAOImpl userDAO;
        try {
            userDAO = new UserDAOImpl();

            User user = userDAO.findUserByLogin(login[0]);
            if (user != null) {
                try {
                    if (user.getHashPassword().equals(MD5Generator.generateHash(password[0]))) {
                        return user;
                    } else {
                        throw new ServiceException("Wrong password");
                    }
                } catch (TechnicalException e) {
                    throw new ServiceException("Sorry, technical error", e);
                }
            } else {
                throw new ServiceException("Login failed. Incorrect login");
            }
        } catch (DAOException e) {
            throw new ServiceException("Sorry, technical error", e);
        }
    }

    @Override
    public User signUp(SessionRequestContent sessionRequestContent) throws ServiceException {
        String[] login = sessionRequestContent.getRequestParameters().get(RequestNameConstant.LOGIN);
        String[] password = sessionRequestContent.getRequestParameters().get(RequestNameConstant.PASSWORD);
        String[] email = sessionRequestContent.getRequestParameters().get(RequestNameConstant.EMAIL);
        if (!GeneralValidator.isVarExist(login) || !GeneralValidator.isVarExist(password)
                || !GeneralValidator.isVarExist(email)) {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
            throw new ServiceException("Incorrect data");
        }
        try {
            UserDAOImpl userDAO = new UserDAOImpl();

            if (UserValidator.validateName(login[0])) {
                User user = new User();
                user.setLogin(login[0]);
                user.setHashPassword(MD5Generator.generateHash(password[0]));
                user.setEmail(email[0]);
                user.setRole(RoleType.USER);
                userDAO.create(user);
                return user;
            } else {
                throw new ServiceException("Invalid name");
            }
        } catch (TechnicalException e) {
            throw new ServiceException("Technical exception", e);
        } catch (DAOException e) {
            throw new ServiceException("Invalid name", e);
        }

    }

    @Override
    public void changeUserRole(SessionRequestContent sessionRequestContent) throws ServiceException {

    }

    @Override
    public List<User> findAllUsers(SessionRequestContent sessionRequestContent) throws ServiceException {
        UserDAO userDAO;
        try {
            userDAO = new UserDAOImpl();
            return userDAO.findAll();
        } catch (DAOException e) {
            throw new ServiceException("Sorry, technical error", e);
        }
    }

    @Override
    public User findUser(SessionRequestContent sessionRequestContent) throws ServiceException {
        String[] login = sessionRequestContent.getRequestParameters().get(RequestNameConstant.LOGIN);
        try {
            UserDAOImpl userDAO = new UserDAOImpl();
            return userDAO.findUserByLogin(login[0]);

        } catch (DAOException e) {
            throw new ServiceException("Invalid name", e);
        }

    }
}
