package by.zakharenko.task04oop.service;

import java.util.List;

public interface RepositoryService<T> {
    long add(T t);
    List<Long> addList(List<T> list);
    void remove(long id);
    void set(long id, T t);
}
