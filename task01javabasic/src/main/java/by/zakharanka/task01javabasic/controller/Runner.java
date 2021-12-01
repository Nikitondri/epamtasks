package by.zakharanka.task01javabasic.controller;


import by.zakharanka.task01javabasic.entity.menu.Menu;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Main program class, starts the program
 */
public class Runner {

    static final Logger LOGGER = LogManager.getLogger(Runner.class.getName());

    public static void main(String[] args) {
        LOGGER.info("start program");
        Menu menu = new Menu();
        menu.menuOpen();
        LOGGER.info("Program is finished");
    }
}
