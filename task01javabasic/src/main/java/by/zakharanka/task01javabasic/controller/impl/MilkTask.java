package by.zakharanka.task01javabasic.controller.impl;

import by.zakharanka.task01javabasic.controller.Command;
import by.zakharanka.task01javabasic.entity.Data;
import by.zakharanka.task01javabasic.service.ExpressionService;
import by.zakharanka.task01javabasic.view.InputData;

public class MilkTask implements Command {

    @Override
    public Double exec(Data newData) {
        Data<Double> data = new Data<>();
        InputData inputData = new InputData();
        data.push(inputData.input());
        data.push(inputData.input());
        ExpressionService expression = new ExpressionService();
        return expression.milkTask(data);
    }
}
