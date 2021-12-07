package by.zakharanka.task01javabasic.controller.menu;


import by.zakharanka.task01javabasic.controller.taskscommand.branchingimpl.*;
import by.zakharanka.task01javabasic.controller.taskscommand.cycleimpl.*;
import by.zakharanka.task01javabasic.controller.taskscommand.linearprogramimpl.*;
import by.zakharanka.task01javabasic.view.InputData;
import by.zakharanka.task01javabasic.view.OutputData;


public class Menu {

    private static final int MAX_CHOICE = 16;
    private static final int MIN_CHOICE = 0;

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

            switch (inputData.inputIntRange(MIN_CHOICE, MAX_CHOICE)) {
                case 0 -> System.exit(0);
                case 1 -> outputData.output(new ExpressionTaskImpl().exec());
                case 2 -> outputData.output(new MilkTaskImpl().exec());
                case 3 -> outputData.output(new CheckAreaCircleImpl().exec());
                case 4 -> outputData.output(new TimerTaskImpl().exec());
                case 5 -> outputData.output(new ConvertByteTaskImpl().exec());
                case 6 -> outputData.output(new SwapNumbersImpl().exec());
                case 7 -> outputData.output(new CompareNumbersTaskImpl().exec());
                case 8 -> outputData.output(new CheckMinSquareImpl().exec());
                case 9 -> outputData.output(new DivisorCheckImpl().exec());
                case 10 -> outputData.output(new CheckPositiveSumImpl().exec());
                case 11 -> outputData.output(new StoreTaskImpl().exec());
                case 12 -> outputData.output(new RowNumbersTask().exec());
                case 13 -> outputData.output(new FunctionRangeImpl().exec());
                case 14 -> outputData.output(new SumRowMembersImpl().exec());
                case 15 -> outputData.output(new IdentifierValidationImpl().exec());
                case 16 -> outputData.output(new FindCorrectNumbersImpl().exec());
                default -> throw new IllegalStateException("Unexpected value");
            }
        }
    }
}
