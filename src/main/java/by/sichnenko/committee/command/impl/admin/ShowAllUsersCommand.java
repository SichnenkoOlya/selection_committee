package by.sichnenko.committee.command.impl.admin;

import by.sichnenko.committee.command.ActionCommand;
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

import java.util.HashMap;

import static by.sichnenko.committee.constant.PageNameConstant.ALL_USERS_PAGE;

public class ShowAllUsersCommand implements ActionCommand {
    private static final Logger LOGGER = LogManager.getLogger(ShowAllUsersCommand.class);

    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        UserService userService = new UserServiceImpl();
        try {
            HashMap<User, Long> users = userService.findAllUsersAndStatus();
            sessionRequestContent.getRequestAttributes().put(RequestNameConstant.USERS, users);

        } catch (ServiceException e) {
            LOGGER.catching(e);
            return new Router(RouterType.FORWARD, ALL_USERS_PAGE);
        }
        return new Router(RouterType.FORWARD, ALL_USERS_PAGE);
    }
}
