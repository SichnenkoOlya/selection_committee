package by.sichnenko.committee.specification;

import java.sql.PreparedStatement;
import java.sql.SQLException;

//abstract class
public abstract class Specification {
    public abstract String toSqlQuery();
    public abstract void fillPreparedStatement(PreparedStatement preparedStatement) throws SQLException;
}