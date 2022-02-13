package by.zakharenko.task06composite.controller;

import by.zakharenko.task06composite.controller.command.Command;
import by.zakharenko.task06composite.controller.exception.ControllerException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControllerImpl implements Controller{
    private final CommandProvider provider = new CommandProvider();
    static final Logger LOGGER = LogManager.getLogger(ControllerImpl.class.getName());

    @Override
    public Map<Boolean, String> executeAction(List<String> request) {
        Command command = provider.getCommand(request.get(0));
        Map<Boolean, String> response = new HashMap<>();
        try{
            response = command.execute(request);
        } catch (ControllerException e) {
            LOGGER.log(Level.ERROR, e);
            response.put(false, e.toString());
        }
        return response;
    }
}
