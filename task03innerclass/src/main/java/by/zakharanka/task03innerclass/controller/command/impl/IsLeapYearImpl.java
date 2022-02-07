package by.zakharanka.task03innerclass.controller.command.impl;

import by.zakharanka.task03innerclass.controller.command.Command;
import by.zakharanka.task03innerclass.controller.exception.ControllerException;
import by.zakharanka.task03innerclass.entity.MyCalendar;
import by.zakharanka.task03innerclass.service.CalendarService;
import by.zakharanka.task03innerclass.service.creator.CalendarCreator;
import by.zakharanka.task03innerclass.service.creator.Creator;
import by.zakharanka.task03innerclass.service.exception.ServiceException;
import by.zakharanka.task03innerclass.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class IsLeapYearImpl implements Command {
    private static final String PATH_CALENDAR = "data/year.json";

    static final Logger LOGGER = LogManager.getLogger(IsLeapYearImpl.class.getName());

    /**
     * Method for calling methods to determine if a leap year
     * and exception handling
     * @see Command
     * @see CalendarService
     * @see Creator
     * @param request user-selected command
     * @return {@code HashMap} object including result or exception
     * @throws ControllerException handled on method {@code execute} invocation
     */
    @Override
    public Map<Boolean, String> execute(String request) throws ControllerException {
        Map<Boolean, String> res = new HashMap<>();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CalendarService tariffService = serviceFactory.getCalendarService();
        Creator<MyCalendar> creatorCalendar = new CalendarCreator();
        try{
            res.put(true, tariffService.isLeapYear(creatorCalendar.createFromFile(PATH_CALENDAR)));
            LOGGER.trace("IsLeapYearImpl completed correctly");
        } catch (ServiceException e){
            throw new ControllerException(e);
        }
        return res;
    }
}
