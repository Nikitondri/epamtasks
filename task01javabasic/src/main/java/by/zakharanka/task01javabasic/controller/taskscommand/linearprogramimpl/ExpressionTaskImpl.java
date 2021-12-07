package by.zakharanka.task01javabasic.controller.taskscommand.linearprogramimpl;

import by.zakharanka.task01javabasic.controller.taskscommand.Command;
import by.zakharanka.task01javabasic.entity.Data;
import by.zakharanka.task01javabasic.service.ExpressionService;
import by.zakharanka.task01javabasic.view.InputData;
import by.zakharanka.task01javabasic.view.OutputData;

//8. Вычисление выражение ((b+sqrt(b^2+4ac))/2a)-(a^3)c+(b^-2)

/**
 * The class for completing the task 8 "linear program"
 */
public class ExpressionTaskImpl implements Command {

    private static final String INPUT_A = "Введите число a: ";
    private static final String INPUT_B = "Введите число b: ";
    private static final String INPUT_C = "Введите число c: ";
    private static final String TEXT_TASK = "Вычисление выражение ((b+sqrt(b^2+4ac))/2a)-(a^3)c+(b^-2)\n";
    private static final String INPUT_ERROR = "Ошибка ввода данных";

    /**
     * The method uses {@code ExpressionService} class to perform the task
     * A division by zero check is being performed
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
        outputData.output(INPUT_A);
        data.push(inputData.inputDouble());
        outputData.output(INPUT_B);
        data.push(inputData.inputDouble());
        outputData.output(INPUT_C);
        data.push(inputData.inputDouble());

        if(data.getData(0) == 0 || data.getData(1) == 0){
            return INPUT_ERROR;
        } else {
            ExpressionService expression = new ExpressionService();
            return "Ответ: " + expression.expressionTask8(data.getData(0), data.getData(1), data.getData(2)) + "\n";
        }
    }
}
