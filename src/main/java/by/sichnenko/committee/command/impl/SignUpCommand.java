package by.sichnenko.committee.command.impl;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.User;
import by.sichnenko.committee.service.UserService;
import by.sichnenko.committee.service.impl.UserServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.sichnenko.committee.constant.PageNameConstant.ERROR_PAGE;
import static by.sichnenko.committee.constant.PageNameConstant.MAIN_PAGE;
import static by.sichnenko.committee.constant.RequestNameConstant.*;

public class SignUpCommand implements ActionCommand {
    @Override
    public Router execute(HttpServletRequest request) {
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        String email = request.getParameter(EMAIL);

        UserService userService = new UserServiceImpl();
        User newUser;
        try {
            newUser = userService.signUp(login, password, email);
            return new Router(RouterType.REDIRECT, MAIN_PAGE);
        } catch (ServiceException e) {
            //???
            return new Router(RouterType.REDIRECT, ERROR_PAGE);
        }

////        if (newUser != null) {
////            HttpSession session = request.getSession();
////            session.setAttribute(NAME, newUser.getLogin());
////            session.setAttribute(ROLE, newUser.getRole().toString().toLowerCase());
////            return MAIN_PAGE;
////        }
//        return ERROR_PAGE;
    }
}
