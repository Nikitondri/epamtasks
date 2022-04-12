package by.zakharenko.cafe.controller.command.impl;

import by.zakharenko.cafe.controller.command.Command;
import by.zakharenko.cafe.controller.enumeration.AttributeName;
import by.zakharenko.cafe.controller.enumeration.Page;
import by.zakharenko.cafe.controller.enumeration.ParameterName;
import by.zakharenko.cafe.entity.UserAccount;
import by.zakharenko.cafe.service.UserService;
import by.zakharenko.cafe.service.exception.ServiceException;
import by.zakharenko.cafe.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignInCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserService userService = ServiceFactory.getInstance().getUserService();
        String password = request.getParameter(ParameterName.PASSWORD.getParameter());
        String login = request.getParameter(ParameterName.LOGIN.getParameter());
        try {
            UserAccount userAccount = userService.findUserByLoginPassword(password, login);
            request.getSession().setAttribute(AttributeName.USER_ID.getAttribute(), userAccount.getId());
            request.getSession().setAttribute(AttributeName.ROLE.getAttribute(), userAccount.getRole());
            return Page.MAIN.getValue();
        } catch (ServiceException e) {
            request.setAttribute(AttributeName.ERROR.getAttribute(), e.getMessage());
            return Page.LOGIN.getValue();
        }
    }
}
