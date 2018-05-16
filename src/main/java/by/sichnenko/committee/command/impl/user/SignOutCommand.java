package by.sichnenko.committee.command.impl.user;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;

import static by.sichnenko.committee.constant.PageNameConstant.MAIN_PAGE;

public class SignOutCommand implements ActionCommand {
    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        sessionRequestContent.setNeedInvalidateSession(true);
        return new Router(RouterType.REDIRECT, MAIN_PAGE);
    }
}
