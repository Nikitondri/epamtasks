package by.zakharanka.task03innerclass.service;


import by.zakharanka.task03innerclass.entity.MyCalendar;
import by.zakharanka.task03innerclass.service.exception.ServiceException;

public interface CalendarService {
    String dayOfWeek(MyCalendar calendar, int day, int month) throws ServiceException;
    String findRedDays(MyCalendar calendar) throws ServiceException;
    String isLeapYear(MyCalendar calendar) throws ServiceException;
    String isRedDay(MyCalendar calendar, int day, int month) throws ServiceException;
}
