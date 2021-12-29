package by.zakharanka.task03inheritance.controller.command;

import by.zakharanka.task03inheritance.controller.exception.ControllerException;

import java.util.HashMap;

@FunctionalInterface
public interface Command {
    HashMap<String, Exception> execute(String request)throws ControllerException;
}
