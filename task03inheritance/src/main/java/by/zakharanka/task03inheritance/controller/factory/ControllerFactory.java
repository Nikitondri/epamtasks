package by.zakharanka.task03inheritance.controller.factory;

import by.zakharanka.task03inheritance.controller.Controller;
import by.zakharanka.task03inheritance.controller.ControllerImpl;

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

