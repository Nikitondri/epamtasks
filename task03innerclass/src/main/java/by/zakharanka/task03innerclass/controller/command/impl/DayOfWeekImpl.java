package by.zakharanka.task03innerclass.controller.command.impl;

import by.zakharanka.task03innerclass.controller.command.Command;
import by.zakharanka.task03innerclass.controller.exception.ControllerException;
import by.zakharanka.task03innerclass.entity.Date;
import by.zakharanka.task03innerclass.entity.MyCalendar;
import by.zakharanka.task03innerclass.service.CalendarService;
import by.zakharanka.task03innerclass.service.creator.CalendarCreator;
import by.zakharanka.task03innerclass.service.creator.Creator;
import by.zakharanka.task03innerclass.service.creator.DateCreator;
import by.zakharanka.task03innerclass.service.exception.ServiceException;
import by.zakharanka.task03innerclass.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class DayOfWeekImpl implements Command {
    private static final String PATH_CALENDAR = "data/year.json";
    private static final String PATH_DATE = "data/date.json";

    static final Logger LOGGER = LogManager.getLogger(DayOfWeekImpl.class.getName());

    /**
     * Method for calling methods to find day of week
     * and exception handling
     * @see Command
     * @see CalendarService
     * @see Creator
     * @param request user-selected command
     * @return {@code HashMap} object including result or exception
     * @throws ControllerException handled on method {@code execute} invocation
     */
    @Override
    public HashMap<String, Exception> execute(String request) throws ControllerException {
        HashMap<String, Exception> res = new HashMap<>();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CalendarService tariffService = serviceFactory.getCalendarService();
        Creator<MyCalendar> creatorCalendar = new CalendarCreator();
        Creator<Date> creatorDate = new DateCreator();
        try{
            Date date = creatorDate.createFromFile(PATH_DATE);
            res.put(tariffService.dayOfWeek(creatorCalendar.createFromFile(PATH_CALENDAR), date.getDay(), date.getMonth()), null);
            LOGGER.trace("DayOfWeekImpl completed correctly");
        } catch (ServiceException e){
            throw new ControllerException(e);
        }
        return res;
    }
}
