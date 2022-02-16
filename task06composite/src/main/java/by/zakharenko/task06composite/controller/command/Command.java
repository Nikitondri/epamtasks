package by.zakharenko.task06composite.controller.command;

import by.zakharenko.task06composite.controller.exception.ControllerException;

import java.util.List;
import java.util.Map;

/** functional interface describing the method that invokes the command and handles exceptions */
@FunctionalInterface
public interface Command {
    /**
     * @param request user request
     * @return A map where, if the result is positive, the key
     * will be true, and the value will be the result of the
     * execution, and in the case of an exception, the key will
     * be false, and the value will be the error text
     */
    Map<Boolean, String> execute(List<String> request) throws ControllerException;
}
