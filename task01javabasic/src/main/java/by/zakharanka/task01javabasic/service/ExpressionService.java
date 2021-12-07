package by.zakharanka.task01javabasic.service;


import by.zakharanka.task01javabasic.entity.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExpressionService {

    static final Logger LOGGER = LogManager.getLogger(ExpressionService.class.getName());

    public double expressionTask8(double a, double b, double c){
        LOGGER.trace("expressionTask8 run");
        return ((b + Math.sqrt((b * b) + 4 * a * c)) / (2 * a)) - (a * a * a * c) + (1 / (b * b));
    }

    public double milkTask(int n, int m){
        LOGGER.trace("milkTask run");
        return ((80 / (double)n) + 12) * m;
    }


    private double function(double x, double c){
        return x == 15 ? (x + c) * 2 : (x - c) + 6;
    }

    public Data<Double> functionRange(double begin, double end, double num, double step){
        LOGGER.trace("functionRange run");
        Data<Double> data = new Data<>();
        for(double x = begin; x <= end; x += step){
            data.push(function(x, num));
        }
        return data;
    }

    public double sumRowMembers(double eps){
        LOGGER.trace("sumRowMembers run");
        double member = 0.25;
        double res = 0;
        double n = 2;
        while(member >= eps){
            res += member;
            member = 1 / ((3 * n - 2) * (3 * n +1));
            n += 1;
        }
        return res;
    }
}
