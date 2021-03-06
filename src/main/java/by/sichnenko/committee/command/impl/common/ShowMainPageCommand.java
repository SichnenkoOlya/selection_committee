package by.sichnenko.committee.command.impl.common;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.command.impl.admin.AddCityCommand;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Faculty;
import by.sichnenko.committee.service.FacultyService;
import by.sichnenko.committee.service.impl.FacultyServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static by.sichnenko.committee.constant.PageNameConstant.MAIN_PAGE;
import static by.sichnenko.committee.constant.RequestNameConstant.FACULTIES;

/**
 * The ShowMainPageCommand class
 */
public class ShowMainPageCommand implements ActionCommand {

    private static final Logger LOGGER = LogManager.getLogger(ShowMainPageCommand.class);

    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        FacultyService facultyService = new FacultyServiceImpl();

        try {
            List<Faculty> faculties = facultyService.findAllFaculties();
            sessionRequestContent.getRequestAttributes().put(FACULTIES, faculties);
        } catch (ServiceException e) {
            LOGGER.catching(e);
            return new Router(RouterType.FORWARD, MAIN_PAGE);
        }
        return new Router(RouterType.FORWARD, MAIN_PAGE);
    }
}