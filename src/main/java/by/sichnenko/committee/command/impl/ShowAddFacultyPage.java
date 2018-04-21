package by.sichnenko.committee.command.impl;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Subject;
import by.sichnenko.committee.service.SubjectService;
import by.sichnenko.committee.service.impl.SubjectServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;

import java.util.List;

import static by.sichnenko.committee.constant.PageNameConstant.ADD_FACULTY_PAGE;
import static by.sichnenko.committee.constant.PageNameConstant.MAIN_PAGE;

public class ShowAddFacultyPage implements ActionCommand {
    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        SubjectService subjectService = new SubjectServiceImpl();
        try {
            List<Subject> subjects = subjectService.findAllSubjects(sessionRequestContent);
            sessionRequestContent.getRequestAttributes().put("subjects", subjects);
        } catch (ServiceException e) {
            return new Router(RouterType.FORWARD, MAIN_PAGE);
        }
        return new Router(RouterType.FORWARD, ADD_FACULTY_PAGE);
    }
}
