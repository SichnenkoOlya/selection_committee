package by.sichnenko.committee.constant;

public class PatternConstant {
    public static final String NAME_REGEX = "^([A-Z][a-z]{1,25})|([А-Я][а-я]{1,25})$";
    public static final String LOGIN_REGEX = "^(?:[a-zA-Z][a-zA-Z0-9\\_]{1,22}[a-zA-Z])$";
    public static final String EMAIL_REGEX = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    public static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}$";
    public static final String PHONE_REGEX = "^(?:\\+|\\d)[\\d]{9,13}\\d$";
    public static final String PASSPORT_REGEX = "^[A-Z]{2}\\d{7,8}$";
    public static final String DATE_REGEX = "yyyy-MM-dd";
}
