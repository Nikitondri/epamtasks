package test.zakharanka.task02array.dal.reader;

import by.zakharanka.task02array.dal.exception.DalException;
import by.zakharanka.task02array.dal.reader.ArrayReader;
import by.zakharanka.task02array.dal.util.FileResourcesUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertEquals;

public class ArrayReaderTest {

    @DataProvider(name = "readArray")
    public Object[][] createDataForAdditionTest(){
        return
                new Object[][]{
                        {"arrayreadertestfile/array.txt", "1 2 3 4 5 6 7"},
                        {"arrayreadertestfile/empty.txt", "by.zakharanka.task02array.dal.exception.DalException: Not Correct file"},
                        {"arrayreadertestfile/none.txt", "by.zakharanka.task02array.dal.exception.DalException: file not found!"},
                        {"arrayreadertestfile/oneItemArray.txt", "1"},
                        {"arrayreadertestfile/matrix.txt", "1 2 3"},
                };
    }

    @Test(description = "scenario for readArray",
            dataProvider = "readArray")
    public void readArrayTest(String arg, String expected){
        FileResourcesUtils fileResourcesUtils = new FileResourcesUtils();
        try {
            File file = fileResourcesUtils.getFileFromResource(arg);
            ArrayReader arrayReader = new ArrayReader(file.getPath());
            String actual = arrayReader.readArray();
            assertEquals(actual, expected);
        } catch (DalException e){
            assertEquals(e.toString(), expected);
        }
    }
}
