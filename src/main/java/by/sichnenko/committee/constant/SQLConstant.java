package by.sichnenko.committee.constant;

public class SQLConstant {
    public static final String UPDATE_USER = "UPDATE user SET login=?, hash_password=?, role=?, email=? WHERE id=?";
    public static final String CREATE_USER = "INSERT INTO user(login, hash_password, role, email) VALUES  (?, ?, ?, ?)";
    public static final String SELECT_USER_BY_LOGIN = "SELECT id, login, hash_password, role, email FROM user WHERE login=\"%s\"";

}
