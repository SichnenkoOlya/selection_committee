package by.sichnenko.committee.command.impl.user;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;

import static by.sichnenko.committee.constant.PageNameConstant.CHANGE_PASSWORD_PAGE;

/**
 * The ShowChangePasswordPageCommand class
 */
public class ShowChangePasswordPageCommand implements ActionCommand {

    @Override
    public Router execute(SessionRequestContent sessionRequestContent)  {
        return new Router(RouterType.FORWARD, CHANGE_PASSWORD_PAGE);
    }
}