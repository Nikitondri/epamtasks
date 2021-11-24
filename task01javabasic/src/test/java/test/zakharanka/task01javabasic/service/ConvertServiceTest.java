package test.zakharanka.task01javabasic.service;

import by.zakharanka.task01javabasic.entity.Data;
import by.zakharanka.task01javabasic.service.ConvertService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ConvertServiceTest {

    private static final double ERROR = 0.000001;

    private ConvertService convertService;

    @BeforeClass
    public void setUp() {
        convertService = new ConvertService();
    }

    @DataProvider(name = "input_length")
    public Object[][] createDataForExpressionTask8Test(){
        return
                new Object[][]{
                        {new double[]{Double.MAX_VALUE}, new double[]{
                                1.7555597020139802E305,
                                1.7144137714980275E302,
                                1.6742321987285425E299,
                                1.6349923815708423E296}
                        },
                        {new double[]{1000000}, new double[]{976.5625, 0.9536743164, 0.00093132257, 9.094947017729282E-7}},
                        {new double[]{0}, new double[]{0.0, 0.0, 0.0, 0.0}},
                        {new double[]{1.099511627776E12}, new double[]{1.073741824E9, 1048576.0, 1024.0, 1.0}},
                };
    }

    @Test(description = "positive scenario for expressionTask8",
            dataProvider = "input_length")
    public void expressionTask8Test(double[] arg, double[] expected){
        Data<Double> data = convertService.convertByte(arg[0]);
        double[] actual = new double[]{data.getData(0),
                                       data.getData(1),
                                       data.getData(2),
                                       data.getData(3)};
        assertEquals(actual, expected, ERROR);
    }
}
