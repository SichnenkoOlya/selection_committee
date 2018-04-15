package by.sichnenko.committee.constant;

public class SQLQueryConstant {

    public static final String UPDATE_USER = "UPDATE user SET login=?, hash_password=?, role=?, email=? WHERE id=?";
    public static final String UPDATE_USER_ROLE = "UPDATE user SET role=? WHERE id=?";
    public static final String UPDATE_USER_LOCK = "UPDATE user SET isLocked=? WHERE id=?";
    public static final String CREATE_USER = "INSERT INTO user(login, hash_password, role, email) VALUES  (?, ?, ?, ?)";
    public static final String SELECT_USER_BY_LOGIN = "SELECT id, login, hash_password, role, email FROM user WHERE login=?";
    public static final String SELECT_ALL_USERS = "SELECT id, login, hash_password, role, email FROM user";

    public static final String CREATE_ENROLLEE = "INSERT INTO enrollee (name, surname, patronymic, phone_number, faculty_id," +
            "status_id, user_id, city_id, number_passport, average_certificate_score,score_on_ct) VALUES  (?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
    public static final String SELECT_ALL_ENROLLEES = "SELECT ";
    public static final String UPDATE_ENROLLEE = "UPDATE enrollee SET name=?, surname=?, patronymic=?," +
            " phone_namber=?, faculty_id=?, status_id=?, user_id=?, city_id=? WHERE id=?";


    public static final String UPDATE_FACULTY = "UPDATE enrollee SET name=?, surname=?, patronymic=?," +
            " phone_namber=?, faculty_id=?, status_id=?, user_id=?, city_id=? WHERE id=?";

    public static final String CREATE_FACULTY = "UPDATE enrollee SET name=?, surname=?, patronymic=?," +
            " phone_namber=?, faculty_id=?, status_id=?, user_id=?, city_id=? WHERE id=?";

    public static final String DELETE_FACULTY = "UPDATE enrollee SET name=?, surname=?, patronymic=?," +
            " phone_namber=?, faculty_id=?, status_id=?, user_id=?, city_id=? WHERE id=?";

    public static final String SELECT_ALL_COUNTRIES = "SELECT id, name FROM country";
    public static final String SELECT_ALL_CITIES = "SELECT id, name, country_id FROM city";

    public static final String SELECT_ALL_FACULTIES = "SELECT id, name FROM faculty";

    public static final String SELECT_ALL_PRIVILEGES = "SELECT id, name FROM privilege";
    public static final String SELECT_ALL_SUBJECTS = "SELECT id, name FROM subject";

    public static final String SELECT_CITY_BY_NAME = "SELECT id, name, countryId FROM city WHERE city.name=?";
}
