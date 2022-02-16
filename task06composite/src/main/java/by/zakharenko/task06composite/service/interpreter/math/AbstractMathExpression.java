package by.zakharenko.task06composite.service.interpreter.math;

import by.zakharenko.task06composite.service.interpreter.AbstractExpression;

public interface AbstractMathExpression extends AbstractExpression<Context> {
    @Override
    void interpret(Context context);
}
