package by.zakharenko.cafe.controller.command.impl;

import by.zakharenko.cafe.controller.command.Command;
import by.zakharenko.cafe.controller.enumeration.AttributeName;
import by.zakharenko.cafe.controller.enumeration.JSPParameterName;
import by.zakharenko.cafe.controller.enumeration.Page;
import by.zakharenko.cafe.service.MenuService;
import by.zakharenko.cafe.service.exception.ServiceException;
import by.zakharenko.cafe.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowDishesCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        MenuService menuService = ServiceFactory.getInstance().getMenuService();
        try {
            request.setAttribute(
                    AttributeName.DISHES.getAttribute(),
                    menuService.showDishes(request.getParameter(JSPParameterName.ID.getParameter()))
            );
            return Page.MENU.getValue();
        } catch (ServiceException e) {
            return Page.ERROR.getValue();
        }
    }
}
