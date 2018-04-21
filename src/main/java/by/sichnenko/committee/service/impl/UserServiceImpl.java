package by.sichnenko.committee.service.impl;

import by.sichnenko.committee.constant.GeneralConstant;
import by.sichnenko.committee.constant.RequestNameConstant;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.dao.UserDAO;
import by.sichnenko.committee.dao.impl.UserDAOImpl;
import by.sichnenko.committee.exception.*;
import by.sichnenko.committee.model.RoleType;
import by.sichnenko.committee.model.User;
import by.sichnenko.committee.service.UserService;
import by.sichnenko.committee.util.ImageUploader;
import by.sichnenko.committee.util.MD5Generator;
import by.sichnenko.committee.validator.GeneralValidator;
import by.sichnenko.committee.validator.UserValidator;

import java.util.List;
import java.util.Optional;

import static by.sichnenko.committee.constant.GeneralConstant.DIRECTORY_USER;
import static by.sichnenko.committee.constant.RequestNameConstant.IMAGE;


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
        UserDAO userDAO;
        String[] newRole = sessionRequestContent.getRequestParameters().get(RequestNameConstant.ROLE);
        String[] userId = sessionRequestContent.getRequestParameters().get(RequestNameConstant.ID);
        if (GeneralValidator.isVarExist(newRole)) {
            try {
                userDAO = new UserDAOImpl();
                userDAO.updateRole(Long.valueOf(userId[0]), RoleType.valueOf(newRole[0]));
            } catch (DAOException e) {
                throw new ServiceException("Sorry, technical error", e);
            }
        }
    }

    @Override
    public void changeUserPassword(SessionRequestContent sessionRequestContent) throws ServiceException {
        UserDAO userDAO = new UserDAOImpl();
        String[] newPassword = sessionRequestContent.getRequestParameters().get(RequestNameConstant.NEW_PASSWORD);
        String[] confirmPassword = sessionRequestContent.getRequestParameters().get(RequestNameConstant.CONFIRM_PASSWORD);
        String[] oldPassword = sessionRequestContent.getRequestParameters().get(RequestNameConstant.OLD_PASSWORD);
        String login = sessionRequestContent.getSessionAttributes().get(RequestNameConstant.LOGIN).toString();
        try {
            User user = userDAO.findUserByLogin(login);
            if (GeneralValidator.isVarExist(newPassword)) {
                try {
                    if (MD5Generator.generateHash(newPassword[0]).equals(MD5Generator.generateHash(confirmPassword[0]))) {
                        if (user.getHashPassword().equals(MD5Generator.generateHash(oldPassword[0]))) {
                            try {
                                userDAO = new UserDAOImpl();
                                userDAO.updatePassword(user.getUserId(), MD5Generator.generateHash(newPassword[0]));
                            } catch (DAOException e) {
                                throw new ServiceException("Sorry, technical error", e);
                            }
                        }
                    }
                } catch (TechnicalException e) {
                    throw new ServiceException("Sorry, technical error", e);
                }
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeUserLock(SessionRequestContent sessionRequestContent) throws ServiceException {
        UserDAO userDAO;
        String[] lock = sessionRequestContent.getRequestParameters().get(RequestNameConstant.LOCK);
        String[] userId = sessionRequestContent.getRequestParameters().get(RequestNameConstant.ID);
        if (GeneralValidator.isVarExist(lock)) {
            try {
                userDAO = new UserDAOImpl();
                userDAO.updateLock(Long.valueOf(userId[0]), Boolean.valueOf(lock[0]));
            } catch (DAOException e) {
                throw new ServiceException("Sorry, technical error", e);
            }
        }
    }

    @Override
    public void changeAvatar(SessionRequestContent sessionRequestContent) throws ServiceException {

        String[] userId = sessionRequestContent.getRequestParameters().get(RequestNameConstant.USER_ID);
        if (GeneralValidator.isVarExist(userId)) {
            try {
                ImageUploader fileUploader = new ImageUploader();
                Optional<String> filePath = fileUploader.loadFile(sessionRequestContent, IMAGE, DIRECTORY_USER, userId[0]);
                if (filePath.isPresent()) {
                    UserDAO userDAO = new UserDAOImpl();
                    userDAO.changeAvatar(Long.valueOf(userId[0]), filePath.get());
                }
            } catch (DAOException e) {
                throw new ServiceException("Sorry, technical error", e);
            }
        }
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

    @Override
    public List<User> findUsersByStatus(SessionRequestContent sessionRequestContent) throws ServiceException {
        UserDAO userDAO;
        String[] statusId = sessionRequestContent.getRequestParameters().get(RequestNameConstant.STATUS_ID);

        if (GeneralValidator.isVarExist(statusId)) {
            try {
                userDAO = new UserDAOImpl();
                return userDAO.findAllUsersByStatus(Long.valueOf(statusId[0]));
            } catch (DAOException e) {
                throw new ServiceException("Sorry, technical error", e);
            }
        }
        throw new ServiceException("Sorry, technical error");
    }
}
