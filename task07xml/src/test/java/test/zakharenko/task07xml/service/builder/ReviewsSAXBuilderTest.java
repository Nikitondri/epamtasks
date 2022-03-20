package test.zakharenko.task07xml.service.builder;

import by.zakharenko.task07xml.service.builder.AbstractBuilder;
import by.zakharenko.task07xml.service.builder.ReviewsSAXBuilder;
import by.zakharenko.task07xml.service.exception.ServiceException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;

import static org.testng.Assert.assertEquals;

public class ReviewsSAXBuilderTest {
    @DataProvider(name = "getListReview")
    public Object[][] getListReviewData(){
        return
                new Object[][]{
                        {"xml_files/reviews5.xml", 5},
                        {"xml_files/reviews3.xml", 3},
                        {"xml_files/reviews0.xml", 0}
                };
    }

    @Test(description = "positive scenario for getListReview SAX parser",
            dataProvider = "getListReview")
    public void getListReviewTest(String path, int expected) throws FileNotFoundException, ServiceException {
        AbstractBuilder parser = new ReviewsSAXBuilder();
        parser.buildListReview(new FileInputStream(Objects.requireNonNull(getClass().getClassLoader().getResource(path)).getFile()));
        assertEquals(parser.getListReview().size(), expected);
    }
}
