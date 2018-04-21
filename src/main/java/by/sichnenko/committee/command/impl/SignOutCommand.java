package by.sichnenko.committee.command.impl;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;

import static by.sichnenko.committee.constant.PageNameConstant.MAIN_PAGE;
import static by.sichnenko.committee.constant.RequestNameConstant.NAME;
import static by.sichnenko.committee.constant.RequestNameConstant.ROLE;
import static by.sichnenko.committee.constant.RequestNameConstant.USER;

public class SignOutCommand implements ActionCommand {
    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        sessionRequestContent.getSessionAttributes().remove(USER);
        sessionRequestContent.getSessionAttributes().remove(NAME);
        sessionRequestContent.getSessionAttributes().remove(ROLE);
        return new Router(RouterType.REDIRECT, MAIN_PAGE);
    }
}
