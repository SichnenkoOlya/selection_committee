package by.sichnenko.committee.command.impl.faculty;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.constant.GeneralConstant;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.service.FacultyService;
import by.sichnenko.committee.service.impl.FacultyServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;

import java.util.Set;

public class AddNewFacultyCommand implements ActionCommand {
    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        FacultyService facultyService = new FacultyServiceImpl();
        try {
            facultyService.addFaculty(sessionRequestContent);
        } catch (ServiceException e) {
            Set<String> keys = sessionRequestContent.getRequestAttributes().keySet();
            if (keys.contains(GeneralConstant.INCORRECT_DATA)||
                    keys.contains(GeneralConstant.FACULTY_EXIST)) {
                return new Router(RouterType.FORWARD, defineQuery(sessionRequestContent));
            }
            return new Router(RouterType.ERROR);
        }
        return new Router(RouterType.REDIRECT, defineQuery(sessionRequestContent));
    }
}
