package by.zakharenko.task05multithreading.view;

import by.zakharenko.task05multithreading.controller.Controller;
import by.zakharenko.task05multithreading.controller.ControllerImpl;
import by.zakharenko.task05multithreading.entity.Data;

import java.util.Map;


/**
 * a class that receives information from the user and outputs the response
 */
public class Menu {

    public static final int REQUEST_NUMBER = 100;

    OutputData outputData;

    public Menu(){
        outputData = new OutputData();
    }

    private void outputResult(Data<Map<Boolean, String>> resultData){
        for(Map<Boolean, String> result: resultData.getList()) {
            if (result.containsKey(true)) {
                outputData.output(result.get(true));
            } else {
                outputData.output(result.get(false));
            }
            outputData.output("\n\n\n");
        }
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
        outputResult(controllerImpl.executeTask(commandNameData, requestData));
    }
}
