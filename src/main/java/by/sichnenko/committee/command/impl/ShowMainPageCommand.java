package by.sichnenko.committee.command.impl;

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
import static by.sichnenko.committee.constant.RequestNameConstant.FACULTIES;

public class ShowMainPageCommand implements ActionCommand {

    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        FacultyService facultyService = new FacultyServiceImpl();

        try {
            List<Faculty> faculties = facultyService.findAllFaculties();
            sessionRequestContent.getRequestAttributes().put(FACULTIES, faculties);


        } catch (ServiceException e) {
            return new Router(RouterType.FORWARD, MAIN_PAGE);
        }
        return new Router(RouterType.FORWARD, MAIN_PAGE);
    }
}