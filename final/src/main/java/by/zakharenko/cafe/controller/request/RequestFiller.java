package by.zakharenko.cafe.controller.request;

import by.zakharenko.cafe.controller.enumeration.AttributeName;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Set;

public class RequestFiller {

    public void fillData(HttpServletRequest request, RequestContext requestContext) {
        Set<String> requestAttributeNames = requestContext.getRequestAttributeNames();
        for (String attributeName : requestAttributeNames) {
            Object attributeValue = requestContext.getRequestAttribute(attributeName);
            request.setAttribute(attributeName, attributeValue);
        }

        HttpSession session = request.getSession();
        Set<String> sessionAttributeNames = requestContext.getSessionAttributeNames();
        if (sessionAttributeNames.contains(AttributeName.INVALIDATE_ATTRIBUTE.getAttribute())) {
            session.invalidate();
        } else {
            for (String attributeName : sessionAttributeNames) {
                Object attributeValue = requestContext.getSessionAttribute(attributeName);
                session.setAttribute(attributeName, attributeValue);
            }
        }
    }
}
