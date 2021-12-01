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

    /**
     * used in {@code CheckMinSquareImpl} class
     * before calling this method the numbers are checked for equality
     * @param num1 a number to compare
     * @param num2 a number to compare
     * @return the smallest square of two numbers
     */
    public double minSquare(double num1, double num2){
        LOGGER.info("minSquare Run");
        double squareNum1 = num1 * num1;
        double squareNum2 = num2 * num2;
        return Math.min(squareNum1, squareNum2);
    }

    /**
     * used in {@code DivisorCheckImpl} class
     * before calling this method the divisor are checked for inequality to zero (divisor != 0)
     * @param numbers numbers for which the divisor is checked
     * @param divisor divisor
     * @return data that stores boolean values to determine the result
     */
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

    /**
     * the next check of numbers for a positive sum is carried out
     * if at least two numbers add up to a positive number, the method returns true
     * @param num1 number for calculation
     * @param num2 number for calculation
     * @param num3 number for calculation
     * @return {@code boolean} result value
     */
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

    /**
     * a cycle from 1000 to 9999 is performed, where each number is checked by the
     * {@code sumDigits} method for equality of 15 sum of digits
     * @return {@code Data} object with numbers whose sum of digits is 15
     */
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

    /**
     * swap two number using third variable
     * @param arr includes two number to swapping
     */
    public void swapThirdVariable(int[] arr){
        LOGGER.info("swapThirdVariable Run");
        int temp;
        temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
    }

    /**
     * swap two number using arithmetic operations
     * @param arr includes two number to swapping
     */
    public void swapArithmeticOperations(int[] arr){
        LOGGER.info("swapArithmeticOperations Run");
        arr[0] = arr[0] + arr[1];
        arr[1] = arr[0] - arr[1];
        arr[0] = arr[0] - arr[1];
    }

    /**
     * swap two number using XOR operation
     * @param arr includes two number to swapping
     */
    public void swapXOR(int[] arr){
        LOGGER.info("swapXOR Run");
        arr[0] = arr[0]^arr[1];
        arr[1] = arr[0]^arr[1];
        arr[0] = arr[0]^arr[1];
    }

}
