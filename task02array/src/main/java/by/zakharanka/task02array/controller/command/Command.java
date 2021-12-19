package by.zakharanka.task02array.controller.command;

import by.zakharanka.task02array.controller.exception.ControllerException;
import by.zakharanka.task02array.entity.Data;

import java.util.HashMap;

/**
 * functional interface describing the method that invokes the command and handles exceptions
 * @see Data
 * @see HashMap
 */
@FunctionalInterface
public interface Command {
    /**
     * the method that invokes the command and handles exceptions
     * @param request data from user including filling method and directly data
     * @return {@code HashMap} with an execution result or an exception
     */
    HashMap<String, Exception> execute(Data<String> request) throws ControllerException;
}
