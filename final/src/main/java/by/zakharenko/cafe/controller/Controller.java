package by.zakharenko.cafe.controller;

import by.zakharenko.cafe.controller.command.Command;
import by.zakharenko.cafe.controller.command.CommandProvider;
import by.zakharenko.cafe.controller.enumeration.AttributeName;
import by.zakharenko.cafe.controller.enumeration.ParameterName;
import by.zakharenko.cafe.controller.enumeration.Transition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/controller")
public class Controller extends HttpServlet {
    static final Logger LOGGER = LogManager.getLogger(Controller.class.getName());
    private final CommandProvider provider = new CommandProvider();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Command command = provider.getCommand(req.getParameter(ParameterName.COMMAND.getParameter()));
        Router router = command.execute(req, resp);
        HttpSession session = req.getSession();
        session.setAttribute(AttributeName.CURRENT_PAGE.getAttribute(), router.getPage());
        if(router.getTransition() == Transition.FORWARD){
            req.getRequestDispatcher(router.getPage()).forward(req, resp);
        } else {
            resp.sendRedirect(router.getPage());
        }
    }


}
