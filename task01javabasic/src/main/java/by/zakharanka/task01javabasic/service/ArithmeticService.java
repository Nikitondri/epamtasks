package by.zakharanka.task01javabasic.service;

import by.zakharanka.task01javabasic.entity.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArithmeticService {

    static final Logger LOGGER = LogManager.getLogger(ArithmeticService.class.getName());

    public boolean compareNumbers(double num1, double num2){
        LOGGER.info("compareNumbers Run");
        return num1 == num2;
    }

    public double checkMaxNumber(double num1, double num2){
        LOGGER.info("checkMaxNumber Run");
        return Math.max(num1, num2);
    }

    public double minSquare(double num1, double num2){
        LOGGER.info("minSquare Run");
        double squareNum1 = num1 * num1;
        double squareNum2 = num2 * num2;
        return Math.min(squareNum1, squareNum2);
    }

    public Data<Boolean> checkDivisor(Data<Integer> numbers, int divisor){
        LOGGER.info("checkDivisor Run");
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
        LOGGER.info("isPositiveSum Run");
        if(num1 + num2 > 0){
            return true;
        } else if(num1 + num3 > 0){
            return true;
        } else return num2 + num3 > 0;
    }

    public double difference(double num1, double num2){
        LOGGER.info("difference Run");
        return Math.abs(num1 - num2);
    }

    public int rowNumbers(int num){
        LOGGER.info("rowNumbers Run");
        int res = 0;
        for(int i = 0; i <= num; i++){
            res += i;
        }
        return res;
    }

    public int sumDigits(int num){
        int sum = 0;
        while(num != 0){
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }

    public Data<Integer> findCorrectNumber(){
        LOGGER.info("findCorrectNumber Run");
        Data<Integer> data = new Data<>();
        for(int i = 1000; i < 9999; i++){
            if(sumDigits(i) == 15){
                data.push(i);
            }
        }
        return data;
    }

}
