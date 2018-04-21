package by.sichnenko.committee.command.impl;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.service.UserService;
import by.sichnenko.committee.service.impl.UserServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;

public class ChangeUserRoleCommand implements ActionCommand {
    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        UserService userService = new UserServiceImpl();
        try {
            userService.changeUserRole(sessionRequestContent);
        } catch (ServiceException e) {
            return new Router(RouterType.FORWARD, defineLastPage(sessionRequestContent));
        }
        return new Router(RouterType.REDIRECT, defineLastPage(sessionRequestContent));
    }
}
