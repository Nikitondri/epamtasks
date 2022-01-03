package test.zakharanka.task03innerclass.service.creator;

import by.zakharanka.task03innerclass.entity.MyCalendar;
import by.zakharanka.task03innerclass.service.creator.CalendarCreator;
import by.zakharanka.task03innerclass.service.creator.Creator;
import by.zakharanka.task03innerclass.service.exception.ServiceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CalendarCreatorTest {
    private static Stream<Arguments> createFromFileData(){
        CalendarCreator creator = new CalendarCreator();
        MyCalendar calendar = MyCalendar.getInstance(2020);
        creator.createRedDays(calendar);
        return Stream.of(
                Arguments.of("calendar_creator_test_data/2020year.json", calendar.toString()),
                Arguments.of("calendar_creator_test_data/InCorrectPath.json", CalendarCreator.ERROR),
                Arguments.of("calendar_creator_test_data/incorrect_data.json", CalendarCreator.ERROR)
        );
    }

    @ParameterizedTest
    @MethodSource("createFromFileData")
    void createFromFileTest(String arg, String expected){
        Creator<MyCalendar> creator = new CalendarCreator();
        try {
            Assertions.assertEquals(expected, creator.createFromFile(arg).toString());
        } catch (ServiceException e) {
            Assertions.assertEquals(expected, e.getMessage());
        }
    }

}
