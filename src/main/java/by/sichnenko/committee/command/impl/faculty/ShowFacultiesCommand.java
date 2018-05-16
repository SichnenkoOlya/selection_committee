package by.sichnenko.committee.command.impl.faculty;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Faculty;
import by.sichnenko.committee.service.FacultyService;
import by.sichnenko.committee.service.impl.FacultyServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;

import java.util.List;

import static by.sichnenko.committee.constant.PageNameConstant.MAIN_PAGE;

public class ShowFacultiesCommand implements ActionCommand {
    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
//        FacultyService facultyService = new FacultyServiceImpl();
//
//        try {
//            List<Faculty> faculties = facultyService.findAllFaculties();
//            sessionRequestContent.getRequestAttributes().put("faculties", faculties);
//
//        } catch (ServiceException e) {
//            return new Router(RouterType.FORWARD, MAIN_PAGE);
//        }
        return new Router(RouterType.FORWARD, MAIN_PAGE);
    }
}
