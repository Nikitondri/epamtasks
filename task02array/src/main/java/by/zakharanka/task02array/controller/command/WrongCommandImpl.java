package by.zakharanka.task02array.controller.command;

import by.zakharanka.task02array.controller.exception.ControllerException;
import by.zakharanka.task02array.entity.Data;

import java.util.HashMap;

/**
 * Class for handling an invalid command exception
 * @see Command
 * @see by.zakharanka.task02array.controller.Controller
 */
public class WrongCommandImpl implements Command{
    /**
     * @see Data
     * @see Command
     * @param request data from user
     * @return Exception including error command message
     * @throws ControllerException handled on method {@code execute} invocation
     */
    @Override
    public HashMap<String, Exception> execute(Data<String> request) throws ControllerException {
        throw new ControllerException("Wrong Command");
    }
}
