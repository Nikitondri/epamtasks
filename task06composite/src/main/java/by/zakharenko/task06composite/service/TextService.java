package by.zakharenko.task06composite.service;

import by.zakharenko.task06composite.entity.TextComponent;
import by.zakharenko.task06composite.service.exception.ServiceException;

public interface TextService {
    String collectText(TextComponent component) throws ServiceException;
    TextComponent parseTextFromFile(String path) throws ServiceException;
    TextComponent sortWord(TextComponent component);
    TextComponent sortParagraph(TextComponent component);
    TextComponent sortLexemesByOrder(TextComponent component, char symbol);
}
