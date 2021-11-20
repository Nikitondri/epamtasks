package by.zakharanka.task01javabasic.controller.menu;

import by.zakharanka.task01javabasic.controller.Command;
import by.zakharanka.task01javabasic.controller.impl.CheckAreaCircle;
import by.zakharanka.task01javabasic.controller.impl.ExpressionTask;
import by.zakharanka.task01javabasic.controller.impl.MilkTask;

public class Menu {

    public Command choice(int arg){
        switch(arg){
            case 1:
                return new ExpressionTask();
            case 2:
                return new MilkTask();
            case 3:
                return new CheckAreaCircle();
            case 4:
                break;
            case 5:
                break;
        }
        return null;
    }
}
