package by.zakharanka.task02array.service.creator;

import by.zakharanka.task02array.entity.exception.EntityException;

public interface Creator<T> {

    void createFromFile(T object, String path);

    void createFromString(T object);

    void createRandom(T object, int maxValue, int minValue) throws EntityException;

}
