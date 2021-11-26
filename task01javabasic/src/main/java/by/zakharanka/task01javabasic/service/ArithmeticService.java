package by.zakharanka.task01javabasic.service;

import by.zakharanka.task01javabasic.entity.Data;

public class ArithmeticService {

    public boolean compareNumbers(double num1, double num2){
        return num1 == num2;
    }

    public double checkMaxNumber(double num1, double num2){
        return Math.max(num1, num2);
    }

    public double minSquare(double num1, double num2){
        double squareNum1 = num1 * num1;
        double squareNum2 = num2 * num2;
        return Math.min(squareNum1, squareNum2);
    }

    public Data<Boolean> checkDivisor(Data<Integer> numbers, int divisor){
        Data<Boolean> data = new Data<>();
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.getData(i) % divisor == 0){
                data.push(true);
            } else{
                data.push(false);
            }
        }
        return data;
    }

    public boolean isPositiveSum(double num1, double num2, double num3){
        if(num1 + num2 > 0){
            return true;
        } else if(num1 + num3 > 0){
            return true;
        } else return num2 + num3 > 0;
    }

    public double difference(double num1, double num2){
        return Math.abs(num1 - num2);
    }

    public int rowNumbers(int num){
        int res = 0;
        for(int i = 0; i <= num; i++){
            res += i;
        }
        return res;
    }

}
