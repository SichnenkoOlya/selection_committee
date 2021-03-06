package by.sichnenko.committee.command.impl.common;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.constant.GeneralConstant;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.User;
import by.sichnenko.committee.service.UserService;
import by.sichnenko.committee.service.impl.UserServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

import static by.sichnenko.committee.constant.PageNameConstant.*;
import static by.sichnenko.committee.constant.RequestNameConstant.USER;

/**
 * The SignUpCommand class
 */
public class SignUpCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(SignUpCommand.class);

    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        UserService userService = new UserServiceImpl();
        try {
            User newUser = userService.signUp(sessionRequestContent);
            sessionRequestContent.getSessionAttributes().put(USER, newUser);
            return new Router(RouterType.REDIRECT, MAIN_PAGE);
        } catch (ServiceException e) {
            LOGGER.catching(e);
            Set<String> keys = sessionRequestContent.getRequestAttributes().keySet();
            if (keys.contains(GeneralConstant.INCORRECT_DATA) || keys.contains(GeneralConstant.INCORRECT_LOGIN) ||
                    keys.contains(GeneralConstant.INCORRECT_PASSWORD) || keys.contains(GeneralConstant.INCORRECT_EMAIL)
                    || keys.contains(GeneralConstant.INCORRECT_CONFIRM_PASSWORD) || keys.contains(GeneralConstant.SUCH_NAME_EXIST)) {
                return new Router(RouterType.FORWARD, SIGN_UP_PAGE);
            }
            return new Router(RouterType.ERROR);
        }
    }
}
