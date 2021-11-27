package test.zakharanka.task01javabasic.service;

import by.zakharanka.task01javabasic.controller.task.linearprogramimpl.CheckAreaCircleImpl;
import by.zakharanka.task01javabasic.service.ConvertService;
import by.zakharanka.task01javabasic.service.DataValidationService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DataValidationServiceTest {

    private DataValidationService dataValidationService;

    @BeforeClass
    public void setUp() {
        dataValidationService = new DataValidationService();
    }

    @DataProvider(name = "identifierValidation")
    public Object[][] createDataForIdentifierValidationTest(){
        return
                new Object[][]{
                        {"String", true},
                        {"_String", true},
                        {"9String", false},
                        {"_St ring", false},
                        {"_Str9ing", true},
                        {"_String ", false},
                        {"_String*", false},
                        {"&String", false},
                };
    }

    @Test(description = "positive scenario for expressionTask8",
            dataProvider = "identifierValidation")
    public void identifierValidationTest(String arg, boolean expected){
        boolean actual = dataValidationService.identifierValidation(arg);
        assertEquals(actual, expected);
    }
}
