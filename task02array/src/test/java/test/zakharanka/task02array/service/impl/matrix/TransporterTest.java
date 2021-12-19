package test.zakharanka.task02array.service.impl.matrix;

import by.zakharanka.task02array.entity.Matrix;
import by.zakharanka.task02array.service.impl.matrix.Transporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TransporterTest {

    private Transporter transporter;

    @BeforeClass
    public void SetUp(){
        transporter = new Transporter();
    }

    @DataProvider(name = "transposition")
    public Object[][] createDataForSubtractionTest(){
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
    public void subtractionTest(Matrix<Integer> arg, Matrix<Integer> expected){
        assertEquals(transporter.transposition(arg).toString(), expected.toString());
    }
}
