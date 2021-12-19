package test.zakharanka.task02array.service.impl.matrix;

import by.zakharanka.task02array.entity.Data;
import by.zakharanka.task02array.entity.Matrix;
import by.zakharanka.task02array.service.exception.ServiceException;
import by.zakharanka.task02array.service.impl.matrix.Multiplier;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MultiplierTest {
    private Multiplier multiplier;

    @BeforeClass
    public void SetUp(){
        multiplier = new Multiplier();
    }

    @DataProvider(name = "multiply")
    public Object[][] createDataForMultiplyTest(){
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
                                new Integer[]{30, 36, 42},
                                new Integer[]{66, 81, 96},
                                new Integer[]{102, 126, 150},
                        })},
                        {data2, new Matrix<>(new Integer[][]{
                                new Integer[]{-2, -2},
                                new Integer[]{-2, -2}
                        })},
                };
    }

    @Test(description = "positive scenario for matrix multiply",
            dataProvider = "multiply")
    public void multiplyTest(Data<Matrix<Integer>> arg, Matrix<Integer> expected) throws ServiceException {
        assertEquals(multiplier.multiply(arg.getElement(0), arg.getElement(1)).toString(), expected.toString());
    }
}
