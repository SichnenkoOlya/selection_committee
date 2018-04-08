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
import static by.sichnenko.committee.constant.RequestNameConstant.LOGIN;
import static by.sichnenko.committee.constant.RequestNameConstant.NAME;
import static by.sichnenko.committee.constant.RequestNameConstant.PASSWORD;
import static by.sichnenko.committee.constant.RequestNameConstant.ROLE;

public class SignInCommand implements ActionCommand {
    @Override
    public Router execute(HttpServletRequest request) {
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        UserService userService = new UserServiceImpl();
        User authentificatedUser;
        try {
            authentificatedUser = userService.signIn(login, password);
        } catch (ServiceException e) {
            //???
            request.setAttribute("wrongData",true);
            return new Router(RouterType.REDIRECT, MAIN_PAGE);
        }
        if (authentificatedUser != null) {
            HttpSession session = request.getSession();
            session.setAttribute(NAME, authentificatedUser.getLogin());
            session.setAttribute(ROLE, authentificatedUser.getRole().name().toLowerCase());
            return new Router(RouterType.REDIRECT, MAIN_PAGE);
        }
        return new Router(RouterType.REDIRECT, ERROR_PAGE);
    }
}
