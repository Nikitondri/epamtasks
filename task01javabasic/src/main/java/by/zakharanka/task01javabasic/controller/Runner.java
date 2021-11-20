package by.zakharanka.task01javabasic.controller;


import by.zakharanka.task01javabasic.controller.menu.Menu;
import by.zakharanka.task01javabasic.entity.Data;
import by.zakharanka.task01javabasic.view.InputData;
import by.zakharanka.task01javabasic.view.OutputData;

public class Runner {

    private static final int NUM_CHOICE = 5;

    public static void main(String[] args) {
        Menu menu = new Menu();
        InputData inputData = new InputData();
        OutputData outputData = new OutputData();
        Command command = menu.choice(inputData.inputRange(NUM_CHOICE));
        outputData.output(command.exec(new Data()).toString());
    }
}
