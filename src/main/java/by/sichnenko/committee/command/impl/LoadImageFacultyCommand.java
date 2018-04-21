package by.sichnenko.committee.command.impl;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.service.FacultyService;
import by.sichnenko.committee.service.impl.FacultyServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;

import static by.sichnenko.committee.constant.PageNameConstant.MAIN_PAGE;

public class LoadImageFacultyCommand implements ActionCommand {
    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        FacultyService facultyService =new FacultyServiceImpl();
        try {
            facultyService.loadImage(sessionRequestContent);
        } catch (ServiceException e) {
            return new Router(RouterType.REDIRECT, MAIN_PAGE);
        }
        return new Router(RouterType.REDIRECT, MAIN_PAGE);
    }
}
