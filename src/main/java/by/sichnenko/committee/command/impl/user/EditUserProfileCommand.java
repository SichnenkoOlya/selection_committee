package by.sichnenko.committee.command.impl.user;

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

import static by.sichnenko.committee.constant.RequestNameConstant.USER;

/**
 * The EditUserProfileCommand class
 */
public class EditUserProfileCommand implements ActionCommand{
    private static final Logger LOGGER = LogManager.getLogger(EditUserProfileCommand.class);

    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        UserService userService = new UserServiceImpl();
        try {
            User updatedUser =userService.editProfile(sessionRequestContent);
            sessionRequestContent.getSessionAttributes().put(USER, updatedUser);
        } catch (ServiceException e) {
            LOGGER.catching(e);
            Set<String> keys = sessionRequestContent.getRequestAttributes().keySet();
            if (keys.contains(GeneralConstant.INCORRECT_DATA) || keys.contains(GeneralConstant.INCORRECT_LOGIN) ||
                    keys.contains(GeneralConstant.INCORRECT_EMAIL) || keys.contains(GeneralConstant.SUCH_NAME_EXIST)
                    || keys.contains(GeneralConstant.INCORRECT_PASSWORD)) {
                return new Router(RouterType.FORWARD, defineLastQuery(sessionRequestContent));
            }
            return new Router(RouterType.ERROR);
        }
        return new Router(RouterType.REDIRECT, defineLastQuery(sessionRequestContent));
    }
}
