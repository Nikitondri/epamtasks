package by.zakharenko.task07xml.controller.command;

import by.zakharenko.task07xml.controller.command.impl.ParseDOMCommand;
import by.zakharenko.task07xml.controller.command.impl.ParseSAXCommand;
import by.zakharenko.task07xml.controller.command.impl.ParseStAXCommand;
import by.zakharenko.task07xml.controller.command.impl.WrongCommand;

import java.util.EnumMap;

public class CommandProvider {
    private final EnumMap<CommandName, Command> repository = new EnumMap<>(CommandName.class);

    public CommandProvider(){
        repository.put(CommandName.PARSE_DOM, new ParseDOMCommand());
        repository.put(CommandName.PARSE_SAX, new ParseSAXCommand());
        repository.put(CommandName.PARSE_STAX, new ParseStAXCommand());
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
