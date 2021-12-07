package test.zakharanka.task01javabasic.service;

import by.zakharanka.task01javabasic.controller.taskscommand.branchingimpl.CheckMinSquareImpl;
import by.zakharanka.task01javabasic.controller.taskscommand.branchingimpl.CheckPositiveSumImpl;
import by.zakharanka.task01javabasic.controller.taskscommand.cycleimpl.RowNumbersTask;
import by.zakharanka.task01javabasic.entity.Data;
import by.zakharanka.task01javabasic.service.ArithmeticService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArithmeticServiceTest {

    private static final double ERROR = 0.000000001;

    ArithmeticService arithmeticService;

    @BeforeClass
    public void setUp() {
        arithmeticService = new ArithmeticService();
    }

    @DataProvider(name = "checkMaxNumbers")
    public Object[][] createDataForCheckMaxNumbersTest(){
        return
                new Object[][]{
                        {new double[]{5.0, 5.0}, 5.0},
                        {new double[]{6.0, 5.0}, 6.0},
                        {new double[]{Double.MAX_VALUE, Double.MAX_VALUE}, Double.MAX_VALUE},
                        {new double[]{-10.0, -15.0}, -10.0},
                        {new double[]{0.0, 0.1}, 0.1},
                };
    }

    @Test(description = "positive scenario for checkMaxNumbers",
          dataProvider = "checkMaxNumbers")
    public void checkMaxNumbersTest(double[] arg, double expected){
        double actual = arithmeticService.checkMaxNumber(arg[0], arg[1]);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "compareNumbers")
    public Object[][] createDataForCompareNumbersTest(){
        return
                new Object[][]{
                        {new double[]{5.0, 5.0}, true},
                        {new double[]{6.0, 5.0}, false},
                        {new double[]{Double.MAX_VALUE, Double.MAX_VALUE}, true},
                        {new double[]{-5.0, 5.0}, false},
                        {new double[]{0, 0}, true},
                };
    }

    @Test(description = "positive scenario for compareNumbers",
            dataProvider = "compareNumbers")
    public void compareNumbersTest(double[] arg, boolean expected){
        boolean actual = arithmeticService.compareNumbers(arg[0], arg[1]);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "minSquare")
    public Object[][] createDataForMinSquareTest(){
        return
                new Object[][]{
                        {new double[]{5.0, 5.0}, 25.0},
                        {new double[]{6.0, 5.0}, 25.0},
                        {new double[]{CheckMinSquareImpl.MAX_NUMBER, CheckMinSquareImpl.MAX_NUMBER}, 1.7976931348623155E308},
                        {new double[]{-CheckMinSquareImpl.MAX_NUMBER, CheckMinSquareImpl.MAX_NUMBER}, 1.7976931348623155E308},
                        {new double[]{-3.0, 5.0}, 9.0},
                        {new double[]{-3.0, -2.0}, 4.0},
                        {new double[]{0.0, 0.0}, 0.0},
                };
    }

    @Test(description = "positive scenario for minSquare",
            dataProvider = "minSquare")
    public void minSquareTest(double[] arg, double expected){
        double actual = arithmeticService.minSquare(arg[0], arg[1]);
        assertEquals(actual, expected, ERROR);
    }

    @DataProvider(name = "divisorCheck")
    public Object[][] createDataForDivisorCheckTest(){
        return
                new Object[][]{
                        {new int[]{10, 15, 20, 10}, new boolean[]{true, false, true}},
                        {new int[]{13, 17, 19, 2}, new boolean[]{false, false, false}},
                        {new int[]{10, 15, 20, 5}, new boolean[]{true, true, true}},
                        {new int[]{0, 0, 0, 2}, new boolean[]{true, true, true}},
                        {new int[]{-20, -15, -10, 10}, new boolean[]{true, false, true}},
                };
    }

    @Test(description = "positive scenario for divisorCheck",
            dataProvider = "divisorCheck")
    public void divisorCheckTest(int[] arg, boolean[] expected) {
        Data<Integer> data = new Data<>();
        data.push(arg[0]);
        data.push(arg[1]);
        data.push(arg[2]);
        Data<Boolean> dataRes = arithmeticService.checkDivisor(data, arg[3]);
        boolean[] actual = new boolean[]{dataRes.getData(0), dataRes.getData(1), dataRes.getData(2)};
        assertEquals(actual, expected);
    }

    @DataProvider(name = "isPositiveSum")
    public Object[][] createDataForIsPositiveSumTest(){
        return
                new Object[][]{
                        {new double[]{0.0, 0.0, 0.0}, false},
                        {new double[]{CheckPositiveSumImpl.MAX_VALUE, CheckPositiveSumImpl.MAX_VALUE, 0.0}, true},
                        {new double[]{CheckPositiveSumImpl.MAX_VALUE, -CheckPositiveSumImpl.MAX_VALUE, 0.0}, true},
                        {new double[]{-5.0, -5.2, 5.1}, true},
                };
    }

    @Test(description = "positive scenario for isPositiveSum",
            dataProvider = "isPositiveSum")
    public void isPositiveSumTest(double[] arg, boolean expected){
        boolean actual = arithmeticService.isPositiveSum(arg[0], arg[1], arg[2]);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "difference")
    public Object[][] createDataForDifferenceTest(){
        return
                new Object[][]{
                        {new double[]{0.0, 0.0}, 0.0},
                        {new double[]{Double.MAX_VALUE, Double.MAX_VALUE}, 0.0},
                        {new double[]{5.0, -5.0}, 10.0},
                        {new double[]{10.0, 5.0}, 5.0},
                        {new double[]{5.2, 5.0}, 0.2},
                };
    }

    @Test(description = "positive scenario for difference",
            dataProvider = "difference")
    public void differenceTest(double[] arg, double expected){
        double actual = arithmeticService.difference(arg[0], arg[1]);
        assertEquals(actual, expected, ERROR);
    }

    @DataProvider(name = "rowNumbers")
    public Object[][] createDataForRowNumbersTest(){
        return
                new Object[][]{
                        {2, 3},
                        {10, 55},
                        {1, 1},
                        {100, 5050},
                        {RowNumbersTask.MAX_NUMBER, 2145157750},
                        {RowNumbersTask.MAX_NUMBER - 1, 2145092250},
                };
    }

    @Test(description = "positive scenario for rowNumbers",
            dataProvider = "rowNumbers")
    public void rowNumbersTest(int arg, int expected){
        double actual = arithmeticService.rowNumbers(arg);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "sumDigits")
    public Object[][] createDataForSumDigitsTest(){
        return
                new Object[][]{
                        {25, 7},
                        {0, 0},
                        {1000, 1},
                        {-30, -3},
                        {-25, -7},
                        {9999, 36},
                };
    }

    @Test(description = "positive scenario for rowNumbers",
            dataProvider = "sumDigits")
    public void sumDigitsTest(int arg, int expected){
        double actual = arithmeticService.sumDigits(arg);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "swap")
    public Object[][] createDataForSwapXORTest(){
        return
                new Object[][]{
                        {new int[]{25, 7}, new int[]{7, 25}},
                        {new int[]{0, 0}, new int[]{0, 0}},
                        {new int[]{3, -3}, new int[]{-3, 3}},
                        {new int[]{Integer.MAX_VALUE, 0}, new int[]{0, Integer.MAX_VALUE}},
                        {new int[]{-5, -10}, new int[]{-10, -5}},
                };
    }

    @Test(description = "positive scenario for swapXOR",
            dataProvider = "swap")
    public void swapXORTest(int[] actual, int[] expected){
        arithmeticService.swapXOR(actual);
        assertEquals(actual, expected);
    }

    @Test(description = "positive scenario for swapArithmeticOperations",
            dataProvider = "swap")
    public void swapArithmeticOperationsTest(int[] actual, int[] expected){
        arithmeticService.swapArithmeticOperations(actual);
        assertEquals(actual, expected);
    }

    @Test(description = "positive scenario for swapThirdVariable",
            dataProvider = "swap")
    public void swapThirdVariableTest(int[] actual, int[] expected){
        arithmeticService.swapThirdVariable(actual);
        assertEquals(actual, expected);
    }

}
