package by.zakharanka.task01javabasic.entity.menu;

import by.zakharanka.task01javabasic.controller.task.Command;
import by.zakharanka.task01javabasic.controller.task.branchingimpl.*;
import by.zakharanka.task01javabasic.controller.task.cycleimpl.*;
import by.zakharanka.task01javabasic.controller.task.linearprogramimpl.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Menu {

    static final Logger LOGGER = LogManager.getLogger(Menu.class.getName());

    public static final String MENU_TEXT = "\n\nВыбор задания(1-15)\n" +
            "Линейные программы\n" +
            "1 - 6.Вычисление выражения ((b+sqrt(b^2+4ac))/2a)-(a^3)c+(b^-2)\n" +
            "2 - 8.Задача про бидоны с молоком\n" +
            "3 - 20.Вычисление площади круга\n" +
            "4 - 32.Вычисление нового времени\n" +
            "5 - 34.Перевод байт в другие единицы измерения\n" +
            "Ветвления\n" +
            "6 - 6.Наибольшее из двух чисел а и b\n" +
            "7 - 8.Наименьший из квадратов двух чисел а и b\n" +
            "8 - 20.Делителем каких чисел а, b, с является число k\n" +
            "9 - 32.Является ли сумма двух из трех чисел положительной\n" +
            "10 - 34.Подсчёт сдачи\n" +
            "Циклы\n" +
            "11 - 6.Сумма всех чисел от 1 до введенного числа.\n" +
            "12 - 8.Значения функции y=(x+c)*2,x=15||(x-c)+6,x!=15 на отрезке [а,b] c шагом h:\n" +
            "13 - 20.Сумма ряда, где член a=1/((3n-2)(3n+1)) больше или равен EPS\n" +
            "14 - 32.Проверка корректности идентификатора\n" +
            "15 - 34.Все четырехзначные числа, сумма цифр каждого из которых равна 15\n" +
            "16 - Выход\n" +
            "Ввод: ";

    public Command choice(int arg){
        LOGGER.log(Level.INFO, "Choice is made");
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
            case 11 -> new RowNumbersTask();
            case 12 -> new FunctionRangeImpl();
            case 13 -> new SumRowMembersImpl();
            case 14 -> new IdentifierValidationImpl();
            case 15 -> new FindCorrectNumbersImpl();
            default -> null;
        };
    }
}
