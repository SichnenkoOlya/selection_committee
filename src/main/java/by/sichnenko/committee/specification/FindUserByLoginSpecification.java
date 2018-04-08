package by.sichnenko.committee.specification;

import by.sichnenko.committee.specification.Specification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static by.sichnenko.committee.constant.SQLQueryConstant.SELECT_USER_BY_LOGIN;

 public class FindUserByLoginSpecification extends Specification {
    private String login;

    public FindUserByLoginSpecification(String login) {
        this.login = login;
    }

    public String toSqlQuery() {
        return SELECT_USER_BY_LOGIN;
    }

    public void fillPreparedStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, login);

    }

}
