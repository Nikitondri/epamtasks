package by.zakharenko.task06composite.service.interpreter;

public interface AbstractExpression<T> {
    void interpret(T context);
}
