package test.zakharanka.task05multithreading.service.impl.array;

import by.zakharenko.task05multithreading.entity.Array;
import by.zakharenko.task05multithreading.entity.exception.EntityException;
import by.zakharenko.task05multithreading.service.impl.sort.ShakerSorter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ShakerSorterTest {
    private ShakerSorter shakerSorter;

    @BeforeClass
    public void SetUp(){
        shakerSorter = new ShakerSorter();
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
        shakerSorter.sort(array);
        assertEquals(array, resArr);
    }
}
