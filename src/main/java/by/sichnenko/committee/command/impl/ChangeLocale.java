package by.sichnenko.committee.command.impl;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.constant.RequestNameConstant;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ChangeLocale implements ActionCommand {
    @Override
    public Router execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute(RequestNameConstant.LOCALE, request.getParameter(RequestNameConstant.LOCALE));
        return new Router(RouterType.REDIRECT, defineLastPage(request));
    }
}
