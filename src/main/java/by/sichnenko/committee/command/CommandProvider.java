package by.sichnenko.committee.command;

import by.sichnenko.committee.command.impl.*;

import java.util.EnumMap;

import static by.sichnenko.committee.command.CommandEnum.*;

public class CommandProvider {
    private static EnumMap<CommandEnum, ActionCommand> commands = new EnumMap<>(CommandEnum.class);

    CommandProvider() {
        commands.put(EMAIL_SEND, new SendEmail());
        commands.put(MAIN, new Main());
        commands.put(FILE_LOAD, new LoadFile());
        commands.put(SIGN_IN, new SignInCommand());
        commands.put(SIGN_UP, new SignUpCommand());
        commands.put(SIGN_OUT, new SignOutCommand());
        commands.put(FILL_ENROLLEE, new FillEnrolleeCommand());
        commands.put(CHANGE_LOCALE, new ChangeLocale());
        commands.put(SHOW_ENROLLEE_FILL_PAGE, new ShowEnrolleeFillPage());
        commands.put(SHOW_ALL_USERS, new ShowAllUsers());
        commands.put(SHOW_DETAIL_USER, new ShowDetailUserPage());
    }

     ActionCommand getCommand(String commandName) {
        return commands.get(CommandEnum.valueOf(commandName));
    }

}