package by.zakharanka.task03inheritance.controller.command;

import by.zakharanka.task03inheritance.controller.exception.ControllerException;

import java.util.HashMap;
import java.util.Map;

@FunctionalInterface
public interface Command {
    Map<Boolean, String> execute(String request) throws ControllerException;
}
