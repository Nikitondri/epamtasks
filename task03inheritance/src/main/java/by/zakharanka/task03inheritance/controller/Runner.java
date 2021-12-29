package by.zakharanka.task03inheritance.controller;


import by.zakharanka.task03inheritance.view.Menu;
import by.zakharanka.task03inheritance.view.exception.ViewException;


public class Runner {
    public static void main(String[] args) throws ViewException {
        Menu menu = new Menu();
        menu.openMenu();
    }
}
