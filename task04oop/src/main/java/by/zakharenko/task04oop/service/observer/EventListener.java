package by.zakharenko.task04oop.service.observer;

import java.util.EventObject;

public interface EventListener<T> {
    void update(T t);
}
