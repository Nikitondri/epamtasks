package test.zakharenko.task06composite.service.parser;

import by.zakharenko.task06composite.entity.SymbolLeaf;
import by.zakharenko.task06composite.entity.TextComponent;
import by.zakharenko.task06composite.entity.TextComposite;
import by.zakharenko.task06composite.service.exception.ServiceException;
import by.zakharenko.task06composite.service.parser.Parser;
import by.zakharenko.task06composite.service.parser.ParserToParagraph;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ParserToParagraphTest {
    private Parser parser;

    @BeforeClass
    public void init(){
        parser = new ParserToParagraph(null);
    }

    @DataProvider(name = "readFile")
    public Object[][] readFileData(){
        TextComponent text = new TextComposite();
        TextComponent paragraph1 = new TextComposite("\r\n\t");
        TextComponent paragraph2 = new TextComposite("\r\n\t");
        paragraph1.add(new SymbolLeaf('P'));
        paragraph1.add(new SymbolLeaf('a'));
        paragraph1.add(new SymbolLeaf('r'));
        paragraph1.add(new SymbolLeaf('a'));
        paragraph1.add(new SymbolLeaf('g'));
        paragraph1.add(new SymbolLeaf('r'));
        paragraph1.add(new SymbolLeaf('a'));
        paragraph1.add(new SymbolLeaf('p'));
        paragraph1.add(new SymbolLeaf('h'));
        paragraph1.add(new SymbolLeaf(' '));
        paragraph1.add(new SymbolLeaf('1'));
        paragraph1.add(new SymbolLeaf('.'));
        paragraph2.add(new SymbolLeaf('P'));
        paragraph2.add(new SymbolLeaf('a'));
        paragraph2.add(new SymbolLeaf('r'));
        paragraph2.add(new SymbolLeaf('a'));
        paragraph2.add(new SymbolLeaf('g'));
        paragraph2.add(new SymbolLeaf('r'));
        paragraph2.add(new SymbolLeaf('a'));
        paragraph2.add(new SymbolLeaf('p'));
        paragraph2.add(new SymbolLeaf('h'));
        paragraph2.add(new SymbolLeaf(' '));
        paragraph2.add(new SymbolLeaf('2'));
        paragraph2.add(new SymbolLeaf('!'));
        text.add(paragraph1);
        text.add(paragraph2);
        return
                new Object[][]{
                        {"Paragraph 1.\r\n\tParagraph 2!", text}
                };
    }

    @Test(description = "positive scenario for readFile",
            dataProvider = "readFile")
    public void additionTest(String arg, TextComponent expected) throws ServiceException {
        assertEquals(parser.parse(arg).toString(), expected.toString());
    }
}
