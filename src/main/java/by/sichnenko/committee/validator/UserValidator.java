package by.sichnenko.committee.validator;

import by.sichnenko.committee.model.RoleType;
import by.sichnenko.committee.model.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.sichnenko.committee.constant.PatternConstant.*;

public class UserValidator {

    /**
     * Check that user has role = ADMIN
     *
     * @param user user
     * @return true if user has role = ADMIN, else return false
     * @see RoleType
     */
    public static boolean isAdmin(User user) {
        return user != null && user.getRole() == RoleType.ADMIN;
    }

    /**
     * Check that param email is correct email
     *
     * @param email string check for valid email
     * @return true if string is correct email, else return false
     */
    public static boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * Check that param login is correct login
     *
     * @param login string check for valid login
     * @return true if string is correct login, else return false
     */
    public static boolean validateLogin(String login) {
        Pattern pattern = Pattern.compile(LOGIN_REGEX);
        Matcher matcher = pattern.matcher(login);
        return matcher.matches();
    }

    /**
     * Check that param password is correct password
     *
     * @param password string check for valid password
     * @return true if string is correct password, else return false
     */
    public static boolean validatePassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

}
