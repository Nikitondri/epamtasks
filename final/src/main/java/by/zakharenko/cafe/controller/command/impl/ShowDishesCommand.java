package by.zakharenko.cafe.controller.command.impl;

import by.zakharenko.cafe.controller.Router;
import by.zakharenko.cafe.controller.command.Command;
import by.zakharenko.cafe.controller.enumeration.AttributeName;
import by.zakharenko.cafe.controller.enumeration.ParameterName;
import by.zakharenko.cafe.controller.enumeration.Page;
import by.zakharenko.cafe.controller.enumeration.Transition;
import by.zakharenko.cafe.service.MenuService;
import by.zakharenko.cafe.service.exception.ServiceException;
import by.zakharenko.cafe.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowDishesCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) {
        MenuService menuService = ServiceFactory.getInstance().getMenuService();
        try {
            request.setAttribute(
                    AttributeName.DISHES.getAttribute(),
                    menuService.findDishes(request.getParameter(ParameterName.ID.getParameter()))
            );
            return new Router(Page.MENU.getValue(), Transition.FORWARD);
        } catch (ServiceException e) {
            return new Router(Page.ERROR.getValue(), Transition.FORWARD);
        }
    }
}
