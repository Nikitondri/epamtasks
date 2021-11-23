package test.zakharanka.task01javabasic.service;

import by.zakharanka.task01javabasic.service.GeometricService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeometricServiceTest {

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
                };
    }

    @Test(description = "positive scenario for expressionTask8",
            dataProvider = "input_length")
    public void expressionTask8Test(double[] arg, double expected){
        double actual = geometricService.findCircleArea(arg[0]);
        assertEquals(actual, expected);
    }
}
