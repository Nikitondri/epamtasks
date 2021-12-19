package by.zakharanka.task02array.controller;

import by.zakharanka.task02array.controller.command.Command;
import by.zakharanka.task02array.controller.command.CommandName;
import by.zakharanka.task02array.controller.command.WrongCommandImpl;
import by.zakharanka.task02array.controller.command.matriximpl.MatrixAdditionImpl;
import by.zakharanka.task02array.controller.command.matriximpl.MatrixMultiplicationImpl;

import by.zakharanka.task02array.controller.command.matriximpl.MatrixSubtraction;
import by.zakharanka.task02array.controller.command.matriximpl.MatrixTransposition;
import by.zakharanka.task02array.controller.command.sortimpl.*;

import java.util.EnumMap;

/**
 * command provider {@code class}
 * class for defining the command to be executed
 * @see Command
 * @see Controller
 * @see CommandName
 */
final class CommandProvider {
    private final EnumMap<CommandName, Command> repository = new EnumMap<>(CommandName.class);

    CommandProvider() {
        repository.put(CommandName.MATRIX_ADDITION, new MatrixAdditionImpl());
        repository.put(CommandName.MATRIX_MULTIPLICATION, new MatrixMultiplicationImpl());
        repository.put(CommandName.MATRIX_SUBTRACTION, new MatrixSubtraction());
        repository.put(CommandName.MATRIX_TRANSPOSITION, new MatrixTransposition());
        repository.put(CommandName.BINARY_MERGE_SORT, new BinaryMergeSort());
        repository.put(CommandName.BUBBLE_SORT, new BubbleSort());
        repository.put(CommandName.EXTERNAL_SORT, new ExternalSort());
        repository.put(CommandName.INSERT_SORT, new InsertSort());
        repository.put(CommandName.SHAKER_SORT, new ShakerSort());
        repository.put(CommandName.SHELL_SORT, new ShellSort());
        repository.put(CommandName.SIMPLE_CHOICE_SORT, new SimpleChoiceSort());
        repository.put(CommandName.SIMPLE_INSERT_SORT, new SimpleInsertSort());
        repository.put(CommandName.WRONG_COMMAND, new WrongCommandImpl());
    }

    /**
     * The method receives data from the user and returns the command being executed
     * @see CommandName
     * @see Command
     * @param name data containing the command from the user
     * @return an object of a class that implements an {@code interface} {@code Command}
     */
    Command getCommand(String name) {
        CommandName commandName;
        Command command;
        try{
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch(Exception e) {
            command = repository.get(CommandName.WRONG_COMMAND);
        }
        return command;
    }
}
