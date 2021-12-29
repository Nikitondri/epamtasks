package by.zakharanka.task03inheritance.controller;

import by.zakharanka.task03inheritance.controller.command.Command;
import by.zakharanka.task03inheritance.controller.exception.ControllerException;

import java.util.HashMap;
import java.util.Map;

public class ControllerImpl implements Controller {

    private final CommandProvider provider = new CommandProvider();

    public Map<String, Exception> executeAction(String commandName) {
        Command executionCommand;
        executionCommand = provider.getCommand(commandName);
        HashMap<String, Exception> response = new HashMap<>();
        try {
            response = executionCommand.execute(commandName);
        } catch(ControllerException e) {
            response.put(null, e);
        }
        return response;
    }
}
