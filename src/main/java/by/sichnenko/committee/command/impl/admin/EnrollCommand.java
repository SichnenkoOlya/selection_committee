package by.sichnenko.committee.command.impl.admin;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.constant.GeneralConstant;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.service.EnrolleeService;
import by.sichnenko.committee.service.impl.EnrolleeServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

/**
 * The EnrollCommand class
 */
public class EnrollCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(EnrollCommand.class);

    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        EnrolleeService enrolleeService = new EnrolleeServiceImpl();
        try {
            enrolleeService.enrollToFaculty(sessionRequestContent);
        } catch (ServiceException e) {
            LOGGER.catching(e);
            Set<String> keys = sessionRequestContent.getRequestAttributes().keySet();
            if (keys.contains(GeneralConstant.INCORRECT_DATA)) {
                return new Router(RouterType.FORWARD, defineLastQuery(sessionRequestContent));
            }
            return new Router(RouterType.ERROR);
        }
        return new Router(RouterType.REDIRECT, defineLastQuery(sessionRequestContent));
    }
}
