package by.zakharanka.task01javabasic.service;


import by.zakharanka.task01javabasic.entity.Data;

public class ExpressionService {

    public double expressionTask8(double a, double b, double c){
        return ((b + Math.sqrt((b * b) + 4 * a * c)) / (2 * a)) - (a * a * a * c) + (1 / (b * b));
    }

    public double milkTask(int n, int m){
        return ((80 / (double)n) + 12) * m;
    }


    private double function(double x, double c){
        return x == 15 ? (x + c) * 2 : (x - c) + 6;
    }

    public Data<Double> functionRange(double begin, double end, double num, double step){
        Data<Double> data = new Data<>();
        for(double x = begin; x <= end; x += step){
            data.push(function(x, num));
        }
        return data;
    }
}
