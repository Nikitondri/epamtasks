package by.zakharanka.task03innerclass.service.impl;

import by.zakharanka.task03innerclass.entity.MyCalendar;
import by.zakharanka.task03innerclass.service.CalendarService;
import by.zakharanka.task03innerclass.service.exception.ServiceException;

public class CalendarServiceImpl implements CalendarService {
    @Override
    public String dayOfWeek(MyCalendar calendar, int day, int month) throws ServiceException {
        if(month < 12 && month >= 0 && day >= 0 && day <= calendar.dayInMonth(month)){
            return calendar.dayOfWeek(day, month);
        } else {
            throw new ServiceException("InCorrect data");
        }
    }

    @Override
    public String findRedDays(MyCalendar calendar) {
        return calendar.getRedDay().toString();
    }

    @Override
    public String isLeapYear(MyCalendar calendar) {
        return calendar.isLeapYear() ? "Year is leap" : "Year is not leap";
    }

    @Override
    public String isRedDay(MyCalendar calendar, int day, int month) throws ServiceException {
        if(month < 12 && month >= 0 && day >= 0 && day <= calendar.dayInMonth(month)){
            return calendar.getRedDay().isRedDay(day, month) ? "Day is red" : "Day is not red";
        } else {
            throw new ServiceException("InCorrect data");
        }
    }
}
