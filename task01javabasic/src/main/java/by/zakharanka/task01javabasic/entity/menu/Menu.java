package by.zakharanka.task01javabasic.entity.menu;

import by.zakharanka.task01javabasic.controller.taskimpl.Command;
import by.zakharanka.task01javabasic.controller.taskimpl.*;

public class Menu {
    public static final String MENU_TEXT = "\nВведите номер задания(1-10) или 11 для выхода\n" +
            "1 - Вычисление выражения ((b+sqrt(b^2+4ac))/2a)-(a^3)c+(b^-2)\n" +
            "2 - Задача про бидоны с молоком\n" +
            "3 - Вычисление площади круга\n" +
            "4 - Вычисление нового времени\n" +
            "5 - Перевод байт в другие единицы измерения\n" +
            "6 - Наибольшее из двух чисел а и b\n" +
            "7 - Наименьший из квадратов двух чисел а и b\n" +
            "8 - Делителем каких чисел а, b, с является число k\n" +
            "9 - Является ли сумма двух из трех чисел положительной\n" +
            "10 - Подсчёт сдачи\n" +
            "Ввод: ";

    public Command choice(int arg){
        return switch (arg) {
            case 1 -> new ExpressionTaskImpl();
            case 2 -> new MilkTaskImpl();
            case 3 -> new CheckAreaCircleImpl();
            case 4 -> new TimerTaskImpl();
            case 5 -> new ConvertByteTaskImpl();
            case 6 -> new CompareNumbersTaskImpl();
            case 7 -> new CheckMinSquareImpl();
            case 8 -> new DivisorCheckImpl();
            case 9 -> new CheckPositiveSumImpl();
            case 10 -> new StoreTaskImpl();
            default -> null;
        };
    }
}
