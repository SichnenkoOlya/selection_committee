package by.sichnenko.committee.command.impl;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.constant.RequestNameConstant;
import by.sichnenko.committee.content.SessionRequestContent;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;
import by.sichnenko.committee.validator.GeneralValidator;


public class ChangeLocale implements ActionCommand {
    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        String[] localeParameters = sessionRequestContent.getRequestParameters().get(RequestNameConstant.LOCALE);
        if (GeneralValidator.isVarExist(localeParameters)) {
            String locale = sessionRequestContent.getRequestParameters().get(RequestNameConstant.LOCALE)[0];
            sessionRequestContent.getSessionAttributes().put(RequestNameConstant.LOCALE, locale);
        }
        return new Router(RouterType.REDIRECT, defineLastPage(sessionRequestContent));
    }
}
