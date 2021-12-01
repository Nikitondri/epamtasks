package by.zakharanka.task01javabasic.entity.menu;

import by.zakharanka.task01javabasic.controller.task.Command;
import by.zakharanka.task01javabasic.controller.task.branchingimpl.*;
import by.zakharanka.task01javabasic.controller.task.cycleimpl.*;
import by.zakharanka.task01javabasic.controller.task.linearprogramimpl.*;
import by.zakharanka.task01javabasic.view.InputData;
import by.zakharanka.task01javabasic.view.OutputData;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Menu {

    static final Logger LOGGER = LogManager.getLogger(Menu.class.getName());

    private static final int MAX_CHOICE = 17;
    private static final int MIN_CHOICE = 1;

    public static final String MENU_TEXT = "\n\nВыбор задания(1-16)\n" +
            "Линейные программы\n" +
            "1 - 6.Вычисление выражения ((b+sqrt(b^2+4ac))/2a)-(a^3)c+(b^-2)\n" +
            "2 - 8.Задача про бидоны с молоком\n" +
            "3 - 20.Вычисление площади круга\n" +
            "4 - 32.Вычисление нового времени\n" +
            "5 - 34.Перевод байт в другие единицы измерения\n" +
            "6 - Доп.Поменять местами два числа тремя способами\n" +
            "Ветвления\n" +
            "7 - 6.Наибольшее из двух чисел а и b\n" +
            "8 - 8.Наименьший из квадратов двух чисел а и b\n" +
            "9 - 20.Делителем каких чисел а, b, с является число k\n" +
            "10 - 32.Является ли сумма двух из трех чисел положительной\n" +
            "11 - 34.Подсчёт сдачи\n" +
            "Циклы\n" +
            "12 - 6.Сумма всех чисел от 1 до введенного числа.\n" +
            "13 - 8.Значения функции y=(x+c)*2,x=15||(x-c)+6,x!=15 на отрезке [а,b] c шагом h:\n" +
            "14 - 20.Сумма ряда, где член a=1/((3n-2)(3n+1)) больше или равен EPS\n" +
            "15 - 32.Проверка корректности идентификатора\n" +
            "16 - 34.Все четырехзначные числа, сумма цифр каждого из которых равна 15\n" +
            "17 - Выход\n" +
            "Ввод: ";

    /**
     * @param arg tasks number
     * @return implementation of the {@code Command} interface or {@code null} to exit the program
     */
    private Command choice(int arg){
        LOGGER.log(Level.INFO, "Choice is made");
        return switch (arg) {
            case 1 -> new ExpressionTaskImpl();
            case 2 -> new MilkTaskImpl();
            case 3 -> new CheckAreaCircleImpl();
            case 4 -> new TimerTaskImpl();
            case 5 -> new ConvertByteTaskImpl();
            case 6 -> new SwapNumbersImpl();
            case 7 -> new CompareNumbersTaskImpl();
            case 8 -> new CheckMinSquareImpl();
            case 9 -> new DivisorCheckImpl();
            case 10 -> new CheckPositiveSumImpl();
            case 11 -> new StoreTaskImpl();
            case 12 -> new RowNumbersTask();
            case 13 -> new FunctionRangeImpl();
            case 14 -> new SumRowMembersImpl();
            case 15 -> new IdentifierValidationImpl();
            case 16 -> new FindCorrectNumbersImpl();
            default -> null;
        };
    }

    /**
     * run infinite loop for selecting tasks
     * used in {@code Runner} class in {@code main} method
     */
    public void menuOpen(){
        InputData inputData = new InputData();
        OutputData outputData = new OutputData();
        //        cycle for menu
        while(true) {
            outputData.output(MENU_TEXT);
//            defining an interface Command implementation
            Command command = choice(inputData.inputIntRange(MIN_CHOICE, MAX_CHOICE));
//            exit condition
            if(command == null)
                break;
//            response output
            outputData.output(command.exec());
        }
    }
}
