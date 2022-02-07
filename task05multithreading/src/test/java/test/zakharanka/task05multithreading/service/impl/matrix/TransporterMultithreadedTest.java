package test.zakharanka.task05multithreading.service.impl.matrix;

import by.zakharenko.task05multithreading.entity.Matrix;
import by.zakharenko.task05multithreading.service.exception.ServiceException;
import by.zakharenko.task05multithreading.service.impl.matrix.TransporterMultithreaded;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TransporterMultithreadedTest {

    private TransporterMultithreaded transporter;

    @BeforeClass
    public void SetUp(){
        transporter = new TransporterMultithreaded();
    }

    @DataProvider(name = "transposition")
    public Object[][] createDataForTranspositionTest(){
        return
                new Object[][]{
                        {       new Matrix<>(new Integer[][]{
                                new Integer[]{0, 0, 0},
                                new Integer[]{0, 0, 0},
                                new Integer[]{0, 0, 0},
                        }),
                                new Matrix<>(new Integer[][]{
                                        new Integer[]{0, 0, 0},
                                        new Integer[]{0, 0, 0},
                                        new Integer[]{0, 0, 0},
                                })
                        },
                        {       new Matrix<>(new Integer[][]{
                                new Integer[]{1, 2, 3},
                                new Integer[]{4, 5, 6},
                                new Integer[]{7, 8, 9},
                        }),
                                new Matrix<>(new Integer[][]{
                                        new Integer[]{1, 4, 7},
                                        new Integer[]{2, 5, 8},
                                        new Integer[]{3, 6, 9},
                                })
                        },
                };
    }

    @Test(description = "positive scenario for matrix transposition",
            dataProvider = "transposition")
    public void transpositionTest(Matrix<Integer> arg, Matrix<Integer> expected) throws ServiceException {
        assertEquals(transporter.transposition(arg), expected);
    }
}
