package by.zakharenko.task05multithreading.controller.command;

import by.zakharenko.task05multithreading.controller.exception.ControllerException;
import by.zakharenko.task05multithreading.entity.Data;

import java.util.HashMap;
import java.util.concurrent.Callable;

/**
 * functional interface describing the method that invokes the command and handles exceptions
 * @see Data
 * @see HashMap
 */
@FunctionalInterface
public interface CommandCallable extends Callable<HashMap<Boolean, String>> {
    /**
     * the method that invokes the command and handles exceptions
     * @return {@code HashMap} with an execution result or an exception
     */
    @Override
    HashMap<Boolean, String> call() throws ControllerException;
}
