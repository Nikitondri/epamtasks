package by.zakharenko.task06composite.controller.command;

import by.zakharenko.task06composite.controller.exception.ControllerException;

import java.util.List;
import java.util.Map;

public interface Command {
    Map<Boolean, String> execute(List<String> request) throws ControllerException;
}
