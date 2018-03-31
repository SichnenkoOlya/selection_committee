package by.sichnenko.committee.repository;

import by.sichnenko.committee.exception.RepositoryException;

import java.util.Comparator;
import java.util.List;

public interface Repository<T> {
    boolean add(T item) throws RepositoryException;

    void update(T item) throws RepositoryException;

    boolean remove(T item) throws RepositoryException;

    List<T> query(Specification<T> specification) throws RepositoryException;
}