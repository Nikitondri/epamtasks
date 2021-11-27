package test.zakharanka.task01javabasic.service;

import by.zakharanka.task01javabasic.controller.task.linearprogramimpl.MilkTaskImpl;
import by.zakharanka.task01javabasic.entity.Data;
import by.zakharanka.task01javabasic.service.ExpressionService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

public class ExpressionServiceTest {

    final static double CALCULATION_ERROR = 0.1;

    private ExpressionService expressionService;

    @BeforeClass
    public void setUp() {
        expressionService = new ExpressionService();
    }

    @DataProvider(name = "input_a_b_c")
    public Object[][] createDataForExpressionTask8Test(){
        return
                new Object[][]{
                        {new double[]{1.0, 2.0, 3.0}, 0.25},
                        {new double[]{1.0, 1.0, 1.0}, 1.61803},
                        {new double[]{1.0, 1.0, 3.41421}, 0.0},
                        {new double[]{1.0, 1.0, 2.0}, 1.0},
                        {new double[]{-2.0, -5.0, -3.0}, -24.46},
                };
    }

    @Test(description = "positive scenario for expressionTask8",
          dataProvider = "input_a_b_c")
    public void expressionTask8Test(double[] arg, double expected){
        double actual = expressionService.expressionTask8(arg[0], arg[1], arg[2]);
        assertEquals(actual, expected, CALCULATION_ERROR);
    }

    @DataProvider(name = "input_n_m")
    public Object[][] createDataForMilkTaskTest(){
        return
                new Object[][]{
                        {new int[]{5, 3}, 84.0},
                        {new int[]{MilkTaskImpl.MAX_VALUE, 1}, 12.0000000373},
                        {new int[]{1, 1}, 92.0},
                        {new int[]{1, MilkTaskImpl.MAX_VALUE}, 2147483596},
                        {new int[]{MilkTaskImpl.MAX_VALUE, MilkTaskImpl.MAX_VALUE}, 280106636},
                };
    }

    @Test(description = "positive scenario for milkTask",
            dataProvider = "input_n_m")
    public void milkTaskTest(int[] arg, double expected){
        double actual = expressionService.milkTask(arg[0], arg[1]);
        assertEquals(actual, expected, CALCULATION_ERROR);
    }

    @DataProvider(name = "functionRange")
    public Object[][] createDataForFunctionRangeTest(){
        return
                new Object[][]{
                        {new double[]{14.0, 16.0, 1.0, 0.5}, new double[]{19.0, 19.5, 32.0, 20.5, 21}},
                        {new double[]{0.0, 0.0, 0.0, 0.1}, new double[]{6.0}},
                        {new double[]{0.0, 2.0, 1.0, 0.5}, new double[]{5.0, 5.5, 6.0, 6.5, 7.0}},
                };
    }

    @Test(description = "positive scenario for functionRange",
            dataProvider = "functionRange")
    public void functionRangeTest(double[] arg, double[] expected){
        Data<Double> data = expressionService.functionRange(arg[0], arg[1], arg[2], arg[3]);
        double[] actual = new double[data.size()];
        for(int i = 0; i < data.size(); i++){
            actual[i] = data.getData(i);
        }
        assertEquals(actual, expected);
    }

    @DataProvider(name = "sumRowMembers")
    public Object[][] createDataForSumRowMembersTest(){
        return
                new Object[][]{
                        {0.01, 0.3},
                        {3, 0.0},
                };
    }

    @Test(description = "positive scenario for sumRowMembers",
            dataProvider = "sumRowMembers")
    public void sumRowMembersTest(double arg, double expected){
        double actual = expressionService.sumRowMembers(arg);
        assertEquals(actual, expected, CALCULATION_ERROR);
    }
}
