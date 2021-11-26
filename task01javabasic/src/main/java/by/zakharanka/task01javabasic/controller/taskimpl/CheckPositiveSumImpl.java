package by.zakharanka.task01javabasic.controller.taskimpl;

import by.zakharanka.task01javabasic.entity.Data;
import by.zakharanka.task01javabasic.service.NumbersService;
import by.zakharanka.task01javabasic.view.InputData;
import by.zakharanka.task01javabasic.view.OutputData;

//32. Написать программу, которая по заданным трем числам определяет, является ли сумма каких-либо двух из них
//положительной.

public class CheckPositiveSumImpl implements Command{

    private static final String INPUT_NUM1 = "Введите первое число: ";
    private static final String INPUT_NUM2 = "Введите второе число: ";
    private static final String INPUT_NUM3 = "Введите третье число: ";
    private static final String TEXT_TASK = "Является ли сумма каких-либо двух из трех чисел положительной\n";
    public static final double MAX_VALUE = 1.7976931348623157E308;

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

        NumbersService numbersService = new NumbersService();
        if(numbersService.isPositiveSum(data.getData(0), data.getData(1), data.getData(2)))
            return "Является";
        else
            return "Не является";
    }
}
