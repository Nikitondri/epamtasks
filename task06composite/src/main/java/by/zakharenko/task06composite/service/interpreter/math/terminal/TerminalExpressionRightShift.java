package by.zakharenko.task06composite.service.interpreter.math.terminal;

import by.zakharenko.task06composite.service.interpreter.AbstractExpression;
import by.zakharenko.task06composite.service.interpreter.math.AbstractMathExpression;
import by.zakharenko.task06composite.service.interpreter.math.Context;

public class TerminalExpressionRightShift implements AbstractMathExpression {
    @Override
    public void interpret(Context context) {
        int num2 = context.popValue();
        int num1 = context.popValue();
        context.pushValue(num1 >> num2);
    }
}
