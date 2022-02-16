package by.zakharenko.task06composite.service.collector;

import by.zakharenko.task06composite.entity.TextComponent;
import by.zakharenko.task06composite.service.exception.ServiceException;

public interface TextComponentCollector {
    String collect(TextComponent component) throws ServiceException;
}
