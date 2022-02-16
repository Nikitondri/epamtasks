package test.zakharenko.task06composite.service.converter.impl;

import by.zakharenko.task06composite.service.converter.rpn.ConverterRPN;
import by.zakharenko.task06composite.service.converter.rpn.impl.ConverterRPNImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ConverterRPNImplTest {
    private ConverterRPN converter;

    @BeforeClass
    public void init(){
        converter = new ConverterRPNImpl();
    }

    @DataProvider(name = "convert")
    public Object[][] convertData(){
        return
                new Object[][]{
                        {"4&5", "4 5 &"},
                        {"4&5|3^23", "4 5 & 3 23 ^ |"},
                        {"4&(5|3)^23", "4 5 3 | & 23 ^"},
                        {"(~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78", "71 ~ 2 3 & 3 2 1 2 >> & 2 | 2 & | | 10 2 & | & 78 |"},
                };
    }

    @Test(description = "positive scenario for convert",
            dataProvider = "convert")
    public void convertTest(String arg, String expected) {
        assertEquals(converter.convert(arg), expected);
    }
}
