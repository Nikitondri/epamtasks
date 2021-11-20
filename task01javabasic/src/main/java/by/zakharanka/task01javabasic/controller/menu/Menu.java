package by.zakharanka.task01javabasic.controller.menu;

import by.zakharanka.task01javabasic.controller.Command;
import by.zakharanka.task01javabasic.controller.impl.*;

public class Menu {

    public Command choice(int arg){
        return switch (arg) {
            case 1 -> new ExpressionTask();
            case 2 -> new MilkTask();
            case 3 -> new CheckAreaCircle();
            case 4 -> new TimerTask();
            case 5 -> new ConvertByteTask();
            default -> null;
        };
    }
}
