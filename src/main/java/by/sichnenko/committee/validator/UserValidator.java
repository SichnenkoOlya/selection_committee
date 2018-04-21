package by.sichnenko.committee.validator;

import by.sichnenko.committee.model.RoleType;
import by.sichnenko.committee.model.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.sichnenko.committee.constant.PatternConstant.EMAIL_REGEX;
import static by.sichnenko.committee.constant.PatternConstant.NAME_REGEX;

public class UserValidator {

    public static boolean isAdmin(User user) {
        return user.getRole() == RoleType.ADMIN;
    }

    public static boolean validateEmail(String email) {
        Pattern p = Pattern.compile(EMAIL_REGEX);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public static boolean validateName(String name) {
        Pattern p = Pattern.compile(NAME_REGEX);
        Matcher m = p.matcher(name);
        return m.matches();
    }

    public static boolean validateLogin(String name) {
        return true;
    }

    public static boolean validatePassword(String name) {
        return true;
    }

    public static boolean validatePhoneNumber(String phone) {
        return true;
    }
}
