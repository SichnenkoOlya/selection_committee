package by.sichnenko.committee.command;

import by.sichnenko.committee.controller.SessionRequestContent;
import by.sichnenko.committee.util.Router;

import static by.sichnenko.committee.constant.PageNameConstant.MAIN_PAGE;
import static by.sichnenko.committee.constant.RequestNameConstant.LAST_PAGE;

public interface ActionCommand {
    Router execute(SessionRequestContent sessionRequestContent);

    default String defineLastPage(SessionRequestContent sessionRequestContent) {
        String lastPage;
        if (sessionRequestContent.getSessionAttributes().get(LAST_PAGE) == null) {
            lastPage = MAIN_PAGE;
        } else {
            lastPage = String.valueOf(sessionRequestContent.getSessionAttributes().get(LAST_PAGE));
        }
        return lastPage;
    }

    default String defineQuery(SessionRequestContent sessionRequestContent) {
        String lastPage;
        if (sessionRequestContent.getSessionAttributes().get("lastQuery") == null) {
            lastPage = MAIN_PAGE;
        } else {
            lastPage = String.valueOf(sessionRequestContent.getSessionAttributes().get("lastQuery"));
        }
        return lastPage;
    }
}