package by.sichnenko.committee.command.impl;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.User;
import by.sichnenko.committee.service.UserService;
import by.sichnenko.committee.service.impl.UserServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;

import static by.sichnenko.committee.constant.PageNameConstant.CHANGE_PASSWORD_PAGE;
import static by.sichnenko.committee.constant.PageNameConstant.DETEIL_USER_PAGE;

public class ShowChangePasswordPage implements ActionCommand {
    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        return new Router(RouterType.FORWARD, CHANGE_PASSWORD_PAGE);
    }
}
