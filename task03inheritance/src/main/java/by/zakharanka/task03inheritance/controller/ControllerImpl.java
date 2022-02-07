package by.zakharanka.task03inheritance.controller;

import by.zakharanka.task03inheritance.controller.command.Command;
import by.zakharanka.task03inheritance.controller.exception.ControllerException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class ControllerImpl implements Controller {

    private final CommandProvider provider = new CommandProvider();
    static final Logger LOGGER = LogManager.getLogger(ControllerImpl.class.getName());

    /**
     * Passing data to a service layer to execute business logic and and event handling
     * @see CommandProvider
     * @see Command
     * @see Controller
     * @param commandName user-selected command
     * @return {@code HashMap} object including execution result
     */
    public Map<Boolean, String> executeAction(String commandName) {
        Command executionCommand;
        executionCommand = provider.getCommand(commandName);
        Map<Boolean, String> response = new HashMap<>();
        try {
            response = executionCommand.execute(commandName);
        } catch(ControllerException e) {
            LOGGER.error(e);
            response.put(false, e.toString());
        }
        return response;
    }
}
