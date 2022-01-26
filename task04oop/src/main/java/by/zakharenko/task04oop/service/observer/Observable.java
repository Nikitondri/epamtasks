package by.zakharenko.task04oop.service.observer;

import java.util.EventObject;

public interface Observable<T extends EventObject> {
    void subscribe(Observer<T> observer);
    void unsubscribe(Observer<T> observer);
    void notifyObservers();
}
