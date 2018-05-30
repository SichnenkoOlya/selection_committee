package by.sichnenko.committee.command.impl.admin;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Subject;
import by.sichnenko.committee.service.SubjectService;
import by.sichnenko.committee.service.impl.SubjectServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static by.sichnenko.committee.constant.PageNameConstant.ADD_FACULTY_PAGE;
import static by.sichnenko.committee.constant.RequestNameConstant.SUBJECTS;

/**
 * The ShowAddFacultyPage class
 */
public class ShowAddFacultyPage implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(ShowAddFacultyPage.class);

    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        SubjectService subjectService = new SubjectServiceImpl();
        try {
            List<Subject> subjects = subjectService.findAllSubjects();
            sessionRequestContent.getRequestAttributes().put(SUBJECTS, subjects);
        } catch (ServiceException e) {
            LOGGER.catching(e);
            return new Router(RouterType.ERROR);
        }
        return new Router(RouterType.FORWARD, ADD_FACULTY_PAGE);
    }
}
