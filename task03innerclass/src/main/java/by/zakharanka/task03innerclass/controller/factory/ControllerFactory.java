package by.zakharanka.task03innerclass.controller.factory;

import by.zakharanka.task03innerclass.controller.Controller;
import by.zakharanka.task03innerclass.controller.ControllerImpl;

public class ControllerFactory {
    private static final ControllerFactory instance = new ControllerFactory();

    private final Controller controller = new ControllerImpl();

    private ControllerFactory() {}

    public static ControllerFactory getInstance(){
        return instance;
    }

    public Controller getController(){
        return controller;
    }
}
