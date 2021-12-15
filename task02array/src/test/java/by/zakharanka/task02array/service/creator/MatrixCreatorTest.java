package by.zakharanka.task02array.service.creator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MatrixCreatorTest {

    MatrixCreator matrixCreator;

    @DataProvider(name = "checkCreateArray")
    public Object[][] createDataForCheckMaxNumbersTest(){
        return
                new Object[][]{
                        {"1 2 3\n4 5 6\n7 8 9", new int[][]{
                                new int[]{1, 2, 3},
                                new int[]{4, 5, 6},
                                new int[]{7, 8, 9},
                        }},
                };
    }

    @Test(description = "positive scenario for checkMaxNumbers",
            dataProvider = "checkCreateArray")
    public void checkMaxNumbersTest(String arg, int[][] expected){
//        int[][] actual = matrixCreator.createArray(arg);
//        assertEquals(actual, expected);
    }
}
