package by.sichnenko.committee.command.impl.user;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.constant.RequestNameConstant;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.User;
import by.sichnenko.committee.service.UserService;
import by.sichnenko.committee.service.impl.UserServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;

import java.util.HashMap;
import java.util.List;

import static by.sichnenko.committee.constant.PageNameConstant.ALL_USERS_PAGE;

public class ShowUsersWirhStatus implements ActionCommand {
    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        UserService userService = new UserServiceImpl();

        try {
            List<User> users = userService.findUsersByStatus(sessionRequestContent);
            sessionRequestContent.getRequestAttributes().put(RequestNameConstant.USERS, users);

        } catch (ServiceException e) {
            return new Router(RouterType.FORWARD, ALL_USERS_PAGE);
        }
        return new Router(RouterType.FORWARD, ALL_USERS_PAGE);
    }
}
