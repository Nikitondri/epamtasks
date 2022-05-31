package by.zakharenko.cafe.controller.command.impl;

import by.zakharenko.cafe.controller.Router;
import by.zakharenko.cafe.controller.command.Command;
import by.zakharenko.cafe.controller.enumeration.AttributeName;
import by.zakharenko.cafe.controller.enumeration.ParameterName;
import by.zakharenko.cafe.controller.enumeration.Page;
import by.zakharenko.cafe.controller.enumeration.Transition;
import by.zakharenko.cafe.service.MenuService;
import by.zakharenko.cafe.service.ReviewService;
import by.zakharenko.cafe.service.exception.ServiceException;
import by.zakharenko.cafe.service.factory.ServiceFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoToDishInfoCommand implements Command {
    static final Logger LOGGER = LogManager.getLogger(GoToDishInfoCommand.class.getName());
    @Override
    public Router execute(HttpServletRequest request, HttpServletResponse response) {
        ReviewService reviewService = ServiceFactory.getInstance().getReviewService();
        MenuService menuService = ServiceFactory.getInstance().getMenuService();
        try {
            request.getSession().setAttribute(
                    AttributeName.REVIEWS.getAttribute(),
                    reviewService.findReview(request.getParameter(ParameterName.ID.getParameter()))
            );
            request.getSession().setAttribute(
                    AttributeName.DISH.getAttribute(),
                    menuService.findDish(request.getParameter(ParameterName.ID.getParameter()))
            );
        } catch (ServiceException e) {
            LOGGER.log(Level.ERROR, e);
            request.setAttribute(AttributeName.ERROR.getAttribute(), e.getMessage());
            return new Router(Page.ERROR.getValue(), Transition.FORWARD);
        }
        return new Router(Page.DISH_INFO.getValue(), Transition.FORWARD);
    }
}
