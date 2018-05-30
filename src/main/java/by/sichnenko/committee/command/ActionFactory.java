package by.sichnenko.committee.command;

import by.sichnenko.committee.command.impl.common.ShowMainPageCommand;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    private static final String REQUEST_PARAMETER = "command";
    private static final CommandProvider PROVIDER = new CommandProvider();

    public ActionCommand defineCommand(HttpServletRequest request) {
        String action = request.getParameter(REQUEST_PARAMETER);
        if (action == null || action.isEmpty()) {
            return new ShowMainPageCommand();
        }
        return PROVIDER.getCommand(action);
    }
}