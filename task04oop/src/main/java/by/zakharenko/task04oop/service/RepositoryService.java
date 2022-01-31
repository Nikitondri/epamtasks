package by.zakharenko.task04oop.service;

import by.zakharenko.task04oop.service.exception.ServiceException;

import java.util.List;

public interface RepositoryService<T> {
    long add(T t) throws ServiceException;
    List<Long> addList(List<T> list) throws ServiceException;
    boolean remove(long id);
    void set(long id, T t) throws ServiceException;
}
