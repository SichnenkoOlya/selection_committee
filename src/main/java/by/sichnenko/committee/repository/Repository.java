package by.sichnenko.committee.repository;

import by.sichnenko.committee.exception.RepositoryException;
import by.sichnenko.committee.specification.Specification;

import java.util.List;

public interface Repository<T> {
    boolean add(T item) throws RepositoryException;

    void update(T item) throws RepositoryException;

    boolean remove(T item) throws RepositoryException;

    List<T> query(Specification specification) throws RepositoryException;
}