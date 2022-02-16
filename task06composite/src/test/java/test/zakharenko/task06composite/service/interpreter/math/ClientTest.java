package test.zakharenko.task06composite.service.interpreter.math;

import by.zakharenko.task06composite.service.interpreter.math.Client;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ClientTest {

    @DataProvider(name = "calculate")
    public Object[][] calculateData(){
        return
                new Object[][]{
                        {"1 1 &", 1},
                        {"1 0 &", 0},
                        {"13 2 <<", 52},
                        {"71 ~ 2 3 & 3 2 1 2 >> & 2 | 2 & | | 10 2 & | & 78 |", 78},
                        {"1 1 ^", 0},
                };
    }

    @Test(description = "positive scenario for convert",
            dataProvider = "calculate")
    public void calculateTest(String arg, Number expected) {
        Client interpreter = new Client(arg);
        assertEquals(interpreter.calculate(), expected);
    }
}
