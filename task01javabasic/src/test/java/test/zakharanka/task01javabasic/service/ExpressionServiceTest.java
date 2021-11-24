package test.zakharanka.task01javabasic.service;

import by.zakharanka.task01javabasic.controller.impl.MilkTask;
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
                        {new int[]{MilkTask.MAX_VALUE, 1}, 12.0000000373},
                        {new int[]{1, 1}, 92.0},
                        {new int[]{1, MilkTask.MAX_VALUE}, 2147483596},
                        {new int[]{MilkTask.MAX_VALUE, MilkTask.MAX_VALUE}, 280106636},
                };
    }

    @Test(description = "positive scenario for milkTask",
            dataProvider = "input_n_m")
    public void milkTaskTest(int[] arg, double expected){
        double actual = expressionService.milkTask(arg[0], arg[1]);
        assertEquals(actual, expected, CALCULATION_ERROR);
    }
}
