package by.zakharanka.task01javabasic.controller.impl;

import by.zakharanka.task01javabasic.controller.Command;
import by.zakharanka.task01javabasic.entity.Data;
import by.zakharanka.task01javabasic.service.GeometricService;
import by.zakharanka.task01javabasic.view.InputData;
import by.zakharanka.task01javabasic.view.OutputData;

//20. Известна длина окружности. Найти площадь круга, ограниченного этой окружностью.

public class CheckAreaCircle implements Command {

    private static final String INPUT_LENGTH = "Введите длину окружности: ";
    private static final String TEXT_TASK = "Вычисление площади окружности через её длину\n";

    @Override
    public String exec() {
        Data<Double> data = new Data<>();
        InputData inputData = new InputData();
        OutputData outputData = new OutputData();
        outputData.output(TEXT_TASK);

//        input data
        outputData.output(INPUT_LENGTH);
        data.push(inputData.inputDoubleRange(0, Double.MAX_VALUE));

        GeometricService expression = new GeometricService();
        return "Площадь окружности: " + expression.findCircleArea(data.getData(0)) + "\n";
    }
}
