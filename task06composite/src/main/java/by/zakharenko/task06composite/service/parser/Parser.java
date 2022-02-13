package by.zakharenko.task06composite.service.parser;

import by.zakharenko.task06composite.entity.TextComponent;
import by.zakharenko.task06composite.service.exception.ServiceException;

public interface Parser {
    TextComponent parse(String text) throws ServiceException;
}
