package by.zakharenko.task04oop.service.observer;

import by.zakharenko.task04oop.service.exception.ServiceException;

import java.util.EventObject;

/**
 * An interface that describes the behavior of classes that perform actions
 * after they are called due to field changes in the class
 * @param <T> class that inherits from {@code EventObject}
 */
public interface Observer<T extends EventObject> {
    void update(T t) throws ServiceException;
}
