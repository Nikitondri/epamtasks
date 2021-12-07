package by.zakharanka.task01javabasic.controller.taskscommand.linearprogramimpl;

import by.zakharanka.task01javabasic.controller.taskscommand.Command;
import by.zakharanka.task01javabasic.service.ArithmeticService;
import by.zakharanka.task01javabasic.view.InputData;
import by.zakharanka.task01javabasic.view.OutputData;

/**
 * The class for completing the additional task "linear program"
 */
public class SwapNumbersImpl implements Command {

    private static final String INPUT_NUM = "Введите число: ";
    private static final String TEXT_TASK = "Поменять местами два числа тремя способами\n";

    /**
     * The method uses {@code ArithmeticService} class to perform the task
     * Three method are called to demonstrate the same results
     * @see Command
     * @return String literal with the result
     */
    @Override
    public String exec() {
        int[] arr = new int[2];
        InputData inputData = new InputData();
        OutputData outputData = new OutputData();

//      Input data
        outputData.output(TEXT_TASK);
        outputData.output(INPUT_NUM);
        arr[0] = inputData.inputInteger();
        outputData.output(INPUT_NUM);
        arr[1] = inputData.inputInteger();
        int[] arrThirdVariable = arr.clone();
        int[] arrArithmeticOperations = arr.clone();
        int[] arrXOR = arr.clone();

        ArithmeticService arithmeticService = new ArithmeticService();
        arithmeticService.swapThirdVariable(arrThirdVariable);
        arithmeticService.swapArithmeticOperations(arrArithmeticOperations);
        arithmeticService.swapXOR(arrXOR);
        return "Ответ:\n" + "С помощью третьей перменной: " + arrThirdVariable[0] + " " + arrThirdVariable[1] + "\n" +
                "С помощью арифметических операций: " + arrArithmeticOperations[0] + " " + arrArithmeticOperations[1] + "\n" +
                "С помощью XOR: " + arrXOR[0] + " " + arrXOR[1] + "\n";
    }
}
