package test.zakharanka.task03innerclass.entity;

import by.zakharanka.task03innerclass.entity.MyCalendar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MyCalendarTest {
    private static Stream<Arguments> isLeapYearData(){
        return Stream.of(
                Arguments.of(MyCalendar.getInstance(2020), true),
                Arguments.of(MyCalendar.getInstance(2024), true),
                Arguments.of(MyCalendar.getInstance(Integer.MAX_VALUE), false),
                Arguments.of(MyCalendar.getInstance(Integer.MAX_VALUE-3), true),
                Arguments.of(MyCalendar.getInstance(0), true),
                Arguments.of(MyCalendar.getInstance(-4), true)
        );
    }

    @ParameterizedTest
    @MethodSource("isLeapYearData")
    void isLeapYearTest(MyCalendar arg, boolean expected){
        Assertions.assertEquals(expected, arg.isLeapYear());
    }

    private static Stream<Arguments> dayOfWeekData(){
        return Stream.of(
                Arguments.of(MyCalendar.getInstance(2022), 1, 0, "сб"),
                Arguments.of(MyCalendar.getInstance(2020), 8, 11, "вт"),
                Arguments.of(MyCalendar.getInstance(2024), 1, 29, "пн"),
                Arguments.of(MyCalendar.getInstance(2022), 3, 0, "пн")
        );
    }

    @ParameterizedTest
    @MethodSource("dayOfWeekData")
    void dayOfWeekTest(MyCalendar arg, int day, int month, String expected){
        Assertions.assertEquals(expected, arg.dayOfWeek(day, month));
    }

}
