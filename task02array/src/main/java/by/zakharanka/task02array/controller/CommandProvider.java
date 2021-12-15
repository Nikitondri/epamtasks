package by.zakharanka.task02array.controller;

import by.zakharanka.task02array.controller.command.Command;
import by.zakharanka.task02array.controller.command.CommandName;
import by.zakharanka.task02array.controller.command.WrongCommand;
import by.zakharanka.task02array.controller.command.matriximpl.MatrixAddition;
import by.zakharanka.task02array.controller.command.matriximpl.MatrixMultiplication;

import by.zakharanka.task02array.controller.command.matriximpl.MatrixSubtraction;
import by.zakharanka.task02array.controller.command.matriximpl.MatrixTransposition;
import by.zakharanka.task02array.controller.command.sortimpl.*;

import java.util.EnumMap;

final class CommandProvider {
//    private final Map<CommandName, Command> repository = new HashMap<>();
    private final EnumMap<CommandName, Command> repository = new EnumMap<>(CommandName.class);

    CommandProvider() {
        repository.put(CommandName.MATRIX_ADDITION, new MatrixAddition());
        repository.put(CommandName.MATRIX_MULTIPLICATION, new MatrixMultiplication());
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
        repository.put(CommandName.WRONG_COMMAND, new WrongCommand());
    }

    Command getCommand(String name) {
        CommandName commandName;
        Command command;
        try{
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch(Exception e) {
            //TODO: add log
            command = repository.get(CommandName.WRONG_COMMAND);
        }
        return command;
    }
}
