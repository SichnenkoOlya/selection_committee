package by.sichnenko.committee.service.impl;

import by.sichnenko.committee.constant.GeneralConstant;
import by.sichnenko.committee.constant.RequestNameConstant;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.dao.EnrolleeDAO;
import by.sichnenko.committee.dao.UserDAO;
import by.sichnenko.committee.dao.impl.EnrolleeDAOImpl;
import by.sichnenko.committee.dao.impl.UserDAOImpl;
import by.sichnenko.committee.exception.*;
import by.sichnenko.committee.model.Enrollee;
import by.sichnenko.committee.model.RoleType;
import by.sichnenko.committee.model.User;
import by.sichnenko.committee.service.UserService;
import by.sichnenko.committee.util.ImageUploader;
import by.sichnenko.committee.util.MD5Generator;
import by.sichnenko.committee.validator.GeneralValidator;
import by.sichnenko.committee.validator.UserValidator;

import java.util.HashMap;
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
            throw new ServiceException("Incorrect login or password ");
        }

        try {
            UserDAO userDAO = new UserDAOImpl();
            User user = userDAO.findUserByLogin(login[0]);
            if (user != null) {
                try {
                    if (user.getHashPassword().equals(MD5Generator.generateHash(password[0]))) {
                        if (user.getIsBlocked()) {
                            sessionRequestContent.getRequestAttributes().put(GeneralConstant.BLOCKED_USER, true);
                        }
                        return user;
                    } else {
                        sessionRequestContent.getRequestAttributes().put(GeneralConstant.WRONG_PASSWORD, true);
                        throw new ServiceException("Wrong password ");
                    }
                } catch (TechnicalException e) {
                    throw new ServiceException("Technical error ", e);
                }
            } else {
                sessionRequestContent.getRequestAttributes().put(GeneralConstant.NO_SUCH_NAME, true);
                throw new ServiceException("Login failed. Incorrect login ");
            }
        } catch (DAOException e) {
            throw new ServiceException("Technical error, can not sign in now ", e);
        }
    }

    @Override
    public User signUp(SessionRequestContent sessionRequestContent) throws ServiceException {
        String[] login = sessionRequestContent.getRequestParameters().get(RequestNameConstant.LOGIN);
        String[] password = sessionRequestContent.getRequestParameters().get(RequestNameConstant.PASSWORD);
        String[] confirmPassword = sessionRequestContent.getRequestParameters().get(RequestNameConstant.CONFIRM_PASSWORD);
        String[] email = sessionRequestContent.getRequestParameters().get(RequestNameConstant.EMAIL);

        if (!GeneralValidator.isVarExist(login) || !GeneralValidator.isVarExist(password)
                || !GeneralValidator.isVarExist(email) || !GeneralValidator.isVarExist(confirmPassword)) {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
            //TODO: можно ли бросать exception?
            throw new ServiceException("Incorrect data ");
        }
        try {
            UserDAO userDAO = new UserDAOImpl();

            if (userDAO.findUserByLogin(login[0]) != null) {
                sessionRequestContent.getRequestAttributes().put(GeneralConstant.SUCH_NAME_EXIST, true);
                throw new ServiceException("Such login is already exist ");
            }
            if (!UserValidator.validateLogin(login[0])) {
                sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_LOGIN, true);
                throw new ServiceException("Invalid login ");
            }
            if (!UserValidator.validatePassword(password[0])) {
                sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_PASSWORD, true);
                throw new ServiceException("Invalid password ");
            }
            if (!confirmPassword[0].equals(password[0])) {
                sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_CONFIRM_PASSWORD, true);
                throw new ServiceException("Invalid password and confirm password ");
            }
            if (!UserValidator.validateEmail(email[0])) {
                sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_EMAIL, true);
                throw new ServiceException("Invalid email ");
            }

            User user = new User();
            user.setLogin(login[0]);
            user.setHashPassword(MD5Generator.generateHash(password[0]));
            user.setEmail(email[0]);
            user.setRole(RoleType.USER);
            userDAO.create(user);
            return user;

        } catch (TechnicalException e) {
            throw new ServiceException("Technical exception, can not register new user", e);
        } catch (DAOException e) {
            throw new ServiceException("Sign up error ", e);
        }

    }

    @Override
    public void changeUserRole(SessionRequestContent sessionRequestContent) throws ServiceException {
        String[] newRole = sessionRequestContent.getRequestParameters().get(RequestNameConstant.ROLE);
        String[] userId = sessionRequestContent.getRequestParameters().get(RequestNameConstant.ID);
        if (!GeneralValidator.isVarExist(newRole) || !GeneralValidator.isPositiveNumber(userId)) {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
            throw new ServiceException("Incorrect data");
        }
        try {
            UserDAO userDAO = new UserDAOImpl();
            userDAO.updateRole(Long.valueOf(userId[0]), RoleType.valueOf(newRole[0]));
        } catch (IllegalArgumentException e) {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
            throw new ServiceException("Incorrect data");
        } catch (DAOException e) {
            throw new ServiceException("Change user role error ", e);
        }

    }

    @Override
    public void editProfile(SessionRequestContent sessionRequestContent) throws ServiceException {
        String[] newLogin = sessionRequestContent.getRequestParameters().get(RequestNameConstant.NEW_LOGIN);
        String[] email = sessionRequestContent.getRequestParameters().get(RequestNameConstant.EMAIL);
        String[] login = sessionRequestContent.getRequestParameters().get(RequestNameConstant.LOGIN);
        UserDAO userDAO = new UserDAOImpl();
        User user;

        if (!GeneralValidator.isVarExist(login) || !GeneralValidator.isVarExist(email)
                || !GeneralValidator.isVarExist(newLogin)) {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
            throw new ServiceException("Incorrect data");
        }

        if (!UserValidator.validateLogin(newLogin[0])) {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_LOGIN, true);
            throw new ServiceException("Incorrect new login");
        }

        if (!UserValidator.validateEmail(email[0])) {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_EMAIL, true);
            throw new ServiceException("Incorrect new email");
        }

        try {
            user = userDAO.findUserByLogin(login[0]);
            if (user == null) {
                sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
                throw new ServiceException("No such user");
            }
            User userWithNewLogin = userDAO.findUserByLogin(newLogin[0]);
            if (userWithNewLogin != null) {
                sessionRequestContent.getRequestAttributes().put(GeneralConstant.SUCH_NAME_EXIST, true);
                throw new ServiceException("Such user exist");
            }
        } catch (DAOException e) {
            throw new ServiceException("Find user error", e);
        }

        try {
            user.setLogin(newLogin[0]);
            user.setEmail(email[0]);
            userDAO.update(user);
        } catch (DAOException e) {
            throw new ServiceException("Edit profile error", e);
        }
    }

    @Override
    public void changeUserPassword(SessionRequestContent sessionRequestContent) throws ServiceException {
        UserDAO userDAO = new UserDAOImpl();
        String[] newPassword = sessionRequestContent.getRequestParameters().get(RequestNameConstant.NEW_PASSWORD);
        String[] confirmPassword = sessionRequestContent.getRequestParameters().get(RequestNameConstant.CONFIRM_PASSWORD);
        String[] oldPassword = sessionRequestContent.getRequestParameters().get(RequestNameConstant.OLD_PASSWORD);
        String login = sessionRequestContent.getSessionAttributes().get(RequestNameConstant.LOGIN).toString();

        if (!GeneralValidator.isVarExist(login) || !GeneralValidator.isVarExist(newPassword)
                || !GeneralValidator.isVarExist(confirmPassword) || !GeneralValidator.isVarExist(oldPassword)) {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
            throw new ServiceException("Incorrect data ");
        }

        try {
            User user = userDAO.findUserByLogin(login);
            if (user == null) {
                sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
                throw new ServiceException("No such user ");
            }
            try {
                if (MD5Generator.generateHash(newPassword[0]).equals(MD5Generator.generateHash(confirmPassword[0]))) {
                    if (user.getHashPassword().equals(MD5Generator.generateHash(oldPassword[0]))) {
                        userDAO = new UserDAOImpl();
                        userDAO.updatePassword(user.getUserId(), MD5Generator.generateHash(newPassword[0]));
                    } else {
                        sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_OLD_PASSWORD, true);
                        throw new ServiceException("Passwords not equals ");
                    }
                } else {
                    sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_CONFIRM_PASSWORD, true);
                    throw new ServiceException("Passwords not equals ");
                }
            } catch (TechnicalException e) {
                throw new ServiceException("Technical error ", e);
            }
        } catch (DAOException e) {
            throw new ServiceException("Update user password error ", e);
        }
    }

    @Override
    public void changeUserLock(SessionRequestContent sessionRequestContent) throws ServiceException {
        String[] lock = sessionRequestContent.getRequestParameters().get(RequestNameConstant.LOCK);
        String[] userId = sessionRequestContent.getRequestParameters().get(RequestNameConstant.ID);

        if (!GeneralValidator.isVarExist(lock) || !GeneralValidator.isPositiveNumber(userId)) {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
            throw new ServiceException("Incorrect data ");
        }

        try {
            UserDAO userDAO = new UserDAOImpl();
            userDAO.updateLock(Long.valueOf(userId[0]), Boolean.valueOf(lock[0]));
        } catch (DAOException e) {
            throw new ServiceException("Change user lock error ", e);
        }

    }

    @Override
    public void changeAvatar(SessionRequestContent sessionRequestContent) throws ServiceException {

        String[] userId = sessionRequestContent.getRequestParameters().get(RequestNameConstant.USER_ID);
        if (GeneralValidator.isPositiveNumber(userId)) {
            try {
                ImageUploader fileUploader = new ImageUploader();
                Optional<String> filePath = fileUploader.loadFile(sessionRequestContent, IMAGE, DIRECTORY_USER, userId[0]);
                if (filePath.isPresent()) {
                    UserDAO userDAO = new UserDAOImpl();
                    userDAO.updateImagePath(Long.valueOf(userId[0]), filePath.get());
                } else {
                    sessionRequestContent.getRequestAttributes().put(GeneralConstant.IMAGE_NOT_LOADED, true);
                    throw new ServiceException("Image has not loaded ");
                }
            } catch (DAOException e) {
                throw new ServiceException("Change avatar error ", e);
            }
        } else {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
            throw new ServiceException("Incorrect data ");
        }
    }

    @Override
    public List<User> findAllUsers() throws ServiceException {
        try {
            UserDAO userDAO = new UserDAOImpl();
            return userDAO.findAll();
        } catch (DAOException e) {
            throw new ServiceException("Find users error ", e);
        }
    }

    @Override
    public HashMap<User, Long> findAllUsersAndStatus() throws ServiceException {
        try {
            UserDAO userDAO = new UserDAOImpl();
            EnrolleeDAO enrolleeDAO = new EnrolleeDAOImpl();
            HashMap<User, Long> userHashMap = new HashMap<>();
            List<User> users = userDAO.findAll();
            for (User user : users) {
                Enrollee enrollee = enrolleeDAO.findEnrolleeByUserId(user.getUserId());
                if (enrollee != null) {
                    userHashMap.put(user, enrollee.getStatusId());
                } else {
                    userHashMap.put(user, null);
                }
            }
            return userHashMap;
        } catch (DAOException e) {
            throw new ServiceException("Find users error ", e);
        }
    }

    @Override
    public User findUser(SessionRequestContent sessionRequestContent) throws ServiceException {
        String[] login = sessionRequestContent.getRequestParameters().get(RequestNameConstant.LOGIN);
        if (!GeneralValidator.isVarExist(login)) {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
            throw new ServiceException("Incorrect data");
        }
        try {
            UserDAOImpl userDAO = new UserDAOImpl();
            return userDAO.findUserByLogin(login[0]);
        } catch (DAOException e) {
            throw new ServiceException("Find user error ", e);
        }
    }

    @Override
    public List<User> findUsersByStatus(SessionRequestContent sessionRequestContent) throws ServiceException {
        String[] statusId = sessionRequestContent.getRequestParameters().get(RequestNameConstant.STATUS_ID);

        if (GeneralValidator.isPositiveNumber(statusId)) {
            try {
                UserDAO userDAO = new UserDAOImpl();
                return userDAO.findAllUsersByStatus(Long.valueOf(statusId[0]));
            } catch (DAOException e) {
                throw new ServiceException("Find users error ", e);
            }
        } else {
            sessionRequestContent.getRequestAttributes().put(GeneralConstant.INCORRECT_DATA, true);
            throw new ServiceException("Incorrect data ");
        }
    }
}
