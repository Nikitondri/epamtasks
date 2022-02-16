package by.zakharenko.task06composite.service.parser;

import by.zakharenko.task06composite.entity.SymbolLeaf;
import by.zakharenko.task06composite.entity.TextComponent;
import by.zakharenko.task06composite.entity.TextComposite;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParserToSymbols extends BaseParser{
    private static final String SYMBOL_DELIMITER = "";

    public ParserToSymbols() {
        super(null);
    }

    /**
     * the final parser from the chain of responsibilities, which parses the text into characters
     * @param text text to parse
     * @return Composite element that stores symbols
     */
    @Override
    public TextComponent parse(String text) {
        TextComponent result = new TextComposite();
        List<String> listSymbols = parseToSymbols(text);
        for(String symbol: listSymbols){
            TextComponent leaf = new SymbolLeaf(symbol.charAt(0));
            result.add(leaf);
        }
        return result;
    }

    private List<String> parseToSymbols(String text){
        return Arrays.stream(text.split(SYMBOL_DELIMITER)).collect(Collectors.toList());
    }
}
