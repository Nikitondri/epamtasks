package by.zakharanka.task02array.service.impl.matrix;

import by.zakharanka.task02array.entity.Data;
import by.zakharanka.task02array.entity.Matrix;
import by.zakharanka.task02array.entity.exception.EntityException;
import by.zakharanka.task02array.service.creator.MatrixCreator;
import by.zakharanka.task02array.service.exception.ServiceException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AdderTest {

//    private Adder adder;
//
//    @BeforeClass
//    public void SetUp(){
//        adder = new Adder();
//    }
//
//    @DataProvider(name = "addition")
//
//    public Object[][] createDataForCheckMaxNumbersTest(){
//        Data<Matrix<Integer>> data1 = new Data<>();
//        Matrix<Integer> matrix11 = new Matrix<>(new Integer[][]{
//                new Integer[]{1 ,2, 3},
//                new Integer[]{4, 5, 6},
//                new Integer[]{7, 8, 9}});
//        Matrix<Integer> matrix12 = new Matrix<>(new Integer[][]{
//                new Integer[]{1 ,2, 3},
//                new Integer[]{4, 5, 6},
//                new Integer[]{7, 8, 9}});
//        data1.put(matrix11);
//        data1.put(matrix12);
//        Matrix<Integer> matrix13 = new Matrix<>(new Integer[][]{
//                new Integer[]{2 ,4, 6},
//                new Integer[]{8, 10, 12},
//                new Integer[]{14, 16, 18}});
//
//        Data<Matrix<Integer>> data2 = new Data<>();
//        Matrix<Integer> matrix21 = new Matrix<>(new Integer[][]{
//                new Integer[]{1, 2},
//                new Integer[]{3, 4}});
//        Matrix<Integer> matrix22 = new Matrix<>(new Integer[][]{
//                new Integer[]{1, 2},
//                new Integer[]{3, 4}});
//        data2.put(matrix21);
//        data2.put(matrix22);
//        Matrix<Integer> matrix23 = new Matrix<>(new Integer[][]{
//                new Integer[]{2, 4},
//                new Integer[]{6, 8}});
//        return
//                new Object[][]{
//                        {data1, matrix13},
//                        {data2, matrix23}
//                };
//    }
//
//    @Test(description = "positive scenario for checkMaxNumbers",
//            dataProvider = "addition")
//    public void checkMaxNumbersTest(Data<Matrix<> arg, Matrix<Integer> expected) throws ServiceException, EntityException {
//        Matrix matrix1 = arg.getElement(0);
//        Matrix matrix2 = arg.getElement(1);
//        Matrix actual = adder.addition(matrix1, matrix2);
//        assertEquals(actual.toString(), expected.toString());
//    }
}
