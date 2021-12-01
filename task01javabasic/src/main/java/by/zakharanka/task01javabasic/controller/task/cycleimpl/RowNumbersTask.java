package by.zakharanka.task01javabasic.controller.task.cycleimpl;

import by.zakharanka.task01javabasic.controller.task.Command;
import by.zakharanka.task01javabasic.entity.Data;
import by.zakharanka.task01javabasic.service.ArithmeticService;
import by.zakharanka.task01javabasic.view.InputData;
import by.zakharanka.task01javabasic.view.OutputData;

//6. Напишите программу, где пользователь вводит любое целое положительное число. А программа
//суммирует все числа от 1 до введенного пользователем числа.

/**
 * The class for completing the task 6 "cycle"
 */
public class RowNumbersTask implements Command {

    private static final String INPUT_NUM1 = "Введите целое положительное число: ";
    private static final String TEXT_TASK = "Сумма всех чисел от 1 до введенного числа\n";
    public static final int MAX_NUMBER = 65500; // res == 2145157750

    /**
     * The method uses {@code ArithmeticService} class to perform the task
     * @see Command
     * @return String literal with the result
     */
    @Override
    public String exec() {
        Data<Integer> data = new Data<>();
        InputData inputData = new InputData();
        OutputData outputData = new OutputData();
        outputData.output(TEXT_TASK);

//        input data
        outputData.output(INPUT_NUM1);
        data.push(inputData.inputIntRange(1, MAX_NUMBER));

        ArithmeticService arithmeticService = new ArithmeticService();
        return "Ответ: " + arithmeticService.rowNumbers(data.getData(0));
    }
}
