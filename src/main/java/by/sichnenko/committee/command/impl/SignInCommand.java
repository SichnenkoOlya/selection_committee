package by.sichnenko.committee.command.impl;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.constant.GeneralConstant;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.User;
import by.sichnenko.committee.service.UserService;
import by.sichnenko.committee.service.impl.UserServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

import static by.sichnenko.committee.constant.PageNameConstant.*;
import static by.sichnenko.committee.constant.RequestNameConstant.LOGIN;
import static by.sichnenko.committee.constant.RequestNameConstant.NAME;
import static by.sichnenko.committee.constant.RequestNameConstant.ROLE;

public class SignInCommand implements ActionCommand {
    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        UserService userService = new UserServiceImpl();
        User authentificatedUser;
        try {
            authentificatedUser = userService.signIn(sessionRequestContent);
        } catch (ServiceException e) {
            Set<String> keys = sessionRequestContent.getRequestAttributes().keySet();

            if (keys.contains(GeneralConstant.INCORRECT_DATA)) {
                return new Router(RouterType.FORWARD, SIGN_IN_PAGE);
            }
            return new Router(RouterType.REDIRECT, MAIN_PAGE);
        }
        if (authentificatedUser != null) {
            sessionRequestContent.getSessionAttributes().put(LOGIN, authentificatedUser.getLogin());
            sessionRequestContent.getSessionAttributes().put(ROLE, authentificatedUser.getRole().name().toLowerCase());
            return new Router(RouterType.REDIRECT, MAIN_PAGE);
        }
        return new Router(RouterType.REDIRECT, ERROR_PAGE);
    }
}
