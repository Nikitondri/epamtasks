package test.zakharenko.task06composite.controller.command.impl;

import by.zakharenko.task06composite.controller.command.Command;
import by.zakharenko.task06composite.controller.command.CommandName;
import by.zakharenko.task06composite.controller.command.impl.SortWordImpl;
import by.zakharenko.task06composite.controller.exception.ControllerException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class SortWordImplTest {

    private Command command;

    @BeforeClass
    public void init(){
        command = new SortWordImpl();
    }

    @DataProvider(name = "execute")
    public Object[][] executeData(){
        List<String> list1 = new ArrayList<>();
        list1.add(CommandName.COLLECT_TEXT.toString());
        list1.add("filetest/test_text1.txt");
        Map<Boolean, String> result = new HashMap<>();
        result.put(true, "\n It has not but the only five also leap into 52 3 survived centuries remaining unchanged electronic 9 typesetting essentially");
        return
                new Object[][]{
                        {list1, result}
                };
    }

    @Test(description = "positive scenario for execute",
            dataProvider = "execute")
    public void executeTest(List<String> arg, Map<Boolean, String> expected) throws ControllerException {
        assertEquals(command.execute(arg), expected);
    }
}
