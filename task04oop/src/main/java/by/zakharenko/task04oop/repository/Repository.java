package by.zakharenko.task04oop.repository;

import by.zakharenko.task04oop.dal.exception.DAOException;
import by.zakharenko.task04oop.repository.specification.Specification;

import java.util.Comparator;
import java.util.List;

public interface Repository<T> {
    void add(T t);
    List<T> findBySpecification(Specification<T> specification);
    List<T> sortByComparator(Comparator<T> comparator);
    void update(T oldT, T newT) throws DAOException;
    void remove(long id);
}
