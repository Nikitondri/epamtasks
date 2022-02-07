package by.zakharenko.task05multithreading.view;

import by.zakharenko.task05multithreading.controller.Controller;
import by.zakharenko.task05multithreading.controller.ControllerImpl;
import by.zakharenko.task05multithreading.entity.Data;

/**
 * a class that receives information from the user and outputs the response
 */
public class Menu {

    public static final int REQUEST_NUMBER = 100;

    OutputData outputData;

    public Menu(){
        outputData = new OutputData();
    }

    /**
     * a method that provides the user with information about the program,
     * receives data from him and transfers them to the controller
     * @see ControllerImpl
     * @see by.zakharenko.task05multithreading.controller.command.CommandName
     */
    public void menu() {
        Controller controllerImpl = new ControllerImpl();
        GeneratorRequest generatorRequest = new GeneratorRequest();
        Data<String> commandNameData = new Data<>();
        Data<Data<String>> requestData = new Data<>();
        for(int i = 0; i < REQUEST_NUMBER; i++) {
            Data<String> request = generatorRequest.generate();
            commandNameData.put(request.remove(0));
            requestData.put(request);
        }
        outputData.outputResult(controllerImpl.executeTask(commandNameData, requestData));
    }
}
