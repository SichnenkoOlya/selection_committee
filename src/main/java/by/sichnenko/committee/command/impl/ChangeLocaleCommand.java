package by.sichnenko.committee.command.impl;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.constant.RequestNameConstant;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;
import by.sichnenko.committee.validator.GeneralValidator;

import javax.servlet.http.Cookie;

public class ChangeLocaleCommand implements ActionCommand {

    private final static int COOKIE_AGE_IN_SEC = 86_400;

    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        String[] localeParameters = sessionRequestContent.getRequestParameters().get(RequestNameConstant.LOCALE);
        if (GeneralValidator.isVarExist(localeParameters)) {
            String locale = sessionRequestContent.getRequestParameters().get(RequestNameConstant.LOCALE)[0];
            sessionRequestContent.getSessionAttributes().put(RequestNameConstant.LOCALE, locale);
            Cookie cookie = new Cookie(RequestNameConstant.LOCALE, locale);
            cookie.setMaxAge(COOKIE_AGE_IN_SEC);
            sessionRequestContent.getCookiesValues().add(cookie);
        }
        return new Router(RouterType.REDIRECT, defineQuery(sessionRequestContent));
    }
}
