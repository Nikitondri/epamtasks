package by.zakharanka.task02array.service.impl.sort;

import by.zakharanka.task02array.entity.Array;
import by.zakharanka.task02array.entity.exception.EntityException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class BubbleSorterTest {
    private BubbleSorter bubbleSorter;

    @BeforeClass
    public void SetUp(){
        bubbleSorter = new BubbleSorter();
    }

    @DataProvider(name = "bubbleSort")
    public Object[][] createDataForCheckMaxNumbersTest(){
        return
                new Object[][]{
                        {new Integer[]{3, 4, 2, 1}, new Integer[]{1, 2, 3, 4}},
                        {new Integer[]{3}, new Integer[]{3}},
                        {new Integer[]{9, 8, 9, 8, 1, 1, 1}, new Integer[]{1, 1, 1, 8, 8, 9, 9}},
                };
    }

    @Test(description = "positive scenario for checkMaxNumbers",
            dataProvider = "bubbleSort")
    public void checkMaxNumbersTest(Integer[] arg, Integer[] expected) throws EntityException {
        Array<Integer> array = new Array<>(arg);
        Array<Integer> resArr = new Array<>(expected);
        bubbleSorter.sort(array);
        assertEquals(array.toString(), resArr.toString());
    }
}
