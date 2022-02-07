package test.zakharanka.task05multithreading.service.impl.matrix;

import by.zakharenko.task05multithreading.entity.Data;
import by.zakharenko.task05multithreading.entity.Matrix;
import by.zakharenko.task05multithreading.service.exception.ServiceException;
import by.zakharenko.task05multithreading.service.impl.matrix.SubtractorMultithreaded;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubtractorMultithreadedTest {
    private SubtractorMultithreaded subtractor;

    @BeforeClass
    public void SetUp(){
        subtractor = new SubtractorMultithreaded();
    }

    @DataProvider(name = "subtraction")
    public Object[][] createDataForSubtractionTest(){
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
                                new Integer[]{0, 0, 0},
                                new Integer[]{0, 0, 0},
                                new Integer[]{0, 0, 0},
                        })},
                        {data2, new Matrix<>(new Integer[][]{
                                new Integer[]{-2, -2},
                                new Integer[]{-2, -2}
                        })},
                };
    }

    @Test(description = "positive scenario for matrix subtraction",
            dataProvider = "subtraction")
    public void subtractionTest(Data<Matrix<Integer>> arg, Matrix<Integer> expected) throws ServiceException {
        assertEquals(subtractor.subtract(arg.getElement(0), arg.getElement(1)), expected);
    }
}
