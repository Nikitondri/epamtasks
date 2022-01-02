package by.zakharanka.task03innerclass.service.factory;

import by.zakharanka.task03innerclass.service.CalendarService;
import by.zakharanka.task03innerclass.service.impl.CalendarServiceImpl;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final CalendarService calendarService = new CalendarServiceImpl();

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return instance;
    }

    public CalendarService getCalendarService(){
        return calendarService;
    }


}
