package by.zakharenko.task04oop.service.observer;

import by.zakharenko.task04oop.service.exception.ServiceException;

import java.util.EventObject;

public interface Observer<T extends EventObject> {
    void update(T t) throws ServiceException;
}
