package by.zakharenko.task06composite.service.parser;

import by.zakharenko.task06composite.entity.TextComponent;
import by.zakharenko.task06composite.entity.TextComposite;
import by.zakharenko.task06composite.service.exception.ServiceException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParserToParagraph extends BaseParser{
    private static final String PARAGRAPH_DELIMITER = "(\\r\\n)+\\s+";

    public ParserToParagraph(Parser newNext) {
        super(newNext);
        if(newNext == null){
            super.setNext(new ParserToSymbols());
        }
    }

    /**
     * Parses the text into paragraphs and calls the next parser from the chain of responsibility
     * @param text text to parse
     * @return Composite element that stores paragraphs
     */
    @Override
    public TextComponent parse(String text) throws ServiceException {
        TextComponent result = new TextComposite();
        List<String> listParagraph = parseToParagraph(text);
        for(String paragraph: listParagraph) {
            TextComponent component = super.getNext().parse(paragraph);
            component.setDelimiter("\r\n\t");
            result.add(component);
        }
        return result;
    }

    private List<String> parseToParagraph(String text){
        return Arrays.stream(text.split(PARAGRAPH_DELIMITER)).filter(x -> !x.equals("")).collect(Collectors.toList());
    }
}
