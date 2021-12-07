package by.zakharanka.task01javabasic.controller.taskscommand.cycleimpl;

import by.zakharanka.task01javabasic.controller.taskscommand.Command;
import by.zakharanka.task01javabasic.entity.Data;
import by.zakharanka.task01javabasic.service.ExpressionService;
import by.zakharanka.task01javabasic.view.InputData;
import by.zakharanka.task01javabasic.view.OutputData;

//8. Вычислить значения функции на отрезке [а,b] c шагом h:
//y = (x + c) * 2, x == 15 || (x - c) + 6, x != 15

/**
 * The class for completing the task 8 "cycle"
 */
public class FunctionRangeImpl implements Command {

    private static final String INPUT_BEGIN = "Введите начало отрезка: ";
    private static final String INPUT_END = "Введите конец отрезка: ";
    private static final String INPUT_C = "Введите число C: ";
    private static final String INPUT_STEP = "Введите шаг: ";
    private static final String TEXT_TASK = "Вычислить значения функции на отрезке [а,b] c шагом h:\n";

    private String formationResult(Data<Double> data){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < data.size(); i++){
            result.append(data.getData(i)).append(" ");
        }
        return result.toString();
    }

    /**
     * The method uses {@code ExpressionService} class to perform the task
     * uses {@code formationResult} method to perform a string with the result
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
        outputData.output(INPUT_BEGIN);
        data.push(inputData.inputDouble());
        outputData.output(INPUT_END);
        data.push(inputData.inputDouble());
        outputData.output(INPUT_C);
        data.push(inputData.inputDouble());
        outputData.output(INPUT_STEP);
        data.push(inputData.inputDouble());


        ExpressionService expressionService = new ExpressionService();
        return "Ответ: " + formationResult(expressionService.functionRange(data.getData(0), data.getData(1), data.getData(2), data.getData(3)));
    }

}
