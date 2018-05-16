package by.sichnenko.committee.command;

import by.sichnenko.committee.command.impl.*;
import by.sichnenko.committee.command.impl.enrollee.*;
import by.sichnenko.committee.command.impl.faculty.*;
import by.sichnenko.committee.command.impl.user.*;

import java.util.EnumMap;

import static by.sichnenko.committee.command.CommandEnum.*;

public class CommandProvider {
    private static EnumMap<CommandEnum, ActionCommand> commands = new EnumMap<>(CommandEnum.class);

    CommandProvider() {
        commands.put(EMAIL_SEND, new SendEmail());
        commands.put(MAIN, new ShowMainPageCommand());
        commands.put(SIGN_IN, new SignInCommand());
        commands.put(SIGN_UP, new SignUpCommand());
        commands.put(SIGN_OUT, new SignOutCommand());
        commands.put(FILL_ENROLLEE, new FillEnrolleeCommand());
        commands.put(CHANGE_LOCALE, new ChangeLocaleCommand());
        commands.put(SHOW_ENROLLEE_FILL_PAGE, new ShowEnrolleeFillPage());
        commands.put(SHOW_ALL_USERS, new ShowAllUsersCommand());
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
        commands.put(LOAD_FACULTY_IMAGE, new LoadImageFacultyCommand());
        commands.put(CHANGE_ALL_ENROLLEE_STATUS, new ChangeAllEnrolleeStatusCommand());
        commands.put(CHANGE_ENROLLEE_STATUS, new ChangeEnrolleeStatusCommand());
        commands.put(CHANGE_AVATAR, new ChangeAvatarCommand());
        commands.put(EDIT_USER_PROFILE, new EditUserProfileCommand());
        commands.put(ADD_COUNTRY, new AddCountryCommand());
        commands.put(ADD_CITY, new AddCityCommand());
        commands.put(SHOW_ENROLLEES_BUDJET, new ShowEnrolleesBudjetCommand());
        commands.put(SHOW_ENROLLEES_PAID, new ShowEnrollesPaidCommand());
        commands.put(ENROLL_TO_FACULTY, new EnrollCommand());
        commands.put(EDIT_ENROLLEE, new EditEnrolleeCommand());
        commands.put(SHOW_SIGN_IN_PAGE, new ShowSignInPageCommand());
        commands.put(SHOW_SIGN_UP_PAGE, new ShowSignUpPageCommand());
        commands.put(SHOW_MY_PROFILE_PAGE, new ShowMyProfilePageCommand());
        commands.put(SHOW_ADD_CITY_PAGE, new ShowAddCityPageCommand());
        commands.put(SHOW_ADD_COUNTRY_PAGE, new ShowAddCountryPageCommand());
        commands.put(SHOW_EDIT_PROFILE_PAGE, new ShowEditProfilePageCommand());

        commands.put(FIND_SUBJECTS_BY_FACULTY, new FindSubjectsByFacultyCommand());
    }

     ActionCommand getCommand(String commandName) {
        return commands.get(CommandEnum.valueOf(commandName));
    }

}