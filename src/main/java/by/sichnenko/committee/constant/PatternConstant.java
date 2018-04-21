package by.sichnenko.committee.constant;

public class PatternConstant {
    public static final String NAME_REGEX = "^([A-Z][a-z]{3,12})|([А-Я][а-я]{1,12})$";
    public static final String LOGIN_REGEX = "^(?=.{3,24})[a-z][a-z0-9]*[._-]?[a-z0-9]+$";
    public static final String EMAIL_REGEX = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    public static final String PASSWORD_REGEX = "^/(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}/g$";
    public static final String PHONE_REGEX = "^(?:\\+|\\d)[\\d\\- ]{9,}\\d$";
    //public static final String EMAIL_REGEX="[a-zA-Z]{1}[a-zA-Z\\d\\u002E\\u005F]+@([a-zA-Z]+\\u002E){1,2}((net)|(com)|(org))"
}
