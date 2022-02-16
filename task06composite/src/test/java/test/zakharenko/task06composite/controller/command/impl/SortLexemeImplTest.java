package test.zakharenko.task06composite.controller.command.impl;

import by.zakharenko.task06composite.controller.command.Command;
import by.zakharenko.task06composite.controller.command.CommandName;
import by.zakharenko.task06composite.controller.command.impl.SortLexemeImpl;
import by.zakharenko.task06composite.controller.exception.ControllerException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class SortLexemeImplTest {

    private Command command;

    @BeforeClass
    public void init(){
        command = new SortLexemeImpl();
    }

    @DataProvider(name = "execute")
    public Object[][] executeData(){
        List<String> list1 = new ArrayList<>();
        list1.add(CommandName.COLLECT_TEXT.toString());
        list1.add("filetest/test_text1.txt");
        list1.add("a");
        Map<Boolean, String> result = new HashMap<>();
        result.put(true, "\nalso\n" +
                "essentially\n" +
                "has\n" +
                "leap\n" +
                "remaining\n" +
                "unchanged.\n" +
                "(five)\n" +
                "-\n" +
                "52\n" +
                "3\n" +
                "but\n" +
                "centuries,\n" +
                "electronic\n" +
                "into\n" +
                "It\n" +
                "not\n" +
                "only\n" +
                "survived\n" +
                "the\n" +
                "typesetting,\n" +
                "9");
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
