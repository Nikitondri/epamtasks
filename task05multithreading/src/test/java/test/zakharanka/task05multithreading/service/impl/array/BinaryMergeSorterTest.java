package test.zakharanka.task05multithreading.service.impl.array;

import by.zakharenko.task05multithreading.entity.Array;
import by.zakharenko.task05multithreading.entity.exception.EntityException;
import by.zakharenko.task05multithreading.service.exception.ServiceException;
import by.zakharenko.task05multithreading.service.impl.sort.BinaryMergeSorter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class BinaryMergeSorterTest {
    private BinaryMergeSorter binaryMergeSorter;

    @BeforeClass
    public void SetUp(){
        binaryMergeSorter = new BinaryMergeSorter();
    }

    @DataProvider(name = "binaryMergeSort")
    public Object[][] createDataForSortTest(){
        return
                new Object[][]{
                        {new Integer[]{3, 4, 2, 1}, new Integer[]{1, 2, 3, 4}},
                        {new Integer[]{3}, new Integer[]{3}},
                        {new Integer[]{9, 8, 9, 8, 1, 1, 1}, new Integer[]{1, 1, 1, 8, 8, 9, 9}},
                        {new Integer[]{1, 200, 40, 5, 700, 80, 9}, new Integer[]{1, 5, 9, 40, 80, 200, 700}},
                };
    }

    @Test(description = "positive scenario for binaryMergeSort",
            dataProvider = "binaryMergeSort")
    public void sortTest(Integer[] arg, Integer[] expected) throws EntityException, ServiceException {
        Array<Integer> array = new Array<>(arg);
        Array<Integer> resArr = new Array<>(expected);
        binaryMergeSorter.sort(array);
        assertEquals(array.toString(), resArr.toString());
    }
}
