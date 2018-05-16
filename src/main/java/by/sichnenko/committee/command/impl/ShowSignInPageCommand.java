package by.sichnenko.committee.command.impl;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;

import static by.sichnenko.committee.constant.PageNameConstant.SIGN_IN_PAGE;

public class ShowSignInPageCommand implements ActionCommand {

    @Override
    public Router execute(SessionRequestContent sessionRequestContent)  {
        return new Router(RouterType.FORWARD, SIGN_IN_PAGE);
    }
}