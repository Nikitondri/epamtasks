package by.zakharanka.task03innerclass.view;

import by.zakharanka.task03innerclass.controller.Controller;
import by.zakharanka.task03innerclass.controller.command.CommandName;
import by.zakharanka.task03innerclass.controller.factory.ControllerFactory;
import by.zakharanka.task03innerclass.view.manager.MessageManager;

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
            case "1" -> CommandName.DAY_OF_WEEK.toString();
            case "2" -> CommandName.IS_LEAP_YEAR.toString();
            case "3" -> CommandName.IS_RED_DAY.toString();
            case "4" -> CommandName.RED_DAYS.toString();
            case "5" -> CommandName.GENERATE_YEAR.toString();
            case "6" -> CommandName.GENERATE_DATE.toString();
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
