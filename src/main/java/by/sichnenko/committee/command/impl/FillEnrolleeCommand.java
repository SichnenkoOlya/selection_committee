package by.sichnenko.committee.command.impl;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Enrollee;
import by.sichnenko.committee.service.EnrolleeService;
import by.sichnenko.committee.service.impl.EnrolleeServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;

import static by.sichnenko.committee.constant.PageNameConstant.MAIN_PAGE;
import static by.sichnenko.committee.constant.RequestNameConstant.NAME;

public class FillEnrolleeCommand implements ActionCommand {
    //Если пришёл post, то redirect
    //ajax
    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        EnrolleeService enrolleeService = new EnrolleeServiceImpl();
        try {
            Enrollee enrollee = enrolleeService.fillEnrollee(sessionRequestContent);
        } catch (ServiceException e) {
            return new Router(RouterType.REDIRECT, MAIN_PAGE);
        }

//        UserService userService = new UserServiceImpl();
//        User authentificatedUser;
//        try {
//            //authentificatedUser = userService.signIn(login, password);
//        } catch (ServiceException e) {
//            //???
//            return ERROR_PAGE;
//        }
//        if (authentificatedUser != null) {
//            HttpSession session = request.getSession();
//            session.setAttribute(NAME, authentificatedUser.getLogin());
//            session.setAttribute(ROLE, authentificatedUser.getRole().toString().toLowerCase());
//            return MAIN_PAGE;
//        }
        return new Router(RouterType.REDIRECT, MAIN_PAGE);
    }
}
