package by.zakharanka.task01javabasic.controller.taskscommand.branchingimpl;

import by.zakharanka.task01javabasic.controller.taskscommand.Command;
import by.zakharanka.task01javabasic.entity.Data;
import by.zakharanka.task01javabasic.service.ArithmeticService;
import by.zakharanka.task01javabasic.view.InputData;
import by.zakharanka.task01javabasic.view.OutputData;

//32. Написать программу, которая по заданным трем числам определяет, является ли сумма каких-либо двух из них
//положительной.

/**
 * The class for completing the task 32 "branching"
 */
public class CheckPositiveSumImpl implements Command {

    private static final String INPUT_NUM1 = "Введите первое число: ";
    private static final String INPUT_NUM2 = "Введите второе число: ";
    private static final String INPUT_NUM3 = "Введите третье число: ";
    private static final String TEXT_TASK = "Является ли сумма каких-либо двух из трех чисел положительной\n";
    public static final double MAX_VALUE = 1.7976931348623157E308;

    /**
     * The method uses {@code ArithmeticService} class to perform the task
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
        outputData.output(INPUT_NUM1);
        data.push(inputData.inputDoubleRange(-MAX_VALUE, MAX_VALUE));
        outputData.output(INPUT_NUM2);
        data.push(inputData.inputDoubleRange(-MAX_VALUE, MAX_VALUE));
        outputData.output(INPUT_NUM3);
        data.push(inputData.inputDoubleRange(-MAX_VALUE, MAX_VALUE));

        ArithmeticService arithmeticService = new ArithmeticService();
        if(arithmeticService.isPositiveSum(data.getData(0), data.getData(1), data.getData(2)))
            return "Является";
        else
            return "Не является";
    }
}
