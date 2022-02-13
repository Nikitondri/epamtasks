package by.zakharenko.task06composite.controller.command.impl;

import by.zakharenko.task06composite.controller.command.Command;
import by.zakharenko.task06composite.controller.exception.ControllerException;

import java.util.List;
import java.util.Map;

public class WrongCommandImpl implements Command {
    @Override
    public Map<Boolean, String> execute(List<String> request) throws ControllerException {
        throw new ControllerException("Wrong Command");
    }
}
