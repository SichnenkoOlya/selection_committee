package by.sichnenko.committee.command.impl.user;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;

import static by.sichnenko.committee.constant.PageNameConstant.MAIN_PAGE;
import static by.sichnenko.committee.constant.RequestNameConstant.*;

public class SignOutCommand implements ActionCommand {
    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        sessionRequestContent.getSessionAttributes().remove(USER);
        sessionRequestContent.getSessionAttributes().remove(LOGIN);
        sessionRequestContent.getSessionAttributes().remove(NAME);
        sessionRequestContent.getSessionAttributes().remove(ROLE);
        return new Router(RouterType.REDIRECT, MAIN_PAGE);
    }
}
