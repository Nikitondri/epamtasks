package by.zakharenko.task07xml.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@FunctionalInterface
public interface Command {
    String execute(HttpServletRequest request, HttpServletResponse response);
}
