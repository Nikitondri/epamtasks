package by.zakharenko.cafe.controller.command.impl;

import by.zakharenko.cafe.controller.command.Command;
import by.zakharenko.cafe.controller.enumeration.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignOutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return Page.LOGIN.getValue();
    }
}
