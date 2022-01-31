package by.zakharenko.task04oop.repository;

import by.zakharenko.task04oop.repository.exception.RepositoryException;
import by.zakharenko.task04oop.repository.specification.Specification;

import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;

/**
 * an interface that uses repository classes that store and manipulate information
 * @param <T> class objects are stored in the repository
 */
public interface Repository<T> {
    void add(T t);
    T get(long id);
    SortedSet<Long> getSetId();
    List<T> findBySpecification(Specification<T> specification);
    List<T> sortByComparator(Comparator<T> comparator);
    void update(long id, T newT) throws RepositoryException;
    boolean remove(long id);
    int findSize();
}
