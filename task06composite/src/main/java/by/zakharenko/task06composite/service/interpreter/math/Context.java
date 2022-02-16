package by.zakharenko.task06composite.service.interpreter.math;

import java.util.ArrayDeque;

public class Context {
    private final ArrayDeque<Integer> contextValues = new ArrayDeque<>();
    public Integer popValue() {
        return contextValues.pop();
    }
    public void pushValue(Integer value) {
        this.contextValues.push(value);
    }
}
