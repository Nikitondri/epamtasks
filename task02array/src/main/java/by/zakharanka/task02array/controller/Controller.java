package by.zakharanka.task02array.controller;

import by.zakharanka.task02array.controller.command.Command;
import by.zakharanka.task02array.entity.Data;
import by.zakharanka.task02array.entity.exception.EntityException;
import by.zakharanka.task02array.service.exception.ServiceException;

import java.util.HashMap;

public final class Controller {
    private final CommandProvider provider = new CommandProvider();

    public HashMap<String, Exception> executeTask(String commandName, Data<String> request) {
        Command executionCommand;

        executionCommand = provider.getCommand(commandName);

        HashMap<String, Exception> response = null;
        try {
            response = executionCommand.execute(request);
        } catch(ServiceException | EntityException e) {
            //TODO: add log
        }

        return response;
    }
}
