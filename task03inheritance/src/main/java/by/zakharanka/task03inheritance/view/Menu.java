package by.zakharanka.task03inheritance.view;

import by.zakharanka.task03inheritance.controller.Controller;
import by.zakharanka.task03inheritance.controller.command.CommandName;
import by.zakharanka.task03inheritance.controller.factory.ControllerFactory;
import by.zakharanka.task03inheritance.view.manager.MessageManager;

public class Menu {

    OutputData outputData;
    InputData inputData;

    public Menu(){
        outputData = new OutputData();
        inputData = new InputData();
    }

    private MessageManager choiceLanguage(String arg){
        return switch (arg){
            case "1"-> MessageManager.RU;
            case "2"-> MessageManager.BY;
            default -> MessageManager.EN;
        };
    }

    private String choiceTask(String arg){
        return switch (arg){
            case "1" -> CommandName.TOTAL_NUMBER_CLIENTS.toString();
            case "2" -> CommandName.SORT_TARIFFS.toString();
            case "3" -> CommandName.FIND_TARIFF.toString();
            case "4" -> CommandName.GENERATE_TARIFFS.toString();
            default -> CommandName.WRONG_COMMAND.toString();
        };
    }

    /**
     * method for user interaction
     * provides the user with a task to select and receives the execution result from the controller layer
     */
    public void openMenu() {
        MessageManager mm = MessageManager.EN;
        outputData.output(mm.getString("CHOICE_LANGUAGE_TEXT"));
        mm = choiceLanguage(inputData.inputString());
        outputData.output(mm.getString("CHOICE_TASK_TEXT"));
        String commandName = choiceTask(inputData.inputString());
        ControllerFactory controllerFactory = ControllerFactory.getInstance();
        Controller controller = controllerFactory.getController();
        outputData.outputResult(controller.executeAction(commandName));
    }
}
