package by.sichnenko.committee.constant;

public class SQLQueryConstant {
    public static final String UPDATE_USER = "UPDATE user SET login=?, hash_password=?, role=?, email=? WHERE id=?";
    public static final String UPDATE_USER_ROLE = "UPDATE user SET role=? WHERE id=?";
    public static final String UPDATE_USER_LOCK = "UPDATE user SET isLocked=? WHERE id=?";
    public static final String CREATE_USER = "INSERT INTO user(login, hash_password, role, email) VALUES  (?, ?, ?, ?)";
    public static final String SELECT_USER_BY_LOGIN = "SELECT id, login, hash_password, role, email FROM user WHERE login=?";
    public static final String SELECT_ALL_USERS= "SELECT id, login, hash_password, role, email FROM user";
    public static final String CREATE_ENROLLEE = "INSERT INTO enrollee (name, surname, patronymic, phone_namber, faculty_id," +
            "status_id, user_id, city_id) VALUES  (?, ?, ?, ?, ?, ?, ?, ?)";

}
