package by.zakharenko.cafe.controller.command.impl;

import by.zakharenko.cafe.controller.enumeration.AttributeName;
import by.zakharenko.cafe.controller.enumeration.Page;
import by.zakharenko.cafe.controller.command.Command;
import by.zakharenko.cafe.service.MenuService;
import by.zakharenko.cafe.service.exception.ServiceException;
import by.zakharenko.cafe.service.factory.ServiceFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoToMenuCommand implements Command {
    static final Logger LOGGER = LogManager.getLogger(GoToMenuCommand.class.getName());
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        MenuService menuService = ServiceFactory.getInstance().getMenuService();
        try {
            request.getSession().setAttribute(
                    AttributeName.DISH_TYPES.getAttribute(),
                    menuService.goToMenu()
            );
            return Page.MENU.getValue();
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e);
            request.setAttribute(AttributeName.ERROR.getAttribute(), e.getMessage());
            return Page.ERROR.getValue();
        }
    }
}
