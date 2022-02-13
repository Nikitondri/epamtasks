package by.zakharenko.task06composite.service.parser;

import by.zakharenko.task06composite.entity.SymbolLeaf;
import by.zakharenko.task06composite.entity.TextComponent;
import by.zakharenko.task06composite.entity.TextComposite;
import by.zakharenko.task06composite.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserToWord extends BaseParser{
    public static final String EXPRESSION_REGEX = "[\\d()~][\\d+\\-<>&^|~()]*[\\d()]";
    public static final String WORD_REGEX = "[\\w]+";
    public static final String MARK_REGEX = "[()\\-.,!?:;'\"]";

    public ParserToWord(Parser newNext) {
        super(newNext);
        if(newNext == null){
            super.setNext(new ParserToSymbols());
        }
    }

    @Override
    public TextComponent parse(String text) throws ServiceException {
        TextComponent result = new TextComposite();
        List<String> listWord = parseToWord(text);
        for(String word: listWord){
            if(word.matches(WORD_REGEX + "|" + EXPRESSION_REGEX)) {
                TextComponent component = super.getNext().parse(word);
                component.setDelimiter("");
                result.add(component);
            } else {
                char[] arrMark = word.toCharArray();
                for(char ch: arrMark){
                    result.add(new SymbolLeaf(ch));
                }
            }
        }
        return result;
    }

    private List<String> parseToWord(String text){
        List<String> words = new ArrayList<>();
        Pattern pattern = Pattern.compile(EXPRESSION_REGEX + "|" +WORD_REGEX + "|" +MARK_REGEX);
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            words.add(matcher.group());
        }
        return words;
    }
}
