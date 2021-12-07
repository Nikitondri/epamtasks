package by.zakharanka.task01javabasic.controller.taskscommand.cycleimpl;

import by.zakharanka.task01javabasic.controller.taskscommand.Command;
import by.zakharanka.task01javabasic.entity.Data;
import by.zakharanka.task01javabasic.service.ArithmeticService;
import by.zakharanka.task01javabasic.view.OutputData;

//34. Найдите все четырехзначные числа, сумма цифр каждого из которых равна 15.

/**
 * The class for completing the task 34 "cycle"
 */
public class FindCorrectNumbersImpl implements Command {

    private static final String TEXT_TASK = "Найдите все четырехзначные числа, сумма цифр каждого из которых равна 15\n";

    private String formationResult(Data<Integer> data){
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < data.size(); i++){
            result.append(data.getData(i)).append("\n");
        }
        return result.toString();
    }

    /**
     * The method uses {@code ArithmeticService} class to perform the task
     * uses {@code formationResult} method to perform a string with the result
     * @see Command
     * @return String literal with the result
     */
    @Override
    public String exec() {
        OutputData outputData = new OutputData();
        outputData.output(TEXT_TASK);

        ArithmeticService arithmeticService = new ArithmeticService();
        Data<Integer> data = arithmeticService.findCorrectNumber();
        return formationResult(data);
    }
}
