package by.sichnenko.committee.constant;

public class SQLQueryConstant {
    public static final String SELECT_ENROLLE_ENTERED_ON_FACULTY = "SELECT enrollee.id, enrollee.surname, enrollee.name, enrollee.patronymic,enrollee.phone_number, enrollee.average_certificate_score , enrollee.score_on_ct, enrollee.user_id, enrollee.faculty_id FROM `enrollee` INNER JOIN faculty ON enrollee.faculty_id=faculty.id WHERE enrollee.faculty_id=? ORDER BY (enrollee.average_certificate_score + enrollee.score_on_ct) DESC LIMIT ?,?";
    public static final String SELECT_ENROLLE_NOT_ENTERED_ON_FACULTY = "SELECT enrollee.id, enrollee.surname, enrollee.name, enrollee.patronymic,enrollee.phone_number, enrollee.average_certificate_score , enrollee.score_on_ct, enrollee.user_id FROM `enrollee` INNER JOIN faculty ON enrollee.faculty_id=faculty.id WHERE enrollee.faculty_id=? AND enrollee.status_id!=2 AND enrollee.status_id!=3 AND enrollee.status_id!=1";

    public static final String UPDATE_USER = "UPDATE user SET login=?, hash_password=?, role=?, email=?, is_blocked=?, image_path=? WHERE id=?";
    public static final String UPDATE_USER_AVATER = "UPDATE user SET image_path=? WHERE id=?";
    public static final String UPDATE_USER_ROLE = "UPDATE user SET role=? WHERE id=?";
    public static final String UPDATE_All_ENROLLEE_STATUS = "UPDATE enrollee SET enrollee.status_id=? WHERE enrollee.status_id=?";
    public static final String UPDATE_ENROLLEE_STATUS = "UPDATE enrollee SET enrollee.status_id=?, enrollee.info_message=? WHERE enrollee.id=?";
    public static final String UPDATE_USER_LOCK = "UPDATE user SET is_blocked=? WHERE id=?";
    public static final String UPDATE_USER_PASSWORD = "UPDATE user SET hash_password=? WHERE id=?";
    public static final String CREATE_USER = "INSERT INTO user(login, hash_password, role, email) VALUES  (?, ?, ?, ?)";
    public static final String SELECT_USER_BY_LOGIN = "SELECT id, login, hash_password, role, email, is_blocked, image_path FROM user WHERE login=?";
    public static final String SELECT_ALL_USERS = "SELECT id, login, hash_password, role, email,is_blocked, image_path FROM user";
    public static final String SELECT_ALL_USERS_BY_STATUS = "SELECT user.id, user.login, user.hash_password, user.role, user.email, user.is_blocked, user.image_path FROM user " +
            "INNER JOIN enrollee ON enrollee.user_id=user.id WHERE enrollee.status_id=?";

    public static final String CREATE_ENROLLEE = "INSERT INTO enrollee (name, surname, patronymic, phone_number, faculty_id," +
            "status_id, user_id, city_id, number_passport, average_certificate_score,score_on_ct) VALUES  (?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
    public static final String SELECT_ALL_ENROLLEES = "SELECT ";
    public static final String SELECT_ENROLLEE_BY_USER_ID = "SELECT `id`,`name`,`surname`,`patronymic`,`phone_number`,`faculty_id`,`status_id`,`user_id`,`city_id`,`number_passport`,`average_certificate_score`,`score_on_ct`,`info_message` FROM `enrollee` WHERE enrollee.user_id=?";
    public static final String UPDATE_ENROLLEE = "UPDATE enrollee SET name=?, surname=?, patronymic=?," +
            " phone_number=?, faculty_id=?, status_id=?, user_id=?, city_id=?, number_passport=?, average_certificate_score=?,score_on_ct=?, info_message=? WHERE id=?";
    public static final String UPDATE_FACULTY_SCORE = "UPDATE faculty SET passing_score_budjet=?, passing_score_paid=? WHERE faculty.id=?";
    public static final String UPDATE_FACULTY_IS_FINISH = "UPDATE faculty SET is_finish=? WHERE faculty.id=?";

    public static final String UPDATE_FACULTY = "UPDATE faculty SET name=?, budjet_count=?, total_count=?," +
            " description=?, passing_score_budjet=?, passing_score_paid=?, image_path=? WHERE faculty.id=?";

    public static final String CREATE_FACULTY = "INSERT INTO faculty (name, budjet_count,total_count,description,finish_date) VALUES (?,?,?,?,?)";

    public static final String DELETE_FACULTY = "UPDATE enrollee SET name=?, surname=?, patronymic=?," +
            " phone_namber=?, faculty_id=?, status_id=?, user_id=?, city_id=? WHERE id=?";

    public static final String SELECT_ALL_COUNTRIES = "SELECT id, name FROM country";
    public static final String SELECT_COUNTRY_BY_NAME = "SELECT id, name FROM country WHERE name=?";
    public static final String SELECT_ALL_CITIES = "SELECT id, name, country_id FROM city";
    public static final String CREATE_CITY = "INSERT INTO city (name, country_id) VALUES (?,?)";
    public static final String CREATE_COUNTRY = "INSERT INTO country (name) VALUES (?)";

    public static final String SELECT_ALL_AVALIABLE_FACULTIES = "SELECT id, name, image_path,description, budjet_count, total_count,is_finish,finish_date FROM faculty WHERE is_finish=false AND finish_date>CURDATE()";
    public static final String SELECT_ALL_FACULTIES = "SELECT id, name, image_path,description, budjet_count, total_count,is_finish FROM faculty";
    public static final String UPDATE_FACULTY_IMAGE = "UPDATE faculty SET image_path=? WHERE id=?";
    public static final String SELECT_FACULTY_BY_ID = "SELECT id, name, image_path,description, budjet_count, total_count,passing_score_budjet,passing_score_paid,is_finish,finish_date FROM faculty WHERE id=?";
    public static final String SELECT_FACULTY_BY_NAME = "SELECT id, name, image_path,description, budjet_count, total_count,passing_score_budjet,passing_score_paid,is_finish,finish_date FROM faculty WHERE name=?";

    public static final String SELECT_ALL_PRIVILEGES = "SELECT id, name FROM privilege";
    public static final String SELECT_ALL_SUBJECTS = "SELECT id, name FROM subject";
    public static final String SELECT_SUBJECTS_FOR_FACULTY = "SELECT subject.id, subject.name, subject.group_number FROM subject INNER JOIN faculty_has_subject " +
            "ON faculty_has_subject.subject_id=subject.id WHERE faculty_has_subject.faculty_id=?";

    public static final String INSERT_SUBJECTS_FOR_FACULTY = "INSERT INTO" +
            " faculty_has_subject (faculty_has_subject.subject_id, faculty_has_subject.faculty_id) VALUES (?,?)";

    public static final String INSERT_SUBJECTS_FOR_ENROLLEE = "INSERT INTO" +
            " enrollee_has_subject (enrollee_has_subject.subject_id, enrollee_has_subject.enrollee_id) VALUES (?,?)";

    public static final String INSERT_PRIVILEGES_FOR_ENROLLEE = "INSERT INTO" +
            " enrollee_has_privilege (enrollee_has_privilege.privilege_id, enrollee_has_privilege.enrollee_id) VALUES (?,?)";


    public static final String SELECT_SUBJECTS_FOR_ENROLLEE = "SELECT enrollee_has_subject.subject_id FROM" +
            " enrollee_has_subject WHERE enrollee_has_subject.enrollee_id=?";

    public static final String DELETE_SUBJECTS_FOR_ENROLLEE = "DELETE FROM " +
            "enrollee_has_subject  WHERE enrollee_has_subject.enrollee_id=?";

    public static final String DELETE_PRIVILEGES_FOR_ENROLLEE = "DELETE FROM " +
            "enrollee_has_privilege  WHERE enrollee_has_privilege.enrollee_id=?";


    public static final String SELECT_SUBJECT_BY_NAME = "SELECT subject.id, subject.name FROM subject" +
            "WHERE subject.name=? ";

    public static final String SELECT_CITY_BY_NAME = "SELECT id, name, country_id FROM city WHERE city.name=?";
    public static final String SELECT_CITY_BY_COUNTRY_ID = "SELECT city.id, city.name, city.country_id FROM city" +
            " INNER JOIN country ON country.id=city.country_id WHERE city.country_id=?";
}
