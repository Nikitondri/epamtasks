package by.zakharanka.task01javabasic.controller;


import by.zakharanka.task01javabasic.controller.taskimpl.Command;
import by.zakharanka.task01javabasic.entity.menu.Menu;
import by.zakharanka.task01javabasic.view.InputData;
import by.zakharanka.task01javabasic.view.OutputData;

import static by.zakharanka.task01javabasic.entity.menu.Menu.MENU_TEXT;

public class Runner {
//TODO: add logger
    private static final int MAX_CHOICE = 11;
    private static final int MIN_CHOICE = 1;

    public static void main(String[] args) {
//        creating objects
        Menu menu = new Menu();
        InputData inputData = new InputData();
        OutputData outputData = new OutputData();

//        cycle for menu
        while(true) {
            outputData.output(MENU_TEXT);
//            defining an interface Command implementation
            Command command = menu.choice(inputData.inputIntRange(MIN_CHOICE, MAX_CHOICE));
//            exit condition
            if(command == null)
                break;
//            response output
            outputData.output(command.exec());
        }
    }
}
