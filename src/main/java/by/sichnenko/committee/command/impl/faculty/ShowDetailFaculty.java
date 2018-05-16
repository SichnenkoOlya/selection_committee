package by.sichnenko.committee.command.impl.faculty;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.constant.RequestNameConstant;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Faculty;
import by.sichnenko.committee.service.FacultyService;
import by.sichnenko.committee.service.impl.FacultyServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;

import static by.sichnenko.committee.constant.PageNameConstant.DETAIL_FACULTY_PAGE;

public class ShowDetailFaculty implements ActionCommand {
    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        FacultyService facultyService = new FacultyServiceImpl();

        try {
            Faculty faculty = facultyService.findFacultyById(sessionRequestContent);
            sessionRequestContent.getRequestAttributes().put(RequestNameConstant.FACULTY, faculty);

        } catch (ServiceException e) {
            return new Router(RouterType.FORWARD, DETAIL_FACULTY_PAGE);
        }
        return new Router(RouterType.FORWARD, DETAIL_FACULTY_PAGE);
    }
}
