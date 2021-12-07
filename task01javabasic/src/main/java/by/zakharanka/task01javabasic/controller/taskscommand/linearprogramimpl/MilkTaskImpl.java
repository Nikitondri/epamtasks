package by.zakharanka.task01javabasic.controller.taskscommand.linearprogramimpl;

import by.zakharanka.task01javabasic.controller.taskscommand.Command;
import by.zakharanka.task01javabasic.entity.Data;
import by.zakharanka.task01javabasic.service.ExpressionService;
import by.zakharanka.task01javabasic.view.InputData;
import by.zakharanka.task01javabasic.view.OutputData;

//6. Написать код для решения задачи. В n малых бидонах 80 л молока. Сколько литров молока в m больших бидонах,
//если в каждом большом бидоне на 12 л. больше, чем в малом?

/**
 * The class for completing the task 6 "linear program"
 */
public class MilkTaskImpl implements Command {

    private static final String INPUT_N = "Введите число n: ";
    private static final String INPUT_M = "Введите число m: ";
    private static final String TEXT_TASK = "В n х бидонах 80 л молока. Сколько литров молока в m больших бидонах, \n" +
            "если в каждом большом бидоне на 12 л. больше, чем в малом?\n";
    public static final int MAX_VALUE = 23342213;

    /**
     * The method uses {@code ExpressionService} class to perform the task
     * @see Command
     * @return String literal with the result
     */
    @Override
    public String exec() {
        Data<Integer> data = new Data<>();
        InputData inputData = new InputData();
        OutputData outputData = new OutputData();

//      Input data
        outputData.output(TEXT_TASK);
        outputData.output(INPUT_N);
        data.push(inputData.inputIntRange(1, MAX_VALUE));
        outputData.output(INPUT_M);
        data.push(inputData.inputIntRange(1, MAX_VALUE));

        ExpressionService expression = new ExpressionService();
        return "Ответ: " + expression.milkTask(data.getData(0), data.getData(1)) + "\n";
    }
}
