package by.zakharanka.task03inheritance.controller.command.impl;

import by.zakharanka.task03inheritance.controller.command.Command;
import by.zakharanka.task03inheritance.controller.exception.ControllerException;

import java.util.HashMap;

public class WrongCommandImpl implements Command {
    /**
     * @see Command
     * @param request data from user
     * @return Exception including error command message
     * @throws ControllerException handled on method {@code execute} invocation
     */
    @Override
    public HashMap<String, Exception> execute(String request) throws ControllerException {
        throw new ControllerException("Wrong Command");
    }
}
