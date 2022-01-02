package by.zakharanka.task03innerclass.controller.command;

import by.zakharanka.task03innerclass.controller.exception.ControllerException;

import java.util.HashMap;

@FunctionalInterface
public interface Command {
    HashMap<String, Exception> execute(String request) throws ControllerException;
}
