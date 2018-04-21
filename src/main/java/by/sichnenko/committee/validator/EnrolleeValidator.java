package by.sichnenko.committee.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.sichnenko.committee.constant.PatternConstant.NAME_REGEX;

public class EnrolleeValidator {
    public static boolean validateName(String name) {
        Pattern p = Pattern.compile(NAME_REGEX);
        Matcher m = p.matcher(name);
        return m.matches();
    }
}
