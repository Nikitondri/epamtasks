package by.zakharenko.cafe.controller.command.impl;

import by.zakharenko.cafe.controller.Router;
import by.zakharenko.cafe.controller.command.Command;
import by.zakharenko.cafe.controller.enumeration.Page;
import by.zakharenko.cafe.controller.enumeration.Transition;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignOutCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return new Router(Page.LOGIN.getValue(), Transition.FORWARD);
    }
}
