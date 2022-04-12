package by.zakharenko.cafe.service.validator;

public interface Validator<T> {
    boolean isValid(T object);
}
