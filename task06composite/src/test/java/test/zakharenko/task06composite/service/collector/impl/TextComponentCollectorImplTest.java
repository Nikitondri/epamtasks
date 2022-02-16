package test.zakharenko.task06composite.service.collector.impl;

import by.zakharenko.task06composite.entity.SymbolLeaf;
import by.zakharenko.task06composite.entity.TextComponent;
import by.zakharenko.task06composite.entity.TextComposite;
import by.zakharenko.task06composite.service.collector.TextComponentCollector;
import by.zakharenko.task06composite.service.collector.impl.TextComponentCollectorImpl;
import by.zakharenko.task06composite.service.exception.ServiceException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TextComponentCollectorImplTest {
    private TextComponentCollector collector;

    @BeforeClass
    public void init(){
        collector = new TextComponentCollectorImpl();
    }

    @DataProvider(name = "collect")
    public Object[][] collectData(){
        //Hello, I am Nikita!
        TextComponent sentence = new TextComposite();
        TextComponent lexeme1 = new TextComposite(" ");
        TextComponent lexeme2 = new TextComposite(" ");
        TextComponent lexeme3 = new TextComposite(" ");
        TextComponent lexeme4 = new TextComposite(" ");
        TextComponent word1 = new TextComposite("");
        TextComponent symbol1Word1 = new SymbolLeaf('H');
        TextComponent symbol2Word1 = new SymbolLeaf('e');
        TextComponent symbol3Word1 = new SymbolLeaf('l');
        TextComponent symbol4Word1 = new SymbolLeaf('l');
        TextComponent symbol5Word1 = new SymbolLeaf('o');
        word1.add(symbol1Word1);
        word1.add(symbol2Word1);
        word1.add(symbol3Word1);
        word1.add(symbol4Word1);
        word1.add(symbol5Word1);
        TextComponent mark1 = new SymbolLeaf(',');
        lexeme1.add(word1);
        lexeme1.add(mark1);
        TextComponent word2 = new TextComposite("");
        TextComponent symbol1Word2 = new SymbolLeaf('I');
        word2.add(symbol1Word2);
        lexeme2.add(word2);
        TextComponent word3 = new TextComposite("");
        TextComponent symbol1Word3 = new SymbolLeaf('a');
        TextComponent symbol2Word3 = new SymbolLeaf('m');
        word3.add(symbol1Word3);
        word3.add(symbol2Word3);
        lexeme3.add(word3);
        TextComponent word4 = new TextComposite("");
        TextComponent symbol1Word4 = new SymbolLeaf('N');
        TextComponent symbol2Word4 = new SymbolLeaf('i');
        TextComponent symbol3Word4 = new SymbolLeaf('k');
        TextComponent symbol4Word4 = new SymbolLeaf('i');
        TextComponent symbol5Word4 = new SymbolLeaf('t');
        TextComponent symbol6Word4 = new SymbolLeaf('a');
        TextComponent mark2 = new SymbolLeaf('!');
        word4.add(symbol1Word4);
        word4.add(symbol2Word4);
        word4.add(symbol3Word4);
        word4.add(symbol4Word4);
        word4.add(symbol5Word4);
        word4.add(symbol6Word4);
        lexeme4.add(word4);
        lexeme4.add(mark2);
        sentence.add(lexeme1);
        sentence.add(lexeme2);
        sentence.add(lexeme3);
        sentence.add(lexeme4);
        return
                new Object[][]{
                        {lexeme1, "Hello,"},
                        {word1, "Hello"},
                        {lexeme2, "I"},
                        {word4, "Nikita"},
                        {lexeme4, "Nikita!"},
                        {lexeme3, "am"},
                        {sentence, " Hello, I am Nikita!"},
                };
    }

    @Test(description = "positive scenario for collect",
            dataProvider = "collect")
    public void collectTest(TextComponent arg, String expected) throws ServiceException {
        assertEquals(collector.collect(arg), expected);
    }
}
