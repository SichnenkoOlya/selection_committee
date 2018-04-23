package by.sichnenko.committee.command.impl.faculty;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Subject;
import by.sichnenko.committee.service.FacultyService;
import by.sichnenko.committee.service.SubjectService;
import by.sichnenko.committee.service.impl.FacultyServiceImpl;
import by.sichnenko.committee.service.impl.SubjectServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;
import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import static by.sichnenko.committee.constant.PageNameConstant.ADD_FACULTY_PAGE;
import static by.sichnenko.committee.constant.PageNameConstant.FILL_ENROLLEE_PAGE;

public class FindSubjectsByFacultyCommand implements ActionCommand {
    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        SubjectService subjectService = new SubjectServiceImpl();
        try {
            List<Subject> subjects = subjectService.findSubjetsForFaculty(sessionRequestContent);
            sessionRequestContent.setAjaxParameter(JSONArray.fromObject(subjects));
        } catch (ServiceException e) {
            return new Router(RouterType.FORWARD, FILL_ENROLLEE_PAGE);
        }
        return new Router(RouterType.AJAX, defineLastPage(sessionRequestContent));

    }
}
