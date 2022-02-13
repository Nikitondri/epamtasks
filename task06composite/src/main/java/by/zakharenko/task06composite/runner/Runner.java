package by.zakharenko.task06composite.runner;

import by.zakharenko.task06composite.view.Menu;
import by.zakharenko.task06composite.view.MenuImpl;

public class Runner {
    public static void main(String[] args) {
        Menu menu = new MenuImpl();
        menu.openMenu();
    }
}
