package by.zakharenko.task05multithreading.controller.command;

import by.zakharenko.task05multithreading.controller.ControllerImpl;
import by.zakharenko.task05multithreading.controller.exception.ControllerException;
import by.zakharenko.task05multithreading.entity.Data;

import java.util.HashMap;

/**
 * Class for handling an invalid command exception
 * @see CommandCallable
 * @see Command
 * @see ControllerImpl
 */
public class WrongCommandCallableImpl extends Command {

    public WrongCommandCallableImpl(Data<String> newRequest) {
        super(newRequest);
    }

    @Override
    public HashMap<Boolean, String> call() throws ControllerException {
        throw new ControllerException("Wrong Command");
    }
}
