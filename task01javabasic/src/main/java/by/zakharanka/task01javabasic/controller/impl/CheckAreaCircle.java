package by.zakharanka.task01javabasic.controller.impl;

import by.zakharanka.task01javabasic.controller.Command;
import by.zakharanka.task01javabasic.entity.Data;
import by.zakharanka.task01javabasic.service.GeometricService;
import by.zakharanka.task01javabasic.view.InputData;

public class CheckAreaCircle implements Command {

    @Override
    public Double exec(Data newData) {
        Data<Double> data = new Data<>();
        InputData inputData = new InputData();
        data.push(inputData.input());
        GeometricService expression = new GeometricService();
        return expression.findAreaСircle(data);
    }
}
