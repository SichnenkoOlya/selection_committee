package by.sichnenko.committee.command.impl;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.User;
import by.sichnenko.committee.service.UserService;
import by.sichnenko.committee.service.impl.UserServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;

import java.util.List;

import static by.sichnenko.committee.constant.PageNameConstant.ALL_USERS_PAGE;
import static by.sichnenko.committee.constant.PageNameConstant.DETEIL_USER_PAGE;
import static by.sichnenko.committee.constant.RequestNameConstant.LOGIN;

public class ShowDetailUserPage implements ActionCommand {
    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        String[] login=sessionRequestContent.getRequestParameters().get(LOGIN);

        UserService userService = new UserServiceImpl();

        try {
            User user = userService.findUser(sessionRequestContent);
            sessionRequestContent.getRequestAttributes().put("user", user);

        } catch (ServiceException e) {
            return new Router(RouterType.FORWARD, DETEIL_USER_PAGE);
        }
        return new Router(RouterType.FORWARD, DETEIL_USER_PAGE);
    }
}
