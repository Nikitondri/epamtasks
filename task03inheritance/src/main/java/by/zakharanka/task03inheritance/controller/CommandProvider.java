package by.zakharanka.task03inheritance.controller;

import by.zakharanka.task03inheritance.controller.command.Command;
import by.zakharanka.task03inheritance.controller.command.CommandName;
import by.zakharanka.task03inheritance.controller.command.impl.*;

import java.util.EnumMap;

public class CommandProvider {
    private final EnumMap<CommandName, Command> repository = new EnumMap<>(CommandName.class);

    CommandProvider(){
        repository.put(CommandName.TOTAL_NUMBER_CLIENTS, new TotalNumberClientsImpl());
        repository.put(CommandName.SORT_TARIFFS, new SortTariffsImpl());
        repository.put(CommandName.FIND_TARIFF, new FindTariffImpl());
        repository.put(CommandName.GENERATE_TARIFFS, new GenerateTariffsImpl());
        repository.put(CommandName.WRONG_COMMAND, new WrongCommandImpl());
    }

    Command getCommand(String name){
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
