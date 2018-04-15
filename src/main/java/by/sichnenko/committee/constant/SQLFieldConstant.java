package by.sichnenko.committee.constant;

public final class SQLFieldConstant {
    private SQLFieldConstant() {

    }

    public static final String ID = "id";
    public static final String NAME = "name";

    public final class User {
        public static final String ID = "id";
        public static final String LOGIN = "login";
        public static final String HASH_PASSWORD = "hash_password";
        public static final String EMAIL = "email";
        public static final String ROLE = "role";
    }

    public final class Enrollee {
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String SURNAME = "surname";
        public static final String PATRONYMIC = "patronymic";
        public static final String PHONE_NUMBER = "phone_number";
        public static final String FACULTY_ID = "faculty_id";
        public static final String STATUS_ID = "status_id";
        public static final String USER_ID = "user_id";
        public static final String CITY_ID = "city_id";
    }

    public final class City {
        public static final String COUNTRY_ID = "countryId";
    }
}


