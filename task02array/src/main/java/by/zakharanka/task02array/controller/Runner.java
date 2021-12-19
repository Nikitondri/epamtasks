package by.zakharanka.task02array.controller;

import by.zakharanka.task02array.view.Menu;
import by.zakharanka.task02array.view.exception.ViewException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {
    //C:/Users/Никита/Desktop/matrix.txt

    static final Logger LOGGER = LogManager.getLogger(Runner.class.getName());

    public static void main(String[] args) {
        Menu menu = new Menu();
        try {
            menu.menu();
        } catch (ViewException e) {
            LOGGER.error(e);
        }
    }
}
