package by.sichnenko.committee.command.impl.common;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Subject;
import by.sichnenko.committee.service.SubjectService;
import by.sichnenko.committee.service.impl.SubjectServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;
import net.sf.json.JSONArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * The FindSubjectsByFacultyCommand class
 */
public class FindSubjectsByFacultyCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(FindSubjectsByFacultyCommand.class);
    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        SubjectService subjectService = new SubjectServiceImpl();
        try {
            List<Subject> subjects = subjectService.findSubjetsForFaculty(sessionRequestContent);
            sessionRequestContent.setAjaxParameter(JSONArray.fromObject(subjects));
        } catch (ServiceException e) {
            LOGGER.catching(e);
            sessionRequestContent.setAjaxParameter(JSONArray.fromObject(null));
        }
        return new Router(RouterType.AJAX, defineLastQuery(sessionRequestContent));
    }
}
