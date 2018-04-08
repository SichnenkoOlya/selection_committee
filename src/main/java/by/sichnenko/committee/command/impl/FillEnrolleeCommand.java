package by.sichnenko.committee.command.impl;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.content.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.User;
import by.sichnenko.committee.service.EnrolleeService;
import by.sichnenko.committee.service.UserService;
import by.sichnenko.committee.service.impl.EnrolleeServiceImpl;
import by.sichnenko.committee.service.impl.UserServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.sichnenko.committee.constant.PageNameConstant.ERROR_PAGE;
import static by.sichnenko.committee.constant.PageNameConstant.MAIN_PAGE;
import static by.sichnenko.committee.constant.RequestNameConstant.*;

public class FillEnrolleeCommand implements ActionCommand {
    //Если пришёл post, то redirect
    //ajax
    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
      /*  String name = request.getParameter(NAME);
        String surname = request.getParameter(SURNAME);
        String patronymic = request.getParameter(PATRONYMIC);
        String phoneNumber = request.getParameter(PHONE_NUMBER);
        String faculty = request.getParameter(FACULTY);
        String login = request.getParameter(LOGIN);
        String city = request.getParameter(CITY);
        String country = request.getParameter(COUNTRY);
        EnrolleeService enrolleeService = new EnrolleeServiceImpl();
        try {
            enrolleeService.fillEnrollee(name, surname, patronymic,faculty ,city, country, phoneNumber);
        } catch (ServiceException e) {
            e.printStackTrace();
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
//        }*/
        return new Router(RouterType.REDIRECT, MAIN_PAGE);
    }
}
