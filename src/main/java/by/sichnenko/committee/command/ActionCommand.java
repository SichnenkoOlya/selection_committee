package by.sichnenko.committee.command;

import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.util.Router;

import static by.sichnenko.committee.constant.PageNameConstant.MAIN_PAGE;
import static by.sichnenko.committee.constant.RequestNameConstant.CURRENT_QUERY;
import static by.sichnenko.committee.constant.RequestNameConstant.LAST_QUERY;

public interface ActionCommand {
    Router execute(SessionRequestContent sessionRequestContent);

    default String defineLastQuery(SessionRequestContent sessionRequestContent) {
        String lastPage;
        if (sessionRequestContent.getSessionAttributes().get(LAST_QUERY) == null) {
            lastPage = MAIN_PAGE;
        } else {
            lastPage = String.valueOf(sessionRequestContent.getSessionAttributes().get(LAST_QUERY));
        }
        return lastPage;
    }

    default String defineCurrentQuery(SessionRequestContent sessionRequestContent) {
        String lastPage;
        if (sessionRequestContent.getSessionAttributes().get(CURRENT_QUERY) == null) {
            lastPage = MAIN_PAGE;
        } else {
            lastPage = String.valueOf(sessionRequestContent.getSessionAttributes().get(CURRENT_QUERY));
        }
        return lastPage;
    }
}