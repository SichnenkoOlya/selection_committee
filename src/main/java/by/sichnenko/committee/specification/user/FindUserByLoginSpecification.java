package by.sichnenko.committee.specification.user;

import by.sichnenko.committee.model.User;
import by.sichnenko.committee.repository.Specification;

import static by.sichnenko.committee.constant.SQLConstant.SELECT_USER_BY_LOGIN;


public class FindUserByLoginSpecification implements Specification<User> {
    private String login;

    public FindUserByLoginSpecification(String login) {
        this.login = login;
    }

    @Override
    public String toSqlQuery() {
        return String.format(SELECT_USER_BY_LOGIN, login);
    }
}
