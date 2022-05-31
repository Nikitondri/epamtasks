package by.zakharenko.cafe.controller.command;

import by.zakharenko.cafe.controller.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@FunctionalInterface
public interface Command {
    Router execute(HttpServletRequest request, HttpServletResponse response);
}
