package by.zakharanka.task02array.controller;

import by.zakharanka.task02array.controller.command.Command;
import by.zakharanka.task02array.controller.exception.ControllerException;
import by.zakharanka.task02array.entity.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code class} that receives data from the view layer
 * Passing data to a service layer to execute business logic and and event handling
 * @see CommandProvider
 * @see Command
 */
public final class Controller {
    static final Logger LOGGER = LogManager.getLogger(Controller.class.getName());

    private final CommandProvider provider = new CommandProvider();

    /**
     * Passing data to a service layer to execute business logic and and event handling
     * @see CommandProvider
     * @see Command
     * @param commandName user-selected command
     * @param request {@code HashMap} an object containing the textual result of execution or a thrown exception
     */
    public Map<String, Exception> executeTask(String commandName, Data<String> request) {
        Command executionCommand;
        executionCommand = provider.getCommand(commandName);
        HashMap<String, Exception> response = new HashMap<>();
        try {
            response = executionCommand.execute(request);
        } catch(ControllerException e) {
            LOGGER.error(e);
            response.put(null, e);
        }
        return response;
    }
}
