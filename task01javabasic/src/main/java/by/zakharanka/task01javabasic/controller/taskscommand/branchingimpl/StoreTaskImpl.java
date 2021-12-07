package by.zakharanka.task01javabasic.controller.taskscommand.branchingimpl;

//34. Составить программу, реализующую эпизод применения компьютера в книжном магазине. Компьютер
//запрашивает стоимость книг, сумму денег, внесенную покупателем; если сдачи не требуется, печатает на экране
//«спасибо»; если денег внесено больше, чем необходимо, то печатает «возьмите сдачу» и указывает сумму сдачи; если
//денег недостаточно, то печатает сообщение об этом и указывает размер недостающей суммы.

import by.zakharanka.task01javabasic.controller.taskscommand.Command;
import by.zakharanka.task01javabasic.entity.Data;
import by.zakharanka.task01javabasic.service.ArithmeticService;
import by.zakharanka.task01javabasic.view.InputData;
import by.zakharanka.task01javabasic.view.OutputData;

/**
 * The class for completing the task 34 "branching"
 */
public class StoreTaskImpl implements Command {

    private static final String INPUT_PRICE = "Введите стоимость: ";
    private static final String INPUT_CASH = "Введите сумму денег: ";
    private static final String TEXT_TASK = "Задача про магазин\n";

    /**
     * The method uses {@code ArithmeticService} class to perform the task
     * @see Command
     * @return String literal with the result
     */
    @Override
    public String exec() {
        Data<Double> data = new Data<>();
        InputData inputData = new InputData();
        OutputData outputData = new OutputData();
        outputData.output(TEXT_TASK);

//        input data
        outputData.output(INPUT_PRICE);
        data.push(inputData.inputDouble());
        outputData.output(INPUT_CASH);
        data.push(inputData.inputDouble());

        ArithmeticService arithmeticService = new ArithmeticService();
        if (arithmeticService.compareNumbers(data.getData(0), data.getData(1))) {
            return "Спасибо";
        } else if(data.getData(0) > data.getData(1)){
            return "Недосаточно средств, внесите дополнительно: " + arithmeticService.difference(data.getData(0), data.getData(1));
        } else{
            return "Ваша сдача: " + arithmeticService.difference(data.getData(0), data.getData(1));
        }
    }
}
