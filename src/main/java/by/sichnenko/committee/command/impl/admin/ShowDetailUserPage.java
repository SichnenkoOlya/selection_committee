package by.sichnenko.committee.command.impl.admin;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.constant.GeneralConstant;
import by.sichnenko.committee.constant.RequestNameConstant;
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

import static by.sichnenko.committee.constant.PageNameConstant.DETAIL_USER_PAGE;
import static by.sichnenko.committee.constant.RequestNameConstant.FACULTY_ID;

/**
 * The ShowDetailUserPage class
 */
public class ShowDetailUserPage implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(ShowDetailUserPage.class);

    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        UserService userService = new UserServiceImpl();
        EnrolleeService enrolleeService = new EnrolleeServiceImpl();
        FacultyService facultyService = new FacultyServiceImpl();

        try {
            User user = userService.findUser(sessionRequestContent);
            Enrollee enrollee = enrolleeService.findEnrolleeByUser(sessionRequestContent);
            if (enrollee != null) {
                sessionRequestContent.getRequestParameters().put(FACULTY_ID, new String[]{String.valueOf(enrollee.getFacultyId())});
                Faculty faculty = facultyService.findFacultyById(sessionRequestContent);
                sessionRequestContent.getRequestAttributes().put(RequestNameConstant.FACULTY, faculty);
            }
            sessionRequestContent.getRequestAttributes().put(RequestNameConstant.FIND_ENROLLEE, enrollee);
            sessionRequestContent.getRequestAttributes().put(RequestNameConstant.FIND_USER, user);

        } catch (ServiceException e) {
            LOGGER.catching(e );
            Set<String> keys = sessionRequestContent.getRequestAttributes().keySet();
            if (keys.contains(GeneralConstant.INCORRECT_DATA)) {
                return new Router(RouterType.FORWARD, DETAIL_USER_PAGE);
            }
            return new Router(RouterType.ERROR);
        }
        return new Router(RouterType.FORWARD, DETAIL_USER_PAGE);
    }
}
