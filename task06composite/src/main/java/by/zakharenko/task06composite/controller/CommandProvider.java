package by.zakharenko.task06composite.controller;

import by.zakharenko.task06composite.controller.command.Command;
import by.zakharenko.task06composite.controller.command.CommandName;
import by.zakharenko.task06composite.controller.command.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.EnumMap;

/**
 * command provider {@code class}
 * class for defining the command to be executed
 * @see Command
 * @see Controller
 * @see CommandName
 */
public class CommandProvider {
    private final EnumMap<CommandName, Command> repository = new EnumMap<>(CommandName.class);
    static final Logger LOGGER = LogManager.getLogger(CommandProvider.class.getName());

    CommandProvider(){
        repository.put(CommandName.COLLECT_TEXT, new CollectTextImpl());
        repository.put(CommandName.SORT_PARAGRAPH, new SortParagraphImpl());
        repository.put(CommandName.SORT_WORD, new SortWordImpl());
        repository.put(CommandName.SORT_LEXEME, new SortLexemeImpl());
        repository.put(CommandName.WRONG_COMMAND, new WrongCommandImpl());
    }

    /**
     * The method receives data from the user and returns the command being executed
     * @see CommandName
     * @see Command
     * @param name data containing the command from the user
     * @return an object of a class that implements an {@code interface} {@code Command}
     */
    Command getCommand(String name){
        CommandName commandName;
        Command command;
        try{
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
            LOGGER.trace("Selected correct command {}", commandName);
        } catch(Exception e) {
            command = repository.get(CommandName.WRONG_COMMAND);
            LOGGER.trace("Selected incorrect command WRONG_COMMAND");
        }
        return command;
    }
}
