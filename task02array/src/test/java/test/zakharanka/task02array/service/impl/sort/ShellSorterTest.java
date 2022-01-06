package test.zakharanka.task02array.service.impl.sort;

import by.zakharanka.task02array.entity.Array;
import by.zakharanka.task02array.entity.exception.EntityException;
import by.zakharanka.task02array.service.impl.sort.ShellSorter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ShellSorterTest {
    private ShellSorter shellSorter;

    @BeforeClass
    public void SetUp(){
        shellSorter = new ShellSorter();
    }

    @DataProvider(name = "shakerSort")
    public Object[][] createDataForSortTest(){
        return
                new Object[][]{
                        {new Integer[]{3, 4, 2, 1}, new Integer[]{1, 2, 3, 4}},
                        {new Integer[]{3}, new Integer[]{3}},
                        {new Integer[]{9, 8, 9, 8, 1, 1, 1}, new Integer[]{1, 1, 1, 8, 8, 9, 9}},
                        {new Integer[]{1, 2, 3, 19, 18, 17, 16, 25, 26, 27}, new Integer[]{1, 2, 3, 16, 17, 18, 19, 25, 26, 27}},
                        {new Integer[]{90, 2, 3, 19, 18, 17, 16, 30, 27, 26}, new Integer[]{2, 3, 16, 17, 18, 19, 26, 27, 30, 90}},
                        {new Integer[]{1, 200, 40, 5, 700, 80, 9}, new Integer[]{1, 5, 9, 40, 80, 200, 700}},
                };
    }

    @Test(description = "positive scenario for checkMaxNumbers",
            dataProvider = "shakerSort")
    public void sortTest(Integer[] arg, Integer[] expected) throws EntityException {
        Array<Integer> array = new Array<>(arg);
        Array<Integer> resArr = new Array<>(expected);
        shellSorter.sort(array);
        assertEquals(array.toString(), resArr.toString());
    }
}
