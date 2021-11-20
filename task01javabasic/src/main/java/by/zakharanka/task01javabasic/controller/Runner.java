package by.zakharanka.task01javabasic.controller;


import by.zakharanka.task01javabasic.controller.menu.Menu;
import by.zakharanka.task01javabasic.view.InputData;
import by.zakharanka.task01javabasic.view.OutputData;

public class Runner {

    private static final int MAX_CHOICE = 6;
    private static final int MIN_CHOICE = 1;
    private static final String MENU_TEXT = "\nВведите номер задания(1-5) или 6 для выхода\n" +
                                            "1 - Вычисление выражения ((b+sqrt(b^2+4ac))/2a)-(a^3)c+(b^-2)\n" +
                                            "2 - Задача про бидоны с молоком\n" +
                                            "3 - Вычисление площади круга\n" +
                                            "4 - Вычисление нового времени\n" +
                                            "5 - Перевод байт в другие единицы измерения\n" +
                                            "Ввод: ";

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
