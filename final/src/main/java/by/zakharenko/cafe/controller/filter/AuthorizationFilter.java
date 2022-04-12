package by.zakharenko.cafe.controller.filter;


import by.zakharenko.cafe.controller.command.CommandName;
import by.zakharenko.cafe.controller.enumeration.AttributeName;
import by.zakharenko.cafe.controller.enumeration.ParameterName;
import by.zakharenko.cafe.entity.enumeration.UserRole;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.EnumSet;

public class AuthorizationFilter implements Filter {
    static final Logger LOGGER = LogManager.getLogger(AuthorizationFilter.class.getName());

    private final EnumSet<CommandName> commonCommands = EnumSet.range(CommandName.GO_TO_MENU, CommandName.SHOW_DISHES);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        CommandName command = CommandName.valueOf(request.getParameter(ParameterName.COMMAND.getParameter()));
        LOGGER.log(Level.TRACE, "{}", command);
        UserRole userRole = (UserRole) session.getAttribute(AttributeName.USER_ID.getAttribute());
        if(userRole == null){
            userRole = UserRole.GUEST;
        }
        if(isAccessAllowed(userRole, command)){
            filterChain.doFilter(servletRequest, servletResponse);
        } else{
            LOGGER.log(Level.ERROR, "Authorization Error");
            //TODO: add send Error
        }

    }

    private boolean isAccessAllowed(UserRole userRole, CommandName command){
        if(command == null){
            return false;
        }
        switch (userRole) {
            case GUEST:
                if(commonCommands.contains(command)){
                    return true;
                }
                break;
            default:
                LOGGER.log(Level.ERROR, "Error user Role");
        }
        return false;
    }

    @Override
    public void destroy() {

    }
}
