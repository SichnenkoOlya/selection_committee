package by.sichnenko.committee.command.impl;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.service.EnrolleeService;
import by.sichnenko.committee.service.impl.EnrolleeServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;

public class ChangeEnrolleeStatus implements ActionCommand {
    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        EnrolleeService enrolleeService = new EnrolleeServiceImpl();
        try {
            enrolleeService.changeStatus(sessionRequestContent);
        } catch (ServiceException e) {
            return new Router(RouterType.REDIRECT, defineLastPage(sessionRequestContent));
        }
        return new Router(RouterType.REDIRECT, defineLastPage(sessionRequestContent));
    }
}
