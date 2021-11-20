package by.zakharanka.task01javabasic.controller.impl;

import by.zakharanka.task01javabasic.controller.Command;
import by.zakharanka.task01javabasic.entity.Data;
import by.zakharanka.task01javabasic.service.ExpressionService;
import by.zakharanka.task01javabasic.view.InputData;
import by.zakharanka.task01javabasic.view.OutputData;

//8. Вычисление выражение ((b+sqrt(b^2+4ac))/2a)-(a^3)c+(b^-2)

public class ExpressionTask implements Command {

    private static final String INPUT_A = "Введите число a: ";
    private static final String INPUT_B = "Введите число b: ";
    private static final String INPUT_C = "Введите число c: ";
    private static final String TEXT_TASK = "Вычисление выражение ((b+sqrt(b^2+4ac))/2a)-(a^3)c+(b^-2)\n";

    @Override
    public String exec() {
        Data<Double> data = new Data<>();
        InputData inputData = new InputData();
        OutputData outputData = new OutputData();
        outputData.output(TEXT_TASK);

//        input data
        outputData.output(INPUT_A);
        data.push(inputData.inputDouble());
        outputData.output(INPUT_B);
        data.push(inputData.inputDouble());
        outputData.output(INPUT_C);
        data.push(inputData.inputDouble());

        ExpressionService expression = new ExpressionService();
        return "Ответ: " + expression.expressionTask8(data) + "\n";
    }
}
