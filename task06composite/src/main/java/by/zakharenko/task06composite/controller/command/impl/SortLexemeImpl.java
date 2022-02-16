package by.zakharenko.task06composite.controller.command.impl;

import by.zakharenko.task06composite.controller.command.Command;
import by.zakharenko.task06composite.controller.exception.ControllerException;
import by.zakharenko.task06composite.entity.TextComponent;
import by.zakharenko.task06composite.service.TextService;
import by.zakharenko.task06composite.service.exception.ServiceException;
import by.zakharenko.task06composite.service.factory.ServiceFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortLexemeImpl implements Command {
    /**
     * This method parses the text and then sorts the tokens
     * of the given text in descending order by the number
     * of occurrences of the given character
     * @see Command
     * @see TextComponent
     * @see TextService
     * @param request user request
     * @return {@code Map} object that stores the result of execution
     */
    @Override
    public Map<Boolean, String> execute(List<String> request) throws ControllerException {
        Map<Boolean, String> result = new HashMap<>();
        TextService textService = ServiceFactory.getInstance().getTextService();
        try {
            TextComponent component = textService.parseTextFromFile(request.get(1));
            TextComponent sortedComponent = textService.sortLexemesByOrder(component, request.get(2).charAt(0));
            result.put(true, textService.collectText(sortedComponent));
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
        return result;
    }
}
