package by.zakharenko.task07xml.controller.command.impl;

import by.zakharenko.task07xml.controller.command.Command;
import by.zakharenko.task07xml.enumeration.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WrongCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return Page.ERROR.getValue();
    }
}
