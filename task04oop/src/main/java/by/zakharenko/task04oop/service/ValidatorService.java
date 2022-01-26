package by.zakharenko.task04oop.service;

public interface ValidatorService<T> {
    boolean isCorrectLine(String line);
    boolean isCorrectObject(T object);
}
