package by.zakharanka.task03innerclass.controller;

import by.zakharanka.task03innerclass.controller.command.Command;
import by.zakharanka.task03innerclass.controller.command.CommandName;
import by.zakharanka.task03innerclass.controller.command.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.EnumMap;

public class    CommandProvider {
    private final EnumMap<CommandName, Command> repository = new EnumMap<>(CommandName.class);
    static final Logger LOGGER = LogManager.getLogger(CommandProvider.class.getName());

    CommandProvider(){
        repository.put(CommandName.DAY_OF_WEEK, new DayOfWeekImpl());
        repository.put(CommandName.IS_LEAP_YEAR, new IsLeapYearImpl());
        repository.put(CommandName.IS_RED_DAY, new IsRedDaysImpl());
        repository.put(CommandName.RED_DAYS, new RedDaysImpl());
        repository.put(CommandName.GENERATE_YEAR, new GenerateYearImpl());
        repository.put(CommandName.GENERATE_DATE, new GenerateDateImpl());
        repository.put(CommandName.WRONG_COMMAND, new WrongCommandImpl());
    }

    Command getCommand(String name){
        CommandName commandName;
        Command command;
        try{
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
            LOGGER.trace("Selected correct command");
        } catch(Exception e) {
            command = repository.get(CommandName.WRONG_COMMAND);
            LOGGER.trace("Selected InCorrect command");
        }
        return command;
    }
}
