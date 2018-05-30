package by.sichnenko.committee.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.sichnenko.committee.constant.PatternConstant.NAME_REGEX;
import static by.sichnenko.committee.constant.PatternConstant.PASSPORT_REGEX;
import static by.sichnenko.committee.constant.PatternConstant.PHONE_REGEX;

public class EnrolleeValidator {
    private static int MAX_VALUE = 100; //The max value by 100 point system
    private static int MIN_VALUE = 0;

    /**
     * Check that param email is correct phone
     *
     * @param phone string check for valid phone
     * @return true if string is correct phone, else return false
     */
    public static boolean validatePhoneNumber(String phone) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    /**
     * Check that param name is correct name
     *
     * @param name string check for valid name
     * @return true if string is correct name, else return false
     */
    public static boolean validateName(String name) {
        Pattern p = Pattern.compile(NAME_REGEX);
        Matcher m = p.matcher(name);
        return m.matches();
    }

    /**
     * Check that param passportNumber is correct passport mumber
     *
     * @param passportNumber string check for valid passport number
     * @return true if string is correct passport number, else return false
     */
    public static boolean validatePassportNumber(String passportNumber) {
        Pattern p = Pattern.compile(PASSPORT_REGEX);
        Matcher m = p.matcher(passportNumber);
        return m.matches();
    }

    /**
     * Check that param score is correct score
     *
     * @param score number check for valid score
     * @return true if string is correct score, else return false
     */
    public static boolean validateCertificateScore(int score) {
        return score >= MIN_VALUE && score <= MAX_VALUE;
    }

    /**
     * Check that param score is correct score
     *
     * @param score         number check for valid score
     * @param countSubjects count subject that enrollee passed ct exam
     * @return true if string is correct score, else return false
     */
    public static boolean validateScoreOnCT(int score, int countSubjects) {
        int sumMaxValue = countSubjects * MAX_VALUE;
        final int MIN_SUBJECT_COUNT = 1;
        return countSubjects >= MIN_SUBJECT_COUNT && score <= sumMaxValue && score >= MIN_VALUE;
    }
}
