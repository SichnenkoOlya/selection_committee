package by.sichnenko.committee.command.impl;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Enrollee;
import by.sichnenko.committee.model.Faculty;
import by.sichnenko.committee.service.FacultyService;
import by.sichnenko.committee.service.impl.FacultyServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;

import static by.sichnenko.committee.constant.PageNameConstant.MY_PROFILE_PAGE;
import static by.sichnenko.committee.constant.RequestNameConstant.ENROLLEE;
import static by.sichnenko.committee.constant.RequestNameConstant.FACULTY_ID;
import static by.sichnenko.committee.constant.RequestNameConstant.FACULTY_NAME;

public class ShowMyProfilePageCommand implements ActionCommand {

    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        if (sessionRequestContent.getSessionAttributes().containsKey(ENROLLEE)) {
            Enrollee enrollee = ((Enrollee) sessionRequestContent.getSessionAttributes().get(ENROLLEE));
            FacultyService facultyService = new FacultyServiceImpl();
            sessionRequestContent.getRequestParameters().put(FACULTY_ID, new String[]{String.valueOf(enrollee.getFacultyId())});
            try {
                Faculty faculty = facultyService.findFacultyById(sessionRequestContent);
                sessionRequestContent.getRequestAttributes().put(FACULTY_NAME, faculty.getName());
            } catch (ServiceException e) {
                return new Router(RouterType.FORWARD, MY_PROFILE_PAGE);
            }
        }
        return new Router(RouterType.FORWARD, MY_PROFILE_PAGE);
    }
}