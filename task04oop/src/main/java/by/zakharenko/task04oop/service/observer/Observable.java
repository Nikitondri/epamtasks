package by.zakharenko.task04oop.service.observer;

import java.util.EventObject;

/**
 * interface for an object that describes the behaviors of adding, removing, and implementing actions on change
 * @param <T> class that inherits from {@code EventObject}
 */
public interface Observable<T extends EventObject> {
    void subscribe(Observer<T> observer);
    void unsubscribe(Observer<T> observer);
    void notifyObservers();
}
