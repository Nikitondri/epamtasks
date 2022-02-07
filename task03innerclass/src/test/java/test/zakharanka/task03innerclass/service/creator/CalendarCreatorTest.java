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
                Arguments.of("calendar_creator_test_data/2020year.json", calendar)
        );
    }

    @ParameterizedTest
    @MethodSource("createFromFileData")
    void createFromFileTest(String arg, MyCalendar expected) throws ServiceException {
        Creator<MyCalendar> creator = new CalendarCreator();
        Assertions.assertEquals(expected, creator.createFromFile(arg));
    }

    private static Stream<Arguments> createFromFileExceptionData(){
        CalendarCreator creator = new CalendarCreator();
        MyCalendar calendar = MyCalendar.getInstance(2020);
        creator.createRedDays(calendar);
        return Stream.of(
                Arguments.of("calendar_creator_test_data/InCorrectPath.json"),
                Arguments.of("calendar_creator_test_data/incorrect_data.json")
        );
    }

    @ParameterizedTest
    @MethodSource("createFromFileExceptionData")
    void createFromFileExceptionTest(String arg){
        Creator<MyCalendar> creator = new CalendarCreator();
        Assertions.assertThrows(ServiceException.class, () -> creator.createFromFile(arg));
    }

}
