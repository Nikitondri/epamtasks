package test.zakharenko.task06composite.dao.impl;

import by.zakharenko.task06composite.dao.ReaderDAO;
import by.zakharenko.task06composite.dao.exception.DAOException;
import by.zakharenko.task06composite.dao.factory.DAOFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ReaderDaoTxtImplTest {

    private ReaderDAO readerTxtDAO;

    @BeforeClass
    public void init(){
        readerTxtDAO = DAOFactory.getInstance().getReaderDAOTxt();
    }

    @DataProvider(name = "readFile")
    public Object[][] readFileData(){
        return
                new Object[][]{
                        {"filetest/testfile1.txt", "I won’t beg for your love: it’s laid\r\n" +
                                "Safely to rest, let the earth settle…"},
                        {"filetest/emptyfile.txt", ""},
                        {"filetest/testfile2.txt", "And looked down one as far as I could\r\n" +
                                "To where it bent in the undergrowth.\r\n" +
                                "\r\n" +
                                "Then took the other, as just as fair,\r\n" +
                                "And having perhaps the better claim"}
                };
    }

    @Test(description = "positive scenario for readFile",
            dataProvider = "readFile")
    public void readFileTest(String path, String expected) throws DAOException {
        assertEquals(readerTxtDAO.readFile(path), expected);
    }

    @Test(description = "negative scenario for readFile",
            expectedExceptions = DAOException.class)
    public void readFileExceptionTest() throws DAOException {
        readerTxtDAO.readFile("filetest/incorrectPath.txt");
    }
}
