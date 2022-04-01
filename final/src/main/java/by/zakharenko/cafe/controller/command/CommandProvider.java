package by.zakharenko.cafe.controller.command;

import by.zakharenko.cafe.controller.command.impl.GoToMenuCommand;
import by.zakharenko.cafe.controller.command.impl.ShowDishesCommand;
import by.zakharenko.cafe.controller.command.impl.WrongCommand;

import java.util.EnumMap;

public class CommandProvider {
    private final EnumMap<CommandName, Command> repository = new EnumMap<>(CommandName.class);

    public CommandProvider(){
        repository.put(CommandName.GO_TO_MENU, new GoToMenuCommand());
        repository.put(CommandName.SHOW_DISHES, new ShowDishesCommand());
        repository.put(CommandName.WRONG_COMMAND, new WrongCommand());
    }

    public Command getCommand(String name){
        CommandName commandName;
        Command command;
        try{
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (Exception e) {
            command = repository.get(CommandName.WRONG_COMMAND);
        }
        return command;
    }
}
