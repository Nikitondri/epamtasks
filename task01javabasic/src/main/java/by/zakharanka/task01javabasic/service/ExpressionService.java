package by.zakharanka.task01javabasic.service;

import by.zakharanka.task01javabasic.entity.Data;

public class ExpressionService {

    public double expressionTask8(Data<Double> data){
        double a = data.getData(0);
        double b = data.getData(1);
        double c = data.getData(2);
        return ((b + Math.sqrt((b * b) + 4 * a * c)) / (2 * a)) - (a * a * a * c) + (1 / b * b);
    }

    public double milkTask(Data<Double> data){
        double n = data.getData(0);
        double m = data.getData(1);
        return ((80 / n) + 12) * m;
    }
}
