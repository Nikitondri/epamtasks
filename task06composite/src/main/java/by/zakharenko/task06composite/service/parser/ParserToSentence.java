package by.zakharenko.task06composite.service.parser;

import by.zakharenko.task06composite.entity.TextComponent;
import by.zakharenko.task06composite.entity.TextComposite;
import by.zakharenko.task06composite.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserToSentence extends BaseParser{
    private static final String SENTENCE_REGEX = "([^.!?])+[.!?]+";

    public ParserToSentence(Parser newNext) {
        super(newNext);
        if(newNext == null){
            super.setNext(new ParserToSymbols());
        }
    }

    @Override
    public TextComponent parse(String text) throws ServiceException {
        TextComponent result = new TextComposite();
        List<String> listSentence = parseToSentence(text);
        for(String sentence: listSentence){
            TextComponent component = super.getNext().parse(sentence);
            component.setDelimiter(" ");
            result.add(component);
        }
        return result;
    }

    private List<String> parseToSentence(String text){
        List<String> sentences = new ArrayList<>();
        Pattern pattern = Pattern.compile(SENTENCE_REGEX);
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            sentences.add(matcher.group().trim());
        }
        return sentences;
    }

}
