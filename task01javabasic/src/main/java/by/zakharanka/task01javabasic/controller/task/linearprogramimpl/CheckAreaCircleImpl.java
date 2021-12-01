package by.zakharanka.task01javabasic.controller.task.linearprogramimpl;

import by.zakharanka.task01javabasic.controller.task.Command;
import by.zakharanka.task01javabasic.entity.Data;
import by.zakharanka.task01javabasic.service.GeometricService;
import by.zakharanka.task01javabasic.view.InputData;
import by.zakharanka.task01javabasic.view.OutputData;

//20. Известна длина окружности. Найти площадь круга, ограниченного этой окружностью.

/**
 * The class for completing the task 20 "linear program"
 */
public class CheckAreaCircleImpl implements Command {

    private static final String INPUT_LENGTH = "Введите длину окружности: ";
    private static final String TEXT_TASK = "Вычисление площади окружности через её длину\n";
    public static final double MAX_LENGTH = 4.752944159525654E154;

    /**
     * The method uses {@code GeometricService} class to perform the task
     * @see Command
     * @return String literal with the result
     */
    @Override
    public String exec() {
        Data<Double> data = new Data<>();
        InputData inputData = new InputData();
        OutputData outputData = new OutputData();
        outputData.output(TEXT_TASK);

//        input data
        outputData.output(INPUT_LENGTH);
        data.push(inputData.inputDoubleRange(0, MAX_LENGTH));

        GeometricService expression = new GeometricService();
        return "Площадь окружности: " + expression.findCircleArea(data.getData(0)) + "\n";
    }
}
