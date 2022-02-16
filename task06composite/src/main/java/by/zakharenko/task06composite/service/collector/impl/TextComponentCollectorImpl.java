package by.zakharenko.task06composite.service.collector.impl;

import by.zakharenko.task06composite.entity.SymbolLeaf;
import by.zakharenko.task06composite.entity.TextComponent;
import by.zakharenko.task06composite.service.collector.TextComponentCollector;
import by.zakharenko.task06composite.service.converter.rpn.ConverterRPN;
import by.zakharenko.task06composite.service.converter.rpn.impl.ConverterRPNImpl;
import by.zakharenko.task06composite.service.exception.ServiceException;
import by.zakharenko.task06composite.service.interpreter.math.Client;
import by.zakharenko.task06composite.service.parser.Parser;
import by.zakharenko.task06composite.service.parser.ParserToSymbols;
import by.zakharenko.task06composite.service.parser.ParserToWord;

/** class for collecting text into a {@code String} from a composite structure */
public class TextComponentCollectorImpl implements TextComponentCollector {

    /**
     * This method recursively assembles the text from the composite
     * structure using the tree traversal method, while calculating
     * mathematical expressions
     * @see TextComponent
     * @see Client
     * @see ConverterRPN
     * @param component root component of the composite structure
     * @return {@code String} object stored text
     */
    @Override
    public String collect(TextComponent component) throws ServiceException {
        return collectText(component);
    }

    private String collectText(TextComponent component) throws ServiceException {
        StringBuilder result = new StringBuilder();
        if(component instanceof SymbolLeaf){
            return Character.toString(component.value());
        } else {
            for (TextComponent childesComponent : component.getComponents()) {
                result.append(childesComponent.getDelimiter());
                if(childesComponent.toString().matches(ParserToWord.EXPRESSION_REGEX)){
                    result.append(collectText(calculateExpression(childesComponent)));
                } else {
                    result.append(collectText(childesComponent));
                }
            }
        }
        return result.toString();
    }

    private TextComponent calculateExpression(TextComponent component) throws ServiceException {
        ConverterRPN converter = new ConverterRPNImpl();
        Client interpreter = new Client(converter.convert(component.toString()));
        Parser parser = new ParserToSymbols();
        return parser.parse(interpreter.calculate().toString());
    }
}
