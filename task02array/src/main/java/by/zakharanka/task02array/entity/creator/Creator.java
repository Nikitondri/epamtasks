package by.zakharanka.task02array.entity.creator;

import by.zakharanka.task02array.exception.MatrixException;

public interface Creator<T> {

    void createFromFile(T object, String path);

    void createFromKeyboard(T object);

    void createRandom(T object, int maxValue, int minValue) throws MatrixException;
}
