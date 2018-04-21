package by.sichnenko.committee.command;

import by.sichnenko.committee.command.impl.*;

import java.util.EnumMap;

import static by.sichnenko.committee.command.CommandEnum.*;

public class CommandProvider {
    private static EnumMap<CommandEnum, ActionCommand> commands = new EnumMap<>(CommandEnum.class);

    CommandProvider() {
        commands.put(EMAIL_SEND, new SendEmail());
        commands.put(MAIN, new ShowMainPageCommand());
        commands.put(FILE_LOAD, new LoadFile());
        commands.put(SIGN_IN, new SignInCommand());
        commands.put(SIGN_UP, new SignUpCommand());
        commands.put(SIGN_OUT, new SignOutCommand());
        commands.put(FILL_ENROLLEE, new FillEnrolleeCommand());
        commands.put(CHANGE_LOCALE, new ChangeLocale());
        commands.put(SHOW_ENROLLEE_FILL_PAGE, new ShowEnrolleeFillPage());
        commands.put(SHOW_ALL_USERS, new ShowAllUsers());
        commands.put(SHOW_DETAIL_USER, new ShowDetailUserPage());
        commands.put(CHANGE_USER_LOCK, new ChangeUserLockCommand());
        commands.put(CHANGE_USER_ROLE, new ChangeUserRoleCommand());
        commands.put(SHOW_USERS_BY_STATUS, new ShowUsersWirhStatus());
        commands.put(SHOW_DETAIL_FACULTY, new ShowDetailFaculty());
        commands.put(SHOW_CHANGE_PASSWORD_PAGE, new ShowChangePasswordPage());
        commands.put(CHANGE_PASSWORD, new ChangePasswordCommand());
        commands.put(SHOW_ADD_FACULTY_PAGE, new ShowAddFacultyPage());
        commands.put(ADD_NEW_FACULTY, new AddNewFacultyCommand());
        commands.put(FIND_CITIES_BY_COUNTRY_ID, new FindCitiesByCountryCommand());
        commands.put(LOAD_FILE, new LoadFile());
        commands.put(LOAD_FACULTY_IMAGE, new LoadImageFaculty());
        commands.put(CHANGE_ALL_ENROLLEE_STATUS, new ChangeAllEnrolleeStatus());
        commands.put(CHANGE_ENROLLEE_STATUS, new ChangeEnrolleeStatus());
        commands.put(CHANGE_AVATAR, new ChangeAvatarCommand());

    }

     ActionCommand getCommand(String commandName) {
        return commands.get(CommandEnum.valueOf(commandName));
    }

}