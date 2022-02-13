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

public class SortWordImpl implements Command {
    @Override
    public Map<Boolean, String> execute(List<String> request) throws ControllerException {
        Map<Boolean, String> result = new HashMap<>();
        TextService textService = ServiceFactory.getInstance().getTextService();
        try {
            TextComponent component = textService.parseTextFromFile(request.get(1));
            TextComponent sortedComponent = textService.sortWord(component);
            result.put(true, textService.collectText(sortedComponent));
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
        return result;
    }
}
