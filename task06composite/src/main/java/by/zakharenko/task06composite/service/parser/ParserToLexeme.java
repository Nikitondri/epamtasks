package by.zakharenko.task06composite.service.parser;

import by.zakharenko.task06composite.entity.TextComponent;
import by.zakharenko.task06composite.entity.TextComposite;
import by.zakharenko.task06composite.service.exception.ServiceException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParserToLexeme extends BaseParser{
    private static final String LEXEME_DELIMITER = "\\s+";

    public ParserToLexeme(Parser newNext) {
        super(newNext);
        if(newNext == null){
            super.setNext(new ParserToSymbols());
        }
    }

    /**
     * Parses the text into lexemes and calls the next parser from the chain of responsibility
     * @param text text to parse
     * @return Composite element that stores lexemes
     */
    @Override
    public TextComponent parse(String text) throws ServiceException {
        TextComponent result = new TextComposite();
        List<String> listLexeme = parseToLexeme(text);
        for(String lexeme: listLexeme){
            TextComponent component = super.getNext().parse(lexeme);
            component.setDelimiter(" ");
            result.add(component);
        }
        return result;
    }

    private List<String> parseToLexeme(String text){
        return Arrays.stream(text.split(LEXEME_DELIMITER)).collect(Collectors.toList());
    }
}
