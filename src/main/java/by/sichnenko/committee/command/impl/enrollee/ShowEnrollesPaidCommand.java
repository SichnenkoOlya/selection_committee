package by.sichnenko.committee.command.impl.enrollee;

import by.sichnenko.committee.command.ActionCommand;
import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.exception.ServiceException;
import by.sichnenko.committee.model.Enrollee;
import by.sichnenko.committee.service.EnrolleeService;
import by.sichnenko.committee.service.impl.EnrolleeServiceImpl;
import by.sichnenko.committee.type.RouterType;
import by.sichnenko.committee.util.Router;

import java.util.List;

import static by.sichnenko.committee.constant.PageNameConstant.ENROLLEE_LIST_PAGE;
import static by.sichnenko.committee.constant.PageNameConstant.FILL_ENROLLEE_PAGE;

public class ShowEnrollesPaidCommand implements ActionCommand {
    @Override
    public Router execute(SessionRequestContent sessionRequestContent) {
        EnrolleeService enrolleeService=new EnrolleeServiceImpl();
        try {
            List<Enrollee> enrolleesPaid=enrolleeService.findEnrolleesEnteredFacultyPaid(sessionRequestContent);
            sessionRequestContent.getRequestAttributes().put("enrollees", enrolleesPaid);
        } catch (ServiceException e) {
            return new Router(RouterType.FORWARD, FILL_ENROLLEE_PAGE);
        }
        return new Router(RouterType.FORWARD, ENROLLEE_LIST_PAGE);
    }
}
