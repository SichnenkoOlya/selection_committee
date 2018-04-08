package by.sichnenko.committee.command.impl;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.constant.GeneralConstant;
import by.sichnenko.committee.content.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.User;
import by.sichnenko.committee.service.UserService;
import by.sichnenko.committee.service.impl.UserServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Set;

import static by.sichnenko.committee.constant.PageNameConstant.*;
import static by.sichnenko.committee.constant.RequestNameConstant.*;

public class SignUpCommand implements ActionCommand {
    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {

        UserService userService = new UserServiceImpl();
        User newUser;
        try {
            newUser = userService.signUp(sessionRequestContent);
            return new Router(RouterType.REDIRECT, MAIN_PAGE);
        } catch (ServiceException e) {
            //???
            Set<String> keys = sessionRequestContent.getRequestAttributes().keySet();
            if (keys.contains(GeneralConstant.INCORRECT_DATA)) {
                return new Router(RouterType.FORWARD, SIGN_UP_PAGE);
            }
            return new Router(RouterType.REDIRECT, MAIN_PAGE);
        }
    }
}
