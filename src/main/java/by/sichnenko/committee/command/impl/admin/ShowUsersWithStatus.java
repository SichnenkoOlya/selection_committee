package by.sichnenko.committee.command.impl.admin;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.constant.GeneralConstant;
import by.sichnenko.committee.constant.RequestNameConstant;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.User;
import by.sichnenko.committee.service.UserService;
import by.sichnenko.committee.service.impl.UserServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Set;

import static by.sichnenko.committee.constant.PageNameConstant.ALL_USERS_PAGE;

/**
 * The ShowUsersWithStatus class
 */
public class ShowUsersWithStatus implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(ShowUsersWithStatus.class);

    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        UserService userService = new UserServiceImpl();
        try {
            List<User> users = userService.findUsersByStatus(sessionRequestContent);
            sessionRequestContent.getRequestAttributes().put(RequestNameConstant.USERS, users);

        } catch (ServiceException e) {
            LOGGER.catching(e);
            Set<String> keys = sessionRequestContent.getRequestAttributes().keySet();
            if (keys.contains(GeneralConstant.INCORRECT_DATA)) {
                return new Router(RouterType.FORWARD, ALL_USERS_PAGE);
            }
            return new Router(RouterType.ERROR);
        }
        return new Router(RouterType.FORWARD, ALL_USERS_PAGE);
    }
}
