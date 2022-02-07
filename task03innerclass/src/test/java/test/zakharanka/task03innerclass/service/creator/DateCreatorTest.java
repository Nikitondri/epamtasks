package test.zakharanka.task03innerclass.service.creator;

import by.zakharanka.task03innerclass.entity.MyCalendar;
import by.zakharanka.task03innerclass.service.CalendarService;
import by.zakharanka.task03innerclass.service.exception.ServiceException;
import by.zakharanka.task03innerclass.service.factory.ServiceFactory;
import by.zakharanka.task03innerclass.service.impl.CalendarServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class DateCreatorTest {
    private static Stream<Arguments> dayOfWeekData(){
        return Stream.of(
                Arguments.of(MyCalendar.getInstance(2022), 0, 1, "сб"),
                Arguments.of(MyCalendar.getInstance(2022), 0, 3, "пн"),
                Arguments.of(MyCalendar.getInstance(2023), 0, 1, "вс")
        );
    }

    @ParameterizedTest
    @MethodSource("dayOfWeekData")
    void dayOfWeekTest(MyCalendar arg, int month, int day, String expected) throws ServiceException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CalendarService calendarService = serviceFactory.getCalendarService();
        Assertions.assertEquals(calendarService.dayOfWeek(arg, day, month), expected);
    }

    private static Stream<Arguments> dayOfWeekExceptionData(){
        return Stream.of(
                Arguments.of(MyCalendar.getInstance(2022), 12, 1),
                Arguments.of(MyCalendar.getInstance(2022), 2, 29)
        );
    }

    @ParameterizedTest
    @MethodSource("dayOfWeekExceptionData")
    void dayOfWeekExceptionTest(MyCalendar arg, int month, int day){
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CalendarService calendarService = serviceFactory.getCalendarService();
        Assertions.assertThrows(ServiceException.class, () -> calendarService.dayOfWeek(arg, day, month));
    }
}
