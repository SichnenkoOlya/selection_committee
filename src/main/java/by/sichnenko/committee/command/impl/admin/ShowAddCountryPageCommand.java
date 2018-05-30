package by.sichnenko.committee.command.impl.admin;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;

import static by.sichnenko.committee.constant.PageNameConstant.ADD_COUNTRY_PAGE;

/**
 * The ShowAddCountryPageCommand class
 */
public class ShowAddCountryPageCommand implements ActionCommand {
    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        return new Router(RouterType.FORWARD, ADD_COUNTRY_PAGE);
    }
}
