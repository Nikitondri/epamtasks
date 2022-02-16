package test.zakharenko.task06composite.service.impl;

import by.zakharenko.task06composite.entity.SymbolLeaf;
import by.zakharenko.task06composite.entity.TextComponent;
import by.zakharenko.task06composite.entity.TextComposite;
import by.zakharenko.task06composite.service.TextService;
import by.zakharenko.task06composite.service.exception.ServiceException;
import by.zakharenko.task06composite.service.factory.ServiceFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TextServiceImplTest {

    private TextService textService;

    @BeforeClass
    public void init(){
        textService = ServiceFactory.getInstance().getTextService();
    }

    @DataProvider(name = "collectText")
    public Object[][] collectTextData(){
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
                        {paragraph1, "Paragraph 1."},
                        {paragraph2, "Paragraph 2!"},
                        {text, "\r\n\tParagraph 1.\r\n\tParagraph 2!"},
                };
    }

    @Test(description = "positive scenario for collectText",
            dataProvider = "collectText")
    public void collectText(TextComponent component, String expected) throws ServiceException {
        assertEquals(textService.collectText(component), expected);
    }
}
