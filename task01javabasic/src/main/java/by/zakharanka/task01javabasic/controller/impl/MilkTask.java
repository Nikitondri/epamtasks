package by.zakharanka.task01javabasic.controller.impl;

import by.zakharanka.task01javabasic.controller.Command;
import by.zakharanka.task01javabasic.entity.Data;
import by.zakharanka.task01javabasic.service.ExpressionService;
import by.zakharanka.task01javabasic.view.InputData;
import by.zakharanka.task01javabasic.view.OutputData;

//6. Написать код для решения задачи. В n малых бидонах 80 л молока. Сколько литров молока в m больших бидонах,
//если в каждом большом бидоне на 12 л. больше, чем в малом?


public class MilkTask implements Command {

    private static final String INPUT_N = "Введите число n: ";
    private static final String INPUT_M = "Введите число m: ";
    private static final String TEXT_TASK = "В n х бидонах 80 л молока. Сколько литров молока в m больших бидонах, \n" +
            "если в каждом большом бидоне на 12 л. больше, чем в малом?\n";

    @Override
    public String exec() {
        Data<Integer> data = new Data<>();
        InputData inputData = new InputData();
        OutputData outputData = new OutputData();

//      Input data
        outputData.output(TEXT_TASK);
        outputData.output(INPUT_N);
        data.push(inputData.inputInteger());
        outputData.output(INPUT_M);
        data.push(inputData.inputInteger());

        ExpressionService expression = new ExpressionService();
        return "Ответ: " + expression.milkTask(data.getData(0), data.getData(1)) + "\n";
    }
}
