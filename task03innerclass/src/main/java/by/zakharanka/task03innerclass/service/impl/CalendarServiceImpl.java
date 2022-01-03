package by.zakharanka.task03innerclass.service.impl;

import by.zakharanka.task03innerclass.entity.MyCalendar;
import by.zakharanka.task03innerclass.service.CalendarService;
import by.zakharanka.task03innerclass.service.exception.ServiceException;

public class CalendarServiceImpl implements CalendarService {
    public static final String YEAR_IS_LEAP = "Year is leap";
    public static final String YEAR_IS_NOT_LEAP = "Year is not leap";
    public static final String DAY_IS_RED = "Day is red";
    public static final String DAY_IS_NOT_RED = "Day is not red";
    public static final String INCORRECT_DATA = "Incorrect data";

    /**
     * method for determining the name of the day of the week based on a date
     * @see MyCalendar
     * @param calendar {@code MyCalendar} object
     * @param day day from date
     * @param month month from date
     * @return String object containing the name of the day of the week
     * @throws ServiceException to handle exceptions
     */
    @Override
    public String dayOfWeek(MyCalendar calendar, int day, int month) throws ServiceException {
        if(month < 12 && month >= 0 && day >= 0 && day <= calendar.dayInMonth(month)){
            return calendar.dayOfWeek(day, month);
        } else {
            throw new ServiceException(INCORRECT_DATA);
        }
    }

    /**
     * method for determining red days based on the year
     * @see MyCalendar
     * @param calendar {@code MyCalendar} object
     * @return list of red days based on the year
     */
    @Override
    public String findRedDays(MyCalendar calendar) {
        return calendar.getRedDay().toString();
    }

    /**
     * method for determining whether or not a leap year is based on the year
     * @see MyCalendar
     * @param calendar {@code MyCalendar} object
     * @return leap year or not
     */
    @Override
    public String isLeapYear(MyCalendar calendar) {
        return calendar.isLeapYear() ? YEAR_IS_LEAP : YEAR_IS_NOT_LEAP;
    }

    /**
     * method for determining whether a calendar day is red based on a date
     * @see MyCalendar
     * @param calendar {@code MyCalendar} object
     * @param day day from date
     * @param month month from date
     * @return String object containing result
     * @throws ServiceException to handle exceptions
     */
    @Override
    public String isRedDay(MyCalendar calendar, int day, int month) throws ServiceException {
        if(month < 12 && month >= 0 && day >= 0 && day <= calendar.dayInMonth(month)){
            return calendar.getRedDay().isRedDay(day, month) ? DAY_IS_RED : DAY_IS_NOT_RED;
        } else {
            throw new ServiceException(INCORRECT_DATA);
        }
    }
}
