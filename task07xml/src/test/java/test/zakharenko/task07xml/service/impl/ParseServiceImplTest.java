package test.zakharenko.task07xml.service.impl;

import by.zakharenko.task07xml.service.ParseService;
import by.zakharenko.task07xml.service.exception.ServiceException;
import by.zakharenko.task07xml.service.factory.ServiceFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;

import static org.testng.Assert.assertEquals;

public class ParseServiceImplTest {
    private ParseService parseService;

    @BeforeClass
    public void init(){
        parseService = ServiceFactory.getInstance().getParseService();
    }

    @DataProvider(name = "parseReview")
    public Object[][] parseReviewData(){
        return
                new Object[][]{
                        {"xml_files/reviews0.xml", 0},
                        {"xml_files/reviews5.xml", 5},
                        {"xml_files/reviews3.xml", 3}
                };
    }

    @Test(description = "positive scenario for parseDOMReview",
            dataProvider = "parseReview")
    public void parseDOMReviewTest(String path, int expected) throws ServiceException, FileNotFoundException {
        assertEquals(
                parseService.parseDomReview(
                        new FileInputStream(Objects.requireNonNull(getClass().getClassLoader().getResource(path)).getFile())
                ).size(),
                expected
        );
    }

    @Test(description = "negative scenario for parseDOMReview",
            expectedExceptions = ServiceException.class)
    public void parseDOMReviewExceptionTest() throws ServiceException, FileNotFoundException {
        parseService.parseDomReview(
                new FileInputStream(Objects.requireNonNull(getClass().getClassLoader().getResource("xml_files/reviews_not_correct.xml")).getFile())
        );
    }

    @Test(description = "positive scenario for parseSAXReview",
            dataProvider = "parseReview")
    public void parseSAXReviewTest(String path, int expected) throws ServiceException, FileNotFoundException {
        assertEquals(
                parseService.parseSAXReview(
                        new FileInputStream(Objects.requireNonNull(getClass().getClassLoader().getResource(path)).getFile())
                ).size(),
                expected
        );
    }

    @Test(description = "negative scenario for parseSAXReview",
            expectedExceptions = ServiceException.class)
    public void parseSAXReviewExceptionTest() throws ServiceException, FileNotFoundException {
        parseService.parseSAXReview(
                new FileInputStream(Objects.requireNonNull(getClass().getClassLoader().getResource("xml_files/reviews_not_correct.xml")).getFile())
        );
    }

    @Test(description = "positive scenario for parseStAXReview",
            dataProvider = "parseReview")
    public void parseStAXReviewTest(String path, int expected) throws ServiceException, FileNotFoundException {
        assertEquals(
                parseService.parseStAXReview(
                        new FileInputStream(Objects.requireNonNull(getClass().getClassLoader().getResource(path)).getFile())
                ).size(),
                expected
        );
    }

    @Test(description = "negative scenario for parseStAXReview",
            expectedExceptions = ServiceException.class)
    public void parseStAXReviewExceptionTest() throws ServiceException, FileNotFoundException {
        parseService.parseStAXReview(
                new FileInputStream(Objects.requireNonNull(getClass().getClassLoader().getResource("xml_files/reviews_not_correct.xml")).getFile())
        );
    }
}
