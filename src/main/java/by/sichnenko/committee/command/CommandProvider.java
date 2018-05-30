package by.sichnenko.committee.command;

import by.sichnenko.committee.command.impl.admin.*;
import by.sichnenko.committee.command.impl.common.*;
import by.sichnenko.committee.command.impl.user.*;

import java.util.EnumMap;

import static by.sichnenko.committee.command.CommandEnum.*;

public class CommandProvider {
    private static EnumMap<CommandEnum, ActionCommand> commands = new EnumMap<>(CommandEnum.class);

    CommandProvider() {
        commands.put(ADD_CITY, new AddCityCommand());
        commands.put(ADD_COUNTRY, new AddCountryCommand());
        commands.put(ADD_NEW_FACULTY, new AddNewFacultyCommand());

        commands.put(CHANGE_AVATAR, new ChangeAvatarCommand());
        commands.put(CHANGE_ENROLLEE_STATUS, new ChangeEnrolleeStatusCommand());
        commands.put(CHANGE_LOCALE, new ChangeLocaleCommand());
        commands.put(CHANGE_PASSWORD, new ChangePasswordCommand());
        commands.put(CHANGE_USER_LOCK, new ChangeUserLockCommand());
        commands.put(CHANGE_USER_ROLE, new ChangeUserRoleCommand());

        commands.put(EDIT_ENROLLEE, new EditEnrolleeCommand());
        commands.put(EDIT_USER_PROFILE, new EditUserProfileCommand());
        commands.put(ENROLL_TO_FACULTY, new EnrollCommand());

        commands.put(FILL_ENROLLEE, new FillEnrolleeCommand());
        commands.put(FIND_CITIES_BY_COUNTRY_ID, new FindCitiesByCountryCommand());
        commands.put(FIND_SUBJECTS_BY_FACULTY, new FindSubjectsByFacultyCommand());

        commands.put(LOAD_FACULTY_IMAGE, new LoadImageFacultyCommand());

        commands.put(MAIN, new ShowMainPageCommand());

        commands.put(SIGN_IN, new SignInCommand());
        commands.put(SIGN_UP, new SignUpCommand());
        commands.put(SIGN_OUT, new SignOutCommand());

        commands.put(SHOW_ALL_USERS, new ShowAllUsersCommand());
        commands.put(SHOW_ADD_CITY_PAGE, new ShowAddCityPageCommand());
        commands.put(SHOW_ADD_COUNTRY_PAGE, new ShowAddCountryPageCommand());
        commands.put(SHOW_ADD_FACULTY_PAGE, new ShowAddFacultyPage());
        commands.put(SHOW_CHANGE_PASSWORD_PAGE, new ShowChangePasswordPageCommand());
        commands.put(SHOW_DETAIL_FACULTY, new ShowDetailFacultyCommand());
        commands.put(SHOW_DETAIL_USER, new ShowDetailUserPage());
        commands.put(SHOW_EDIT_PROFILE_PAGE, new ShowEditProfilePageCommand());
        commands.put(SHOW_ENROLLEE_FILL_PAGE, new ShowEnrolleeFillPageCommand());
        commands.put(SHOW_ENROLLEES_BUDJET, new ShowEnrolleesBudjetCommand());
        commands.put(SHOW_ENROLLEES_PAID, new ShowEnrollesPaidCommand());
        commands.put(SHOW_MY_PROFILE_PAGE, new ShowMyProfilePageCommand());
        commands.put(SHOW_SIGN_IN_PAGE, new ShowSignInPageCommand());
        commands.put(SHOW_SIGN_UP_PAGE, new ShowSignUpPageCommand());
        commands.put(SHOW_USERS_BY_STATUS, new ShowUsersWithStatus());
    }

    ActionCommand getCommand(String commandName) {
        return commands.get(CommandEnum.valueOf(commandName));
    }

}