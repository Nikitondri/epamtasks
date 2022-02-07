package by.zakharenko.task05multithreading.view;

import by.zakharenko.task05multithreading.controller.command.CommandName;
import by.zakharenko.task05multithreading.entity.Data;

import java.util.Random;

public class GeneratorRequest {

    private final Random random;

    public GeneratorRequest(){
        random = new Random();
    }

    private CommandName choiceTask(int arg){
        return switch (arg){
            case 1 -> CommandName.MATRIX_ADDITION;
            case 2 -> CommandName.MATRIX_MULTIPLICATION;
            case 3 -> CommandName.MATRIX_SUBTRACTION;
            case 4 -> CommandName.MATRIX_TRANSPOSITION;
            case 5 -> CommandName.BINARY_MERGE_SORT;
            case 6 -> CommandName.BUBBLE_SORT;
            case 7 -> CommandName.MATRIX_MULTIPLICATION_BY_NUMBER;
            case 8 -> CommandName.INSERT_SORT;
            case 9 -> CommandName.SHAKER_SORT;
            case 10 -> CommandName.SHELL_SORT;
            case 11 -> CommandName.SIMPLE_CHOICE_SORT;
            case 12 -> CommandName.SIMPLE_INSERT_SORT;
            case 13 -> CommandName.EXTERNAL_SORT;
            default -> CommandName.WRONG_COMMAND;
        };
    }

    public Data<String> generate(){
        CommandName commandName = choiceTask(random.nextInt(12) + 1);
        Data<String> request = new Data<>();
        request.put(commandName.toString());
        if(commandName.ordinal() <= 3 || commandName.ordinal() == 12){
            request.put("matrix/matrix" + random.nextInt(10) + ".txt");
            request.put("matrix/matrix" + random.nextInt(10) + ".txt");
        } else {
            request.put("array/array" + random.nextInt(10) + ".txt");
        }
        return request;
    }
}
