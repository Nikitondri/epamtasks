package by.zakharanka.task01javabasic.controller.task.cycleimpl;

import by.zakharanka.task01javabasic.controller.task.Command;
import by.zakharanka.task01javabasic.entity.Data;
import by.zakharanka.task01javabasic.service.ArithmeticService;
import by.zakharanka.task01javabasic.view.OutputData;

//34. Найдите все четырехзначные числа, сумма цифр каждого из которых равна 15.

public class FindCorrectNumbersImpl implements Command {

    private static final String TEXT_TASK = "Найдите все четырехзначные числа, сумма цифр каждого из которых равна 15\n";

    private String formationResult(Data<Integer> data){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < data.size(); i++){
            result.append(data.getData(i)).append("\n");
        }
        return result.toString();
    }

    @Override
    public String exec() {
        OutputData outputData = new OutputData();
        outputData.output(TEXT_TASK);

        ArithmeticService arithmeticService = new ArithmeticService();
        Data<Integer> data = arithmeticService.findCorrectNumber();
        return formationResult(data);
    }
}
