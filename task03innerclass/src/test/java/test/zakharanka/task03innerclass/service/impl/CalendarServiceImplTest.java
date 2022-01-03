package test.zakharanka.task03innerclass.service.impl;

import by.zakharanka.task03innerclass.entity.MyCalendar;
import by.zakharanka.task03innerclass.service.CalendarService;
import by.zakharanka.task03innerclass.service.creator.CalendarCreator;
import by.zakharanka.task03innerclass.service.exception.ServiceException;
import by.zakharanka.task03innerclass.service.factory.ServiceFactory;
import by.zakharanka.task03innerclass.service.impl.CalendarServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CalendarServiceImplTest {
    private static Stream<Arguments> dayOfWeekData(){
        return Stream.of(
                Arguments.of(MyCalendar.getInstance(2022), 0, 1, "сб"),
                Arguments.of(MyCalendar.getInstance(2022), 0, 3, "пн"),
                Arguments.of(MyCalendar.getInstance(2023), 0, 1, "вс"),
                Arguments.of(MyCalendar.getInstance(2022), 12, 1, CalendarServiceImpl.INCORRECT_DATA),
                Arguments.of(MyCalendar.getInstance(2022), 2, 29, CalendarServiceImpl.INCORRECT_DATA)
        );
    }

    @ParameterizedTest
    @MethodSource("dayOfWeekData")
    void dayOfWeekTest(MyCalendar arg, int month, int day, String expected){
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CalendarService calendarService = serviceFactory.getCalendarService();
        try {
            Assertions.assertEquals(calendarService.dayOfWeek(arg, day, month), expected);
        } catch (ServiceException e) {
            Assertions.assertEquals(expected, e.getMessage());
        }
    }

    private static Stream<Arguments> isLeapYearData(){
        return Stream.of(
                Arguments.of(MyCalendar.getInstance(2022), CalendarServiceImpl.YEAR_IS_NOT_LEAP),
                Arguments.of(MyCalendar.getInstance(2020), CalendarServiceImpl.YEAR_IS_LEAP),
                Arguments.of(MyCalendar.getInstance(2024), CalendarServiceImpl.YEAR_IS_LEAP),
                Arguments.of(MyCalendar.getInstance(Integer.MAX_VALUE), CalendarServiceImpl.YEAR_IS_NOT_LEAP),
                Arguments.of(MyCalendar.getInstance(Integer.MAX_VALUE - 3), CalendarServiceImpl.YEAR_IS_LEAP),
                Arguments.of(MyCalendar.getInstance(0), CalendarServiceImpl.YEAR_IS_LEAP),
                Arguments.of(MyCalendar.getInstance(-4), CalendarServiceImpl.YEAR_IS_LEAP)
        );
    }

    @ParameterizedTest
    @MethodSource("isLeapYearData")
    void isLeapYearTest(MyCalendar arg, String expected){
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CalendarService calendarService = serviceFactory.getCalendarService();
        try {
            Assertions.assertEquals(expected, calendarService.isLeapYear(arg));
        } catch (ServiceException e) {
            Assertions.assertEquals(expected, e.getMessage());
        }
    }

    private static Stream<Arguments> isRedDayData(){
        return Stream.of(
                Arguments.of(MyCalendar.getInstance(2022), 0, 1, CalendarServiceImpl.DAY_IS_RED),
                Arguments.of(MyCalendar.getInstance(2022), 0, 3, CalendarServiceImpl.DAY_IS_NOT_RED),
                Arguments.of(MyCalendar.getInstance(2023), 2, 8, CalendarServiceImpl.DAY_IS_RED),
                Arguments.of(MyCalendar.getInstance(2022), 12, 1, CalendarServiceImpl.INCORRECT_DATA),
                Arguments.of(MyCalendar.getInstance(2022), 2, 29, CalendarServiceImpl.INCORRECT_DATA)
        );
    }

    @ParameterizedTest
    @MethodSource("isRedDayData")
    void isRedDayTest(MyCalendar arg, int month, int day, String expected){
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CalendarService calendarService = serviceFactory.getCalendarService();
        CalendarCreator creator = new CalendarCreator();
        try {
            creator.createRedDays(arg);
            Assertions.assertEquals(expected, calendarService.isRedDay(arg, day, month));
        } catch (ServiceException e) {
            Assertions.assertEquals(expected, e.getMessage());
        }
    }
}
