package by.sichnenko.committee.repository;

public interface Specification<T> {
    String toSqlQuery();
}