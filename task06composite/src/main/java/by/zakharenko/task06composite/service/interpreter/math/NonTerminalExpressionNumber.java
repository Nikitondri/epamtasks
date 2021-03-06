package by.zakharenko.task06composite.service.interpreter.math;

public class NonTerminalExpressionNumber implements AbstractMathExpression {
    private final int number;

    public NonTerminalExpressionNumber(int number) {
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.pushValue(number);
    }
}
