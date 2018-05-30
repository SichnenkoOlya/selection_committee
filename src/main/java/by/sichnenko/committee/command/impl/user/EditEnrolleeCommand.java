package by.sichnenko.committee.command.impl.user;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.constant.GeneralConstant;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Enrollee;
import by.sichnenko.committee.service.EnrolleeService;
import by.sichnenko.committee.service.impl.EnrolleeServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

import static by.sichnenko.committee.constant.PageNameConstant.*;
import static by.sichnenko.committee.constant.RequestNameConstant.ENROLLEE;

/**
 * The EditEnrolleeCommand class
 */
public class EditEnrolleeCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(EditEnrolleeCommand.class);

    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        EnrolleeService enrolleeService = new EnrolleeServiceImpl();
        try {
            Enrollee enrollee = enrolleeService.editEnrollee(sessionRequestContent);
            sessionRequestContent.getSessionAttributes().put(ENROLLEE,enrollee);
        } catch (ServiceException e) {
            LOGGER.catching(e);
            Set<String> keys = sessionRequestContent.getRequestAttributes().keySet();
            if (keys.contains(GeneralConstant.INCORRECT_DATA)) {
                return new Router(RouterType.FORWARD, defineLastQuery(sessionRequestContent) );
            }
            return new Router(RouterType.ERROR);
        }
        return new Router(RouterType.REDIRECT, MY_PROFILE_PAGE);
    }
}