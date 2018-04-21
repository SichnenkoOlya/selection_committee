package by.sichnenko.committee.constant;

public class SQLQueryConstant {

    public static final String UPDATE_USER = "UPDATE user SET login=?, hash_password=?, role=?, email=? WHERE id=?";
    public static final String UPDATE_USER_AVATER = "UPDATE user SET image_path=? WHERE id=?";
    public static final String UPDATE_USER_ROLE = "UPDATE user SET role=? WHERE id=?";
    public static final String UPDATE_All_ENROLLEE_STATUS = "UPDATE enrollee SET enrollee.status_id=? WHERE enrollee.status_id=?";
    public static final String UPDATE_ENROLLEE_STATUS = "UPDATE enrollee SET enrollee.status_id=? WHERE enrollee.id=?";
    public static final String UPDATE_USER_LOCK = "UPDATE user SET isBlocked=? WHERE id=?";
    public static final String UPDATE_USER_PASSWORD= "UPDATE user SET hash_password=? WHERE id=?";
    public static final String CREATE_USER = "INSERT INTO user(login, hash_password, role, email) VALUES  (?, ?, ?, ?)";
    public static final String SELECT_USER_BY_LOGIN = "SELECT id, login, hash_password, role, email, isBlocked, image_path FROM user WHERE login=?";
    public static final String SELECT_ALL_USERS = "SELECT id, login, hash_password, role, email,isBlocked, image_path FROM user";
    public static final String SELECT_ALL_USERS_BY_STATUS = "SELECT user.id, user.login, user.hash_password, user.role, user.email, user.isBlocked FROM user " +
            "INNER JOIN enrollee ON enrollee.user_id=user.id WHERE enrollee.status_id=?";

    public static final String CREATE_ENROLLEE = "INSERT INTO enrollee (name, surname, patronymic, phone_number, faculty_id," +
            "status_id, user_id, city_id, number_passport, average_certificate_score,score_on_ct) VALUES  (?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
    public static final String SELECT_ALL_ENROLLEES = "SELECT ";
    public static final String SELECT_ENROLLEE_BY_USER_ID = "SELECT `id`,`name`,`surname`,`patronymic`,`phone_number`,`faculty_id`,`status_id`,`user_id`,`city_id`,`number_passport`,`average_certificate_score`,`score_on_ct` FROM `enrollee` WHERE enrollee.user_id=?";
    public static final String UPDATE_ENROLLEE = "UPDATE enrollee SET name=?, surname=?, patronymic=?," +
            " phone_namber=?, faculty_id=?, status_id=?, user_id=?, city_id=? WHERE id=?";


    public static final String UPDATE_FACULTY = "UPDATE enrollee SET name=?, surname=?, patronymic=?," +
            " phone_namber=?, faculty_id=?, status_id=?, user_id=?, city_id=?, image_path=?, description=? WHERE id=?";

    public static final String CREATE_FACULTY = "INSERT INTO faculty (name, budjet_count,total_count,description) VALUES (?,?,?,?)";

    public static final String DELETE_FACULTY = "UPDATE enrollee SET name=?, surname=?, patronymic=?," +
            " phone_namber=?, faculty_id=?, status_id=?, user_id=?, city_id=? WHERE id=?";

    public static final String SELECT_ALL_COUNTRIES = "SELECT id, name FROM country";
    public static final String SELECT_ALL_CITIES = "SELECT id, name, country_id FROM city";

    public static final String SELECT_ALL_FACULTIES = "SELECT id, name, image_path,description FROM faculty";
    public static final String UPDATE_FACULTY_IMAGE = "UPDATE faculty SET image_path=? WHERE id=?";
    public static final String SELECT_FACULTY_BY_ID = "SELECT id, name, image_path,description, budjet_count, total_count,passing_score_budjet,passing_score_paid FROM faculty WHERE id=?";
    public static final String SELECT_FACULTY_BY_NAME = "SELECT id, name, image_path,description, budjet_count, total_count,passing_score_budjet,passing_score_paid FROM faculty WHERE name=?";

    public static final String SELECT_ALL_PRIVILEGES = "SELECT id, name FROM privilege";
    public static final String SELECT_ALL_SUBJECTS = "SELECT id, name FROM subject";
    public static final String SELECT_SUBJECTS_FOR_FACULTY = "SELECT subject.id, subject.name FROM subject INNER JOIN faculty_has_subject " +
            "ON faculty_has_subject.subject_id=subject.id WHERE faculty_has_subject.faculty_id=?";

    public static final String INSERT_SUBJECTS_FOR_FACULTY = "INSERT INTO" +
            " faculty_has_subject (faculty_has_subject.subject_id, faculty_has_subject.faculty_id) VALUES (?,?)";

    public static final String SELECT_SUBJECT_BY_NAME = "SELECT subject.id, subject.name FROM subject" +
            "WHERE subject.name=? ";

    public static final String SELECT_CITY_BY_NAME = "SELECT id, name, countryId FROM city WHERE city.name=?";
    public static final String SELECT_CITY_BY_COUNTRY_ID= "SELECT city.id, city.name, city.country_id FROM city" +
            " INNER JOIN country ON country.id=city.country_id WHERE city.country_id=?";
}
