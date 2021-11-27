package by.zakharanka.task01javabasic.controller.task.cycleimpl;

import by.zakharanka.task01javabasic.controller.task.Command;
import by.zakharanka.task01javabasic.entity.Data;
import by.zakharanka.task01javabasic.service.ExpressionService;
import by.zakharanka.task01javabasic.view.InputData;
import by.zakharanka.task01javabasic.view.OutputData;

//20. Даны числовой ряд и некоторое число е. Найти сумму тех членов ряда, модуль которых больше или
//равен заданному е. Общий член ряда имеет вид: member = 1 / ((3 * n - 2) * (3 * n +1))

public class SumRowMembersImpl implements Command {

    private static final String INPUT_EPS = "Введите EPS больше нуля: ";
    private static final String TEXT_TASK = "Сумма членов ряда больше EPS\n";

    @Override
    public String exec() {
        Data<Double> data = new Data<>();
        InputData inputData = new InputData();
        OutputData outputData = new OutputData();
        outputData.output(TEXT_TASK);

//        input data
        outputData.output(INPUT_EPS);
        data.push(inputData.inputDoubleRange(0, Double.MAX_VALUE));

        ExpressionService expressionService = new ExpressionService();
        if(data.getData(0) == 0)
            return "EPS должно быть больше нуля";
        else
            return "Ответ: " + expressionService.sumRowMembers(data.getData(0));
    }
}
