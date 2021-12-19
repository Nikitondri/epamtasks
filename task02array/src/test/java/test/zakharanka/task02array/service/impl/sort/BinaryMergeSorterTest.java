package test.zakharanka.task02array.service.impl.sort;

import by.zakharanka.task02array.entity.Array;
import by.zakharanka.task02array.entity.exception.EntityException;
import by.zakharanka.task02array.service.exception.ServiceException;
import by.zakharanka.task02array.service.impl.sort.BinaryMergeSorter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

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
