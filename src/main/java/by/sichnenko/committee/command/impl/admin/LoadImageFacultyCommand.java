package by.sichnenko.committee.command.impl.admin;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.constant.GeneralConstant;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.service.FacultyService;
import by.sichnenko.committee.service.impl.FacultyServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

/**
 * The LoadImageFacultyCommand class
 */
public class LoadImageFacultyCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(LoadImageFacultyCommand.class);

    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        FacultyService facultyService =new FacultyServiceImpl();
        try {
            facultyService.loadImage(sessionRequestContent);
        } catch (ServiceException e) {
            LOGGER.catching(e);
            Set<String> keys = sessionRequestContent.getRequestAttributes().keySet();
            if (keys.contains(GeneralConstant.INCORRECT_DATA)||keys.contains(GeneralConstant.IMAGE_NOT_LOADED)) {
                return new Router(RouterType.FORWARD, defineCurrentQuery(sessionRequestContent));
            }
            return new Router(RouterType.ERROR);
        }
        return new Router(RouterType.REDIRECT, defineCurrentQuery(sessionRequestContent));
    }
}
