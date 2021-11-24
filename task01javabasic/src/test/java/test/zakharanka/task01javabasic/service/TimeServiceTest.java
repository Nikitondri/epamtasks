package test.zakharanka.task01javabasic.service;

import by.zakharanka.task01javabasic.controller.impl.TimerTask;
import by.zakharanka.task01javabasic.entity.Data;
import by.zakharanka.task01javabasic.service.TimeService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TimeServiceTest {

    private TimeService timeService;

    @BeforeClass
    public void setUp() {
        timeService = new TimeService();
    }

    @DataProvider(name = "input_length")
    public Object[][] createDataForExpressionTask8Test(){
        return
                new Object[][]{
                        {new int[]{23, 50, 59, 50, 150, 100}, new int[]{4, 22, 39}},
                        {new int[]{0, 0, 0, 0, 0, 0}, new int[]{0, 0, 0}},
                        {new int[]{23, 59, 59, 0, 0, 1}, new int[]{0, 0, 0}},
                        {new int[]{0, 0, 0, TimerTask.MAX_TIME, TimerTask.MAX_TIME, TimerTask.MAX_TIME}, new int[]{11, 17, 14}},
                };
    }

    @Test(description = "positive scenario for expressionTask8",
            dataProvider = "input_length")
    public void expressionTask8Test(int[] arg, int[] expected){
        Data<Integer> data = timeService.checkNewTime(arg[0], arg[1], arg[2], arg[3], arg[4], arg[5]);
        int[] actual = new int[]{data.getData(0), data.getData(1), data.getData(2)};
        assertEquals(actual, expected);
    }
}
