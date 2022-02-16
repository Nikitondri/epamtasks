package test.zakharenko.task06composite.service.parser;

import by.zakharenko.task06composite.entity.SymbolLeaf;
import by.zakharenko.task06composite.entity.TextComponent;
import by.zakharenko.task06composite.entity.TextComposite;
import by.zakharenko.task06composite.service.exception.ServiceException;
import by.zakharenko.task06composite.service.parser.Parser;
import by.zakharenko.task06composite.service.parser.ParserToSymbols;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ParserToSymbolsTest {
    private Parser parser;

    @BeforeClass
    public void init(){
        parser = new ParserToSymbols();
    }

    @DataProvider(name = "parse")
    public Object[][] parseData(){
        TextComponent word = new TextComposite("");
        TextComponent symbol1 = new SymbolLeaf('H');
        TextComponent symbol2 = new SymbolLeaf('e');
        TextComponent symbol3 = new SymbolLeaf('l');
        TextComponent symbol4 = new SymbolLeaf('l');
        TextComponent symbol5 = new SymbolLeaf('o');
        word.add(symbol1);
        word.add(symbol2);
        word.add(symbol3);
        word.add(symbol4);
        word.add(symbol5);
        return
                new Object[][]{
                        {"Hello", word}
                };
    }

    @Test(description = "positive scenario for parse",
            dataProvider = "parse")
    public void parseTest(String arg, TextComponent expected) throws ServiceException {
        assertEquals(parser.parse(arg).toString(), expected.toString());
    }
}
