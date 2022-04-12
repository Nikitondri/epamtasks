package by.zakharenko.cafe.controller.command;

import by.zakharenko.cafe.controller.command.impl.*;

import java.util.EnumMap;

public class CommandProvider {
    private final EnumMap<CommandName, Command> repository = new EnumMap<>(CommandName.class);

    public CommandProvider(){
        repository.put(CommandName.GO_TO_MENU, new GoToMenuCommand());
        repository.put(CommandName.SHOW_DISHES, new ShowDishesCommand());
        repository.put(CommandName.GO_TO_DISH_INFO, new GoToDishInfoCommand());
        repository.put(CommandName.SIGN_UP, new SignUpCommand());
        repository.put(CommandName.SIGN_IN, new SignInCommand());
        repository.put(CommandName.SIGN_OUT, new SignOutCommand());
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
