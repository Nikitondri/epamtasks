package by.zakharenko.cafe.controller.command.impl;

import by.zakharenko.cafe.controller.Router;
import by.zakharenko.cafe.controller.command.Command;
import by.zakharenko.cafe.controller.enumeration.AttributeName;
import by.zakharenko.cafe.controller.enumeration.Page;
import by.zakharenko.cafe.controller.enumeration.ParameterName;
import by.zakharenko.cafe.controller.enumeration.Transition;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LocalizationCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) {
        String language = request.getParameter(ParameterName.LANGUAGE.getParameter());
        HttpSession session = request.getSession();
        String currentPage = (String) session.getAttribute(AttributeName.CURRENT_PAGE.getAttribute());
        if(currentPage == null){
            currentPage = Page.MAIN.getValue();
            request.getSession().setAttribute(AttributeName.CURRENT_PAGE.getAttribute(), Page.MAIN.getValue());
        }
        request.getSession().setAttribute(AttributeName.LANGUAGE.getAttribute(), language);
        return new Router(currentPage, Transition.FORWARD);
    }
}
