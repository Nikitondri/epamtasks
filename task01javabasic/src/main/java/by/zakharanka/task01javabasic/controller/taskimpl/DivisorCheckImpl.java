package by.zakharanka.task01javabasic.controller.taskimpl;

import by.zakharanka.task01javabasic.entity.Data;
import by.zakharanka.task01javabasic.service.NumbersService;
import by.zakharanka.task01javabasic.view.InputData;
import by.zakharanka.task01javabasic.view.OutputData;

//20. Определить, делителем каких чисел а, b, с является число k.

public class DivisorCheckImpl implements Command{

    private static final String INPUT_NUM1 = "Введите первое число: ";
    private static final String INPUT_NUM2 = "Введите второе число: ";
    private static final String INPUT_NUM3 = "Введите третье число: ";
    private static final String INPUT_DIVISOR = "Введите делитель: ";
    private static final String EMPTY_STR = "";
    private static final String TEXT_TASK = "Определить, делителем каких чисел а, b, с является число k\n";

    private String formationResult(Data<Integer> data, Data<Boolean> dataRes){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < data.size(); i++){
            if(Boolean.TRUE.equals(dataRes.getData(i))){
                result.append(data.getData(i)).append(" ");
            }
        }
        if(result.toString().equals(EMPTY_STR)){
            return "Число k не является делителем ни одного из чисел";
        } else{
            return "Число k является делителем чисел: " + result;
        }
    }

    @Override
    public String exec() {
        Data<Integer> data = new Data<>();
        InputData inputData = new InputData();
        OutputData outputData = new OutputData();
        outputData.output(TEXT_TASK);

//        input data
        outputData.output(INPUT_NUM1);
        data.push(inputData.inputInteger());
        outputData.output(INPUT_NUM2);
        data.push(inputData.inputInteger());
        outputData.output(INPUT_NUM3);
        data.push(inputData.inputInteger());
        outputData.output(INPUT_DIVISOR);
        int divisor = inputData.inputInteger();


        if(divisor != 0) {
            NumbersService numbersService = new NumbersService();
            Data<Boolean> dataRes = numbersService.checkDivisor(data, divisor);
            return formationResult(data, dataRes);
        }
        else
            return "Делитель не может быть равен 0";
    }
}
