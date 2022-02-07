package test.zakharanka.task05multithreading.service.impl.matrix;

import by.zakharenko.task05multithreading.entity.Data;
import by.zakharenko.task05multithreading.entity.Matrix;
import by.zakharenko.task05multithreading.service.exception.ServiceException;
import by.zakharenko.task05multithreading.service.impl.matrix.AdderMultithreaded;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AdderMultithreadedTest {
    private AdderMultithreaded adder;

    @BeforeClass
    public void SetUp(){
        adder = new AdderMultithreaded();
    }

    @DataProvider(name = "adder")
    public Object[][] createDataForAdditionTest(){
        Data<Matrix<Integer>> data1 = new Data<>();
        data1.put(new Matrix<>(new Integer[][]{
                new Integer[]{1, 2, 3},
                new Integer[]{4, 5, 6},
                new Integer[]{7, 8, 9},
        }));
        data1.put(new Matrix<>(new Integer[][]{
                new Integer[]{1, 2, 3},
                new Integer[]{4, 5, 6},
                new Integer[]{7, 8, 9},
        }));

        Data<Matrix<Integer>> data2 = new Data<>();
        data2.put(new Matrix<>(new Integer[][]{
                new Integer[]{-1, -1},
                new Integer[]{-1, -1},
        }));
        data2.put(new Matrix<>(new Integer[][]{
                new Integer[]{1, 1},
                new Integer[]{1, 1},
        }));
        return
                new Object[][]{
                        {data1, new Matrix<>(new Integer[][]{
                                new Integer[]{2, 4, 6},
                                new Integer[]{8, 10, 12},
                                new Integer[]{14, 16, 18},
                        })},
                        {data2, new Matrix<>(new Integer[][]{
                                new Integer[]{0, 0},
                                new Integer[]{0, 0}
                        })},
                };
    }

    @Test(description = "positive scenario for matrix adder",
            dataProvider = "adder")
    public void additionTest(Data<Matrix<Integer>> arg, Matrix<Integer> expected) throws ServiceException {
        assertEquals(adder.addition(arg.getElement(0), arg.getElement(1)), expected);
    }
}
