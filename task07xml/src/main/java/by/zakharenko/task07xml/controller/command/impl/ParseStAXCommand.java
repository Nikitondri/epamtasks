package by.zakharenko.task07xml.controller.command.impl;

import by.zakharenko.task07xml.controller.command.Command;
import by.zakharenko.task07xml.enumeration.AttributeName;
import by.zakharenko.task07xml.enumeration.JSPParameterName;
import by.zakharenko.task07xml.enumeration.Page;
import by.zakharenko.task07xml.service.ParseService;
import by.zakharenko.task07xml.service.exception.ServiceException;
import by.zakharenko.task07xml.service.factory.ServiceFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ParseStAXCommand implements Command {
    static final Logger LOGGER = LogManager.getLogger(ParseStAXCommand.class.getName());

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ParseService parseService = ServiceFactory.getInstance().getParseService();
        try {
            request.setAttribute(
                    AttributeName.REVIEWS.getAttribute(),
                    parseService.parseStAXReview(request.getPart(JSPParameterName.FILE.getParameter()).getInputStream())
            );
            return Page.RESULT.getValue();
        } catch (ServiceException | IOException | ServletException e) {
            LOGGER.log(Level.ERROR, e);
            request.setAttribute(AttributeName.ERROR.getAttribute(), e.getMessage());
            return Page.ERROR.getValue();
        }
    }
}
