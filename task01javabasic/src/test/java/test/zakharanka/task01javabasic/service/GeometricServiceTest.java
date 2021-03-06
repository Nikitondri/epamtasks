package test.zakharanka.task01javabasic.service;

import by.zakharanka.task01javabasic.controller.taskscommand.linearprogramimpl.CheckAreaCircleImpl;
import by.zakharanka.task01javabasic.service.GeometricService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeometricServiceTest {

    private static final double CALCULATION_ERROR = 0.00000000000001;

    private GeometricService geometricService;

    @BeforeClass
    public void setUp() {
        geometricService = new GeometricService();
    }

    @DataProvider(name = "input_length")
    public Object[][] createDataForExpressionTask8Test(){
        return
                new Object[][]{
                        {new double[]{1.0}, 0.07957747154594767},
                        {new double[]{0.0}, 0.0},
                        {new double[]{CheckAreaCircleImpl.MAX_LENGTH}, Double.MAX_VALUE},
                        {new double[]{3.5449077018110318}, 1.0},
                };
    }

    @Test(description = "positive scenario for expressionTask8",
            dataProvider = "input_length")
    public void expressionTask8Test(double[] arg, double expected){
        double actual = geometricService.findCircleArea(arg[0]);
        assertEquals(actual, expected, CALCULATION_ERROR);
    }
}
