package by.zakharanka.task03innerclass.controller.command;

import by.zakharanka.task03innerclass.controller.exception.ControllerException;

import java.util.Map;

@FunctionalInterface
public interface Command {
    Map<Boolean, String> execute(String request) throws ControllerException;
}
