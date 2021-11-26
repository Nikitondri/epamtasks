package by.zakharanka.task01javabasic.controller.taskimpl;

import by.zakharanka.task01javabasic.entity.Data;
import by.zakharanka.task01javabasic.service.NumbersService;
import by.zakharanka.task01javabasic.view.InputData;
import by.zakharanka.task01javabasic.view.OutputData;

//8. Составить программу нахождения наименьшего из квадратов двух чисел а и b

public class CheckMinSquareImpl implements Command{

    private static final String INPUT_NUM1 = "Введите первое число: ";
    private static final String INPUT_NUM2 = "Введите второе число: ";
    private static final String TEXT_TASK = "Определение наименьшего квадрата двух чисел\n";
    public static final double MAX_NUMBER = 1.3407807929942596E154;

    @Override
    public String exec() {
        Data<Double> data = new Data<>();
        InputData inputData = new InputData();
        OutputData outputData = new OutputData();
        outputData.output(TEXT_TASK);

//        input data
        outputData.output(INPUT_NUM1);
        data.push(inputData.inputDoubleRange(-MAX_NUMBER, MAX_NUMBER));
        outputData.output(INPUT_NUM2);
        data.push(inputData.inputDoubleRange(-MAX_NUMBER, MAX_NUMBER));

        NumbersService numbersService = new NumbersService();
        if (numbersService.compareNumbers(data.getData(0), data.getData(1))) {
            return "Квадраты чисел равны";
        } else {
            return "Наименьший квадрат: " + numbersService.minSquare(data.getData(0), data.getData(1));
        }
    }
}
