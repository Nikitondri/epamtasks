package by.zakharanka.task01javabasic.service;


public class ExpressionService {

    public double expressionTask8(double a, double b, double c){
        return ((b + Math.sqrt((b * b) + 4 * a * c)) / (2 * a)) - (a * a * a * c) + (1 / (b * b));
    }

    public double milkTask(int n, int m){
        return ((80 / (double)n) + 12) * m;
    }
}
