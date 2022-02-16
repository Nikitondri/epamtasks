package by.zakharenko.task06composite.service.interpreter.math.terminal;

import by.zakharenko.task06composite.service.interpreter.math.AbstractMathExpression;
import by.zakharenko.task06composite.service.interpreter.math.Context;

public class TerminalExpressionNot implements AbstractMathExpression {
    @Override
    public void interpret(Context context) {
        context.pushValue(~context.popValue());
    }
}
