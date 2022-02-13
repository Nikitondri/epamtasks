package by.zakharenko.task06composite.controller;

import by.zakharenko.task06composite.controller.command.Command;
import by.zakharenko.task06composite.controller.command.CommandName;
import by.zakharenko.task06composite.controller.command.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.EnumMap;

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
