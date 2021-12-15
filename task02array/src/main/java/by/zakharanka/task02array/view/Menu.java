package by.zakharanka.task02array.view;

import by.zakharanka.task02array.controller.Controller;
import by.zakharanka.task02array.entity.Data;
import by.zakharanka.task02array.view.manager.MessageManager;

import java.util.HashMap;

public class Menu {

    private final String CHOICE_LANGUAGE_TEXT = "language";
    private final String CHOICE_TASK_TEXT = "CHOICE_TASK_TEXT";
    private final String CHOICE_FILL_TEXT = "CHOICE_FILL_TEXT";
    private final String INPUT_PATH_TEXT = "INPUT_PATH_TEXT";
    private final String ANSWER_TEXT = "ANSWER_TEXT";
    private final String INPUT_RANDOM_DATA = "INPUT_RANDOM_DATA";


    OutputData outputData;
    InputData inputData;

    public Menu(){
        outputData = new OutputData();
        inputData = new InputData();
    }

    private MessageManager choiceLanguage(char arg){
        return switch (arg){
            case '1'-> MessageManager.RU;
            case '2'-> MessageManager.BY;
            default -> MessageManager.EN;
        };
    }

    private String choiceTask(int arg){
        return switch (arg){
            case 1 -> "MATRIX_ADDITION";
            case 2 -> "MATRIX_MULTIPLICATION";
            case 3 -> "MATRIX_SUBTRACTION";
            case 4 -> "MATRIX_TRANSPOSITION";
            case 5 -> "BINARY_MERGE_SORT";
            case 6 -> "BUBBLE_SORT";
            case 7 -> "EXTERNAL_SORT";
            case 8 -> "INSERT_SORT";
            case 9 -> "SHAKER_SORT";
            case 10 -> "SHELL_SORT";
            case 11 -> "SIMPLE_CHOICE_SORT";
            case 12 -> "SIMPLE_INSERT_SORT";
            default -> "WRONG_COMMAND";
        };
    }

    private String choiceFillingMethod(int arg){
        return switch (arg){
            case 1 -> "FROM_FILE";
            case 2 -> "RANDOM";
            default -> "WRONG_FILL";
        };
    }

    private void outputResult(HashMap<String, Exception> result){
        for(String key: result.keySet()){
            if(key != null){
                outputData.output(key);
            } else {
                outputData.output("Error");
                outputData.output(result.get(null).toString());
            }
        }
    }

    public void menu() {
        outputData.output(CHOICE_LANGUAGE_TEXT);
        MessageManager mm = choiceLanguage(inputData.inputChar());
        outputData.output(mm.getString(CHOICE_TASK_TEXT));
        int name = inputData.inputInteger();
        String commandName = choiceTask(name);
        outputData.output(commandName);
        boolean isDoubleData = "MATRIX_ADDITION".equals(commandName) ||
                "MATRIX_MULTIPLICATION".equals(commandName) ||
                "MATRIX_SUBTRACTION".equals(commandName);
        Data<String> request = new Data<>();
        outputData.output(mm.getString(CHOICE_FILL_TEXT));
        request.put(choiceFillingMethod(inputData.inputInteger()));
        if ("FROM_FILE".equals(request.getElement(0))) {
            outputData.output(mm.getString(INPUT_PATH_TEXT));
            request.put(inputData.inputString());
            if(isDoubleData){
                request.put(inputData.inputString());
            }
        }
        if ("RANDOM".equals(request.getElement(0))) {
            outputData.output(mm.getString(INPUT_RANDOM_DATA));
            request.put(inputData.inputString());
            if(isDoubleData){
                request.put(inputData.inputString());
            }
        }
        if ("WRONG_FILL".equals(request.getElement(0))) {
            request.put(null);
        }
        Controller controller = new Controller();
        outputData.output(mm.getString(ANSWER_TEXT));
        outputResult(controller.executeTask(commandName, request));
    }


}
