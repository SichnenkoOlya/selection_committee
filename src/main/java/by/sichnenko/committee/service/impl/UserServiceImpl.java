package by.sichnenko.committee.service.impl;

import by.sichnenko.committee.connection.ConnectionPoolImpl;
import by.sichnenko.committee.connection.ProxyConnection;
import by.sichnenko.committee.dao.impl.UserDAO;
import by.sichnenko.committee.exception.*;
import by.sichnenko.committee.model.RoleType;
import by.sichnenko.committee.model.User;
import by.sichnenko.committee.service.UserService;
import by.sichnenko.committee.util.MD5Generator;
import by.sichnenko.committee.validator.UserValidator;


public class UserServiceImpl implements UserService {

    @Override
    public User signIn(String login, String password) throws ServiceException {
        ProxyConnection connection = null;
        UserDAO userDAO = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            userDAO = new UserDAO(connection);

            User user = userDAO.findUserByLogin(login);
            if (user != null) {
                try {
                    if (user.getHashPassword().equals(MD5Generator.generateHash(password))) {
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
        } catch (ConnectionPoolException e) {
            throw new ServiceException("Sorry, technical error", e);
        } catch (DAOException e) {
            throw new ServiceException("Sorry, technical error", e);
        } finally {
            if (userDAO != null) {
                userDAO.closeConnection(connection);
            }
        }
    }

    @Override
    public User signUp(String login, String password, String email) throws ServiceException {
        ProxyConnection connection = null;
        UserDAO userDAO = null;
        try {
            connection = ConnectionPoolImpl.getInstance().takeConnection();
            userDAO = new UserDAO(connection);

            if (UserValidator.validateName(login)) {
                User user = new User();
                user.setLogin(login);
                user.setHashPassword(MD5Generator.generateHash(password));
                user.setEmail(email);
                user.setRole(RoleType.USER);
                userDAO.create(user);
                return user;
            } else {
                throw new ServiceException("Invalid name");
            }
        }  catch (TechnicalException e) {
            throw new ServiceException("Technical exception", e);
        } catch (ConnectionPoolException e) {
            throw new ServiceException("Invalid name", e);
        } catch (DAOException e) {
            throw new ServiceException("Invalid name", e);
        }
        finally {
            if (userDAO != null) {
                userDAO.closeConnection(connection);
            }
        }
    }
}
