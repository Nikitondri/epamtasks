package by.zakharenko.task06composite.service.impl;

import by.zakharenko.task06composite.dao.ReaderDAO;
import by.zakharenko.task06composite.dao.exception.DAOException;
import by.zakharenko.task06composite.dao.factory.DAOFactory;
import by.zakharenko.task06composite.entity.TextComponent;
import by.zakharenko.task06composite.entity.TextComposite;
import by.zakharenko.task06composite.service.TextService;
import by.zakharenko.task06composite.service.collector.TextComponentCollector;
import by.zakharenko.task06composite.service.collector.impl.TextComponentCollectorImpl;
import by.zakharenko.task06composite.service.comparator.TextComponentComparator;
import by.zakharenko.task06composite.service.comparator.impl.LexemeComparatorImpl;
import by.zakharenko.task06composite.service.comparator.impl.ParagraphComparatorImpl;
import by.zakharenko.task06composite.service.comparator.impl.WordComparatorImpl;
import by.zakharenko.task06composite.service.exception.ServiceException;
import by.zakharenko.task06composite.service.parser.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TextServiceImpl implements TextService {

    /**
     * assembles the text into a string from the composite structure
     * @param component composite root element
     * @return A String containing text
     */
    @Override
    public String collectText(TextComponent component) throws ServiceException {
        TextComponentCollector collector = new TextComponentCollectorImpl();
        return collector.collect(component);
    }

    /**
     * sorts the words in the text by length, taking into
     * account that the words in the composite structure have a nesting level of 4
     * @param component composite root element
     * @return A String containing result
     */
    @Override
    public TextComponent sortWord(TextComponent component) {
        TextComponent result = new TextComposite();
        TextComponentComparator comparator = new WordComparatorImpl();
        for (TextComponent paragraph: component.getComponents()){
            TextComponent newParagraph = new TextComposite("");
            for(TextComponent sentence: paragraph.getComponents()){
                TextComponent newSentence = new TextComposite("\n");
                List<TextComponent> words = findWords(sentence);
                List<TextComponent> resultWords = new ArrayList<>(words).stream().sorted(comparator).collect(Collectors.toList());
                for(TextComponent word: resultWords){
                    newSentence.add(word);
                    word.setDelimiter(" ");
                }
                newParagraph.add(newSentence);
            }
            result.add(newParagraph);
        }
        return result;
    }

    private List<TextComponent> findWords(TextComponent sentence){
        List<TextComponent> listWord = new ArrayList<>();
        for(TextComponent lexeme: sentence.getComponents()){
            for(TextComponent component: lexeme.getComponents()){
                if(component instanceof TextComposite){
                    listWord.add(component);
                }
            }
        }
        return listWord;
    }

    /**
     * sorts the words paragraphs by the number of sentences,
     * taking into account that the paragraphs in the composite structure have a nesting level of 1
     * @param component composite root element
     * @return A String containing result
     */
    @Override
    public TextComponent sortParagraph(TextComponent component) {
        TextComponent result = new TextComposite();
        TextComponentComparator comparator = new ParagraphComparatorImpl();
        List<TextComponent> resultParagraphs = new ArrayList<>(component.getComponents()).stream().sorted(comparator).collect(Collectors.toList());
        for(TextComponent textComponent: resultParagraphs){
            result.add(textComponent);
        }
        return result;
    }

    /**
     * sorts the tokens in descending order of the number of occurrences of the character,
     * taking into account that the tokens in the composite structure have a nesting level of 3
     * @param component composite root element
     * @return A String containing result
     */
    @Override
    public TextComponent sortLexemesByOrder(TextComponent component, char symbol) {
        TextComponent result = new TextComposite();
        TextComponentComparator comparator = new LexemeComparatorImpl(symbol);
        List<TextComponent> lexemes = new ArrayList<>();
        for(TextComponent paragraph: component.getComponents()){
            for(TextComponent sentence: paragraph.getComponents()) {
                lexemes.addAll(sentence.getComponents());
            }
        }
        List<TextComponent> resultLexemes = new ArrayList<>(lexemes).stream().
                sorted(comparator).
                collect(Collectors.toList());
        for (TextComponent lexeme : resultLexemes) {
            lexeme.setDelimiter("\n");
            result.add(lexeme);
        }
        return result;
    }

    /**
     * performs the transformation of string text into a composite
     * structure using parsers that implement a chain of responsibilities
     * @param path path to text file
     * @return composite root element
     */
    @Override
    public TextComponent parseTextFromFile(String path) throws ServiceException {
        ReaderDAO reader = DAOFactory.getInstance().getReaderDAOTxt();
        Parser parser = new ParserToParagraph(new ParserToSentence(new ParserToLexeme(new ParserToWord(new ParserToSymbols()))));
        try {
            return parser.parse(reader.readFile(path));
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
