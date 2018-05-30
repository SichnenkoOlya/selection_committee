package by.sichnenko.committee.command.impl.user;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.constant.GeneralConstant;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Enrollee;
import by.sichnenko.committee.model.Faculty;
import by.sichnenko.committee.model.User;
import by.sichnenko.committee.service.EnrolleeService;
import by.sichnenko.committee.service.FacultyService;
import by.sichnenko.committee.service.UserService;
import by.sichnenko.committee.service.impl.EnrolleeServiceImpl;
import by.sichnenko.committee.service.impl.FacultyServiceImpl;
import by.sichnenko.committee.service.impl.UserServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

import static by.sichnenko.committee.constant.PageNameConstant.MY_PROFILE_PAGE;
import static by.sichnenko.committee.constant.RequestNameConstant.*;
import static by.sichnenko.committee.constant.RequestNameConstant.USER;

/**
 * The ShowMyProfilePageCommand class
 */
public class ShowMyProfilePageCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(ShowMyProfilePageCommand.class);

    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        if (sessionRequestContent.getSessionAttributes().containsKey(ENROLLEE)) {
            UserService userService = new UserServiceImpl();
            EnrolleeService enrolleeService = new EnrolleeServiceImpl();
            Enrollee enrollee = ((Enrollee) sessionRequestContent.getSessionAttributes().get(ENROLLEE));
            FacultyService facultyService = new FacultyServiceImpl();
            sessionRequestContent.getRequestParameters().put(FACULTY_ID, new String[]{String.valueOf(enrollee.getFacultyId())});
            try {
                Faculty faculty = facultyService.findFacultyById(sessionRequestContent);
                sessionRequestContent.getRequestAttributes().put(FACULTY_NAME, faculty.getName());
                sessionRequestContent.getRequestParameters().put(LOGIN, new String[]{((User) sessionRequestContent.getSessionAttributes().get(USER)).getLogin()});
                User user = userService.findUser(sessionRequestContent);
                sessionRequestContent.getSessionAttributes().put(USER, user);
                sessionRequestContent.getRequestParameters().put(USER_ID, new String[]{ String.valueOf (((User) sessionRequestContent.getSessionAttributes().get(USER)).getUserId())});
                sessionRequestContent.getSessionAttributes().put(ENROLLEE, enrolleeService.findEnrolleeByUser(sessionRequestContent));
            } catch (ServiceException e) {
                LOGGER.catching(e);
                Set<String> keys = sessionRequestContent.getRequestAttributes().keySet();
                if (keys.contains(GeneralConstant.INCORRECT_DATA)) {
                    return new Router(RouterType.FORWARD, defineLastQuery(sessionRequestContent));
                }
                return new Router(RouterType.ERROR);
            }
        }
        return new Router(RouterType.FORWARD, MY_PROFILE_PAGE);
    }
}