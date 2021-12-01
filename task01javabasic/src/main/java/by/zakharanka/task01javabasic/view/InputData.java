package by.zakharanka.task01javabasic.view;

import by.zakharanka.task01javabasic.entity.time.Watch;
import by.zakharanka.task01javabasic.entity.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class InputData {

    static final Logger LOGGER = LogManager.getLogger(InputData.class.getName());

    private static final String ERROR_INPUT = "Ошибка ввода! Повторите попытку: ";
    private static final String LOGGER_ERROR = "Incorrect input";
    private static final String INPUT_HOUR = "Введите часы: ";
    private static final String INPUT_MIN = "Введите минуты: ";
    private static final String INPUT_SEC = "Введите секунды: ";
    private static final String INPUT_TIME = "Введите время\n";

    /**
     * starts a cycle until a correct double is entered
     * @see java.util.Scanner
     * @return correct double num
     */
    public double inputDouble(){
        Scanner scanner = new Scanner(System.in);
        double num = 0.0;
        boolean isCorrect;
        do{
            isCorrect = true;
            try{
                num = Double.parseDouble(scanner.nextLine());
            } catch(Exception e){
                OutputData outputData = new OutputData();
                outputData.output(ERROR_INPUT);
                isCorrect = false;
                LOGGER.error(LOGGER_ERROR);
            }
        } while(!isCorrect);
        return num;
    }

    /**
     * starts a cycle until a double number in the set interval is entered
     * @see java.util.Scanner
     * @return double num in the set interval
     */
    public double inputDoubleRange(final double min, final double max){
        boolean isCorrect = true;
        double num;
        do{
            num = inputDouble();
            if(num >= min && num <= max){
                isCorrect = false;
            } else{
                OutputData outputData = new OutputData();
                outputData.output(ERROR_INPUT);
            }
        } while(isCorrect);
        return num;
    }

    /**
     * starts a cycle until a correct integer is entered
     * @see java.util.Scanner
     * @return correct integer num
     */
    public int inputInteger(){
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        boolean isCorrect;
        do{
            isCorrect = true;
            try{
                num = Integer.parseInt(scanner.nextLine());
            } catch(Exception e){
                OutputData outputData = new OutputData();
                outputData.output(ERROR_INPUT);
                isCorrect = false;
                LOGGER.error(LOGGER_ERROR);
            }
        } while(!isCorrect);
        return num;
    }

    /**
     * starts a cycle until a correct long is entered
     * @see java.util.Scanner
     * @return correct long num
     */
    public long inputLong(){
        Scanner scanner = new Scanner(System.in);
        long num = 0;
        boolean isCorrect;
        do{
            isCorrect = true;
            try{
                num = Long.parseLong(scanner.nextLine());
            } catch(Exception e){
                OutputData outputData = new OutputData();
                outputData.output(ERROR_INPUT);
                isCorrect = false;
                LOGGER.error(LOGGER_ERROR);
            }
        } while(!isCorrect);
        return num;
    }

    /**
     * starts a cycle until a long number in the set interval is entered
     * @see java.util.Scanner
     * @return long num in the set interval
     */
    public long inputLongRange(final long min, final long max){
        boolean isCorrect = true;
        long num;
        do{
            num = inputLong();
            if(num >= min && num <= max){
                isCorrect = false;
            } else{
                OutputData outputData = new OutputData();
                outputData.output(ERROR_INPUT);
            }
        } while(isCorrect);
        return num;
    }

    /**
     * starts a cycle until a integer number in the set interval is entered
     * @see java.util.Scanner
     * @return integer num in the set interval
     */
    public int inputIntRange(final int min, final int max){
        boolean isCorrect = true;
        int num;
        do{
            num = inputInteger();
            if(num >= min && num <= max){
                isCorrect = false;
            } else{
                OutputData outputData = new OutputData();
                outputData.output(ERROR_INPUT);
            }
        } while(isCorrect);
        return num;
    }

    public String inputString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    /**
     * enter hours, minutes and seconds used {@code inputIntRange} method
     * @return {@code Data} object with correct time
     */
    public Data<Integer> inputTime(){
        OutputData outputData = new OutputData();
        Data<Integer> time = new Data<>();
        outputData.output(INPUT_TIME);
        outputData.output(INPUT_HOUR);
        time.push(inputIntRange(0, Watch.MAX_HOUR));
        outputData.output(INPUT_MIN);
        time.push(inputIntRange(0, Watch.MAX_MIN));
        outputData.output(INPUT_SEC);
        time.push(inputIntRange(0, Watch.MAX_SEC));
        return time;
    }
}
