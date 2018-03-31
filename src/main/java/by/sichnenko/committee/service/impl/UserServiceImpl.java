package by.sichnenko.committee.service.impl;

import by.sichnenko.committee.exception.RepositoryException;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.User;
import by.sichnenko.committee.repository.impl.UserRepositoryImpl;
import by.sichnenko.committee.service.UserService;
import by.sichnenko.committee.specification.user.FindUserByLoginSpecification;
import by.sichnenko.committee.validator.UserValidator;

import java.util.List;

public class UserServiceImpl implements UserService {
    private static UserRepositoryImpl userRepository = new UserRepositoryImpl();

    @Override
    public User authentification(User user) {
        try {
            List<User> userList = userRepository.query(new FindUserByLoginSpecification(user.getLogin()));
            if (userList.size() == 1) {
                User findUser = userList.get(0);
                if (findUser.getHashPassword().equals(user.getHashPassword())) {
                    return findUser;
                } else {
                    System.out.println("wrong password");
                }
            } else {
                System.out.println("wrong count");
            }
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User registration(User user) throws ServiceException {
        try {
            if (UserValidator.validateName(user.getLogin())) {
                userRepository.add(user);
            } else {
                throw new ServiceException("Invalid name");
            }
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
        return null;
    }
}
