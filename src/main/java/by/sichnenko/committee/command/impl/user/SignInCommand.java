package by.sichnenko.committee.command.impl.user;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.constant.GeneralConstant;
import by.sichnenko.committee.constant.RequestNameConstant;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Enrollee;
import by.sichnenko.committee.model.User;
import by.sichnenko.committee.service.EnrolleeService;
import by.sichnenko.committee.service.UserService;
import by.sichnenko.committee.service.impl.EnrolleeServiceImpl;
import by.sichnenko.committee.service.impl.UserServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;

import java.util.Set;

import static by.sichnenko.committee.constant.PageNameConstant.*;
import static by.sichnenko.committee.constant.RequestNameConstant.*;

public class SignInCommand implements ActionCommand {
    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        UserService userService = new UserServiceImpl();
        EnrolleeService enrolleeService = new EnrolleeServiceImpl();
        User authenticatedUser;
        Enrollee enrollee;

        try {
            authenticatedUser = userService.signIn(sessionRequestContent);
            enrollee = enrolleeService.findEnrolleeByUser(sessionRequestContent);

            Set<String> keys = sessionRequestContent.getRequestAttributes().keySet();

            if (keys.contains(GeneralConstant.BLOCKED_USER)) {
                return new Router(RouterType.FORWARD, SIGN_IN_PAGE);
            }

        } catch (ServiceException e) {
            Set<String> keys = sessionRequestContent.getRequestAttributes().keySet();

            if (keys.contains(GeneralConstant.INCORRECT_DATA) || keys.contains(GeneralConstant.WRONG_PASSWORD) ||
                    keys.contains(GeneralConstant.NO_SUCH_NAME)) {
                return new Router(RouterType.FORWARD, SIGN_IN_PAGE);
            }
            return new Router(RouterType.ERROR);
        }

        if (authenticatedUser != null) {
            sessionRequestContent.getSessionAttributes().put(USER, authenticatedUser);
            sessionRequestContent.getSessionAttributes().put(LOGIN, authenticatedUser.getLogin());
            sessionRequestContent.getSessionAttributes().put(ROLE, authenticatedUser.getRole());
            if (enrollee != null) {
                sessionRequestContent.getSessionAttributes().put(ENROLLEE, enrollee);
            }
        }
        return new Router(RouterType.REDIRECT, MAIN_PAGE);
    }
}
