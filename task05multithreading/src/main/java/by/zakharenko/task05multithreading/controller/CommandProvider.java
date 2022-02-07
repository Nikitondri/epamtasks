package by.zakharenko.task05multithreading.controller;

import by.zakharenko.task05multithreading.controller.command.CommandCallable;
import by.zakharenko.task05multithreading.controller.command.CommandName;
import by.zakharenko.task05multithreading.controller.command.WrongCommandCallableImpl;
import by.zakharenko.task05multithreading.controller.command.matriximpl.*;
import by.zakharenko.task05multithreading.controller.command.sortimpl.*;
import by.zakharenko.task05multithreading.entity.Data;

import java.util.EnumMap;

/**
 * command provider {@code class}
 * class for defining the command to be executed
 * @see CommandCallable
 * @see ControllerImpl
 * @see CommandName
 */
final class CommandProvider {
    private final EnumMap<CommandName, CommandCallable> repository = new EnumMap<>(CommandName.class);

    CommandProvider(Data<String> request) {
        repository.put(CommandName.MATRIX_ADDITION, new MatrixAdditionImpl(request));
        repository.put(CommandName.MATRIX_MULTIPLICATION, new MatrixMultiplicationImpl(request));
        repository.put(CommandName.MATRIX_SUBTRACTION, new MatrixSubtraction(request));
        repository.put(CommandName.MATRIX_TRANSPOSITION, new MatrixTransposition(request));
        repository.put(CommandName.BINARY_MERGE_SORT, new BinaryMergeSort(request));
        repository.put(CommandName.BUBBLE_SORT, new BubbleSort(request));
        repository.put(CommandName.EXTERNAL_SORT, new ExternalSort(request));
        repository.put(CommandName.INSERT_SORT, new InsertSort(request));
        repository.put(CommandName.SHAKER_SORT, new ShakerSort(request));
        repository.put(CommandName.SHELL_SORT, new ShellSort(request));
        repository.put(CommandName.SIMPLE_CHOICE_SORT, new SimpleChoiceSort(request));
        repository.put(CommandName.SIMPLE_INSERT_SORT, new SimpleInsertSort(request));
        repository.put(CommandName.MATRIX_MULTIPLICATION_BY_NUMBER, new MatrixMultiplicationByNumberImpl(request));
        repository.put(CommandName.WRONG_COMMAND, new WrongCommandCallableImpl(request));
    }

    /**
     * The method receives data from the user and returns the command being executed
     * @see CommandName
     * @see CommandCallable
     * @param name data containing the command from the user
     * @return an object of a class that implements an {@code interface} {@code Command}
     */
    CommandCallable getCommand(String name) {
        CommandName commandName;
        CommandCallable commandCallable;
        try{
            commandName = CommandName.valueOf(name.toUpperCase());
            commandCallable = repository.get(commandName);
        } catch(Exception e) {
            commandCallable = repository.get(CommandName.WRONG_COMMAND);
        }
        return commandCallable;
    }
}
