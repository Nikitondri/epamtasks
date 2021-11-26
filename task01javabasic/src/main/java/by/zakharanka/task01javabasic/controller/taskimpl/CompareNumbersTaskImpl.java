package by.zakharanka.task01javabasic.controller.taskimpl;

import by.zakharanka.task01javabasic.entity.Data;
import by.zakharanka.task01javabasic.service.NumbersService;
import by.zakharanka.task01javabasic.view.InputData;
import by.zakharanka.task01javabasic.view.OutputData;

//6. Составить программу: определения наибольшего из двух чисел а и b.

public class CompareNumbersTaskImpl implements Command {

    private static final String INPUT_NUM1 = "Введите первое число: ";
    private static final String INPUT_NUM2 = "Введите второе число: ";
    private static final String TEXT_TASK = "Определение наибольшего числа\n";

    @Override
    public String exec() {
        Data<Double> data = new Data<>();
        InputData inputData = new InputData();
        OutputData outputData = new OutputData();
        outputData.output(TEXT_TASK);

//        input data
        outputData.output(INPUT_NUM1);
        data.push(inputData.inputDouble());
        outputData.output(INPUT_NUM2);
        data.push(inputData.inputDouble());

        NumbersService numbersService = new NumbersService();
        if (numbersService.compareNumbers(data.getData(0), data.getData(1))) {
            return "Числа равны";
        } else {
            return "Наибольшее число: " + numbersService.checkMaxNumber(data.getData(0), data.getData(1));
        }
    }
}
