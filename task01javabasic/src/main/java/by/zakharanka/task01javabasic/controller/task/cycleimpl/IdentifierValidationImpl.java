package by.zakharanka.task01javabasic.controller.task.cycleimpl;

import by.zakharanka.task01javabasic.controller.task.Command;
import by.zakharanka.task01javabasic.entity.Data;
import by.zakharanka.task01javabasic.service.DataValidationService;
import by.zakharanka.task01javabasic.view.InputData;
import by.zakharanka.task01javabasic.view.OutputData;

//32. Проверить введенную пользователем строку на наличие недопустимых символов. В качестве
//первого символа допустимы только буквы и знак подчеркивания. Остальные символы могут быть
//буквами, цифрами и знаком подчеркивания.

/**
 * The class for completing the task 32 "cycle"
 */
public class IdentifierValidationImpl implements Command {

    private static final String INPUT_STR = "Введите строку: ";
    private static final String TEXT_TASK = "Проверка корректности идентификатора\n";


    /**
     * The method uses {@code DataValidationService} class to perform the task
     * @see Command
     * @return String literal with the result
     */
    @Override
    public String exec() {
        Data<String> data = new Data<>();
        InputData inputData = new InputData();
        OutputData outputData = new OutputData();
        outputData.output(TEXT_TASK);

//        input data
        outputData.output(INPUT_STR);
        data.push(inputData.inputString());


        DataValidationService dataValidationService = new DataValidationService();
        if(dataValidationService.identifierValidation(data.getData(0))){
            return "Введённая строка корректна";
        } else{
            return "Введённая строка не корректна";
        }
    }
}
