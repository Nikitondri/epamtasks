package by.zakharenko.task07xml.controller;

import by.zakharenko.task07xml.controller.command.Command;
import by.zakharenko.task07xml.controller.command.CommandProvider;
import by.zakharenko.task07xml.enumeration.JSPParameterName;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


@WebServlet("/controller")
@MultipartConfig
public class Controller extends HttpServlet {

    static final Logger LOGGER = LogManager.getLogger(Controller.class.getName());
    private final CommandProvider provider = new CommandProvider();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            processRequest(req, resp);
        } catch (IOException | ServletException e) {
            LOGGER.log(Level.ERROR, "Error: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            processRequest(req, resp);
        } catch (IOException | ServletException e) {
            LOGGER.log(Level.ERROR, "Error: " + e.getMessage());
        }
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Command command = provider.getCommand(req.getParameter(JSPParameterName.COMMAND.getParameter()));
        String resultPage = command.execute(req, resp);
        req.getRequestDispatcher(resultPage).forward(req, resp);
    }
}
