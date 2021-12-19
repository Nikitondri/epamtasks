package test.zakharanka.task02array.dal.reader;

import by.zakharanka.task02array.dal.exception.DalException;
import by.zakharanka.task02array.dal.reader.MatrixReader;
import by.zakharanka.task02array.dal.util.FileResourcesUtils;
import by.zakharanka.task02array.entity.Data;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertEquals;

public class MatrixReaderTest {

    @DataProvider(name = "readMatrix")
    public Object[][] createDataForReadMatrixTest(){
        Data<String> data1 = new Data<>();
        data1.put("1 2 3");
        data1.put("4 5 6");
        data1.put("7 8 9");
        return
                new Object[][]{
                        {"matrixreadertestfile/matrix.txt", data1.toString()},
                        {"matrixreadertestfile/notCorrectSize.txt", "by.zakharanka.task02array.dal.exception.DalException: Not correct size Matrix"},
                        {"matrixreadertestfile/none.txt", "by.zakharanka.task02array.dal.exception.DalException: file not found!"},
                        {"matrixreadertestfile/empty.txt", "by.zakharanka.task02array.dal.exception.DalException: file not found!"},
                };
    }

    @Test(description = "scenario for readMatrix",
            dataProvider = "readMatrix")
    public void readMatrixTest(String arg, String expected){
        FileResourcesUtils fileResourcesUtils = new FileResourcesUtils();
        try {
            File file = fileResourcesUtils.getFileFromResource(arg);
            MatrixReader matrixReader = new MatrixReader(file.getPath());
            Data<String> actual = matrixReader.readMatrix();
            assertEquals(actual.toString(), expected);
        } catch (DalException e){
            assertEquals(e.toString(), expected);
        }
    }
}
