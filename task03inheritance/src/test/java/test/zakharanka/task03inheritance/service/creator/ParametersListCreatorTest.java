package test.zakharanka.task03inheritance.service.creator;

import by.zakharanka.task03inheritance.entity.ParametersList;
import by.zakharanka.task03inheritance.service.creator.ParametersListCreator;
import by.zakharanka.task03inheritance.service.exception.ServiceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

class ParametersListCreatorTest {

    private static Stream<Arguments> data(){
        List<String> list = new ArrayList<>();
        list.add("tariffLimit2");
        list.add("555");
        return Stream.of(
                Arguments.of("parameters_list_creator_data/parameters.json", new ParametersList(list)),
                Arguments.of("parameters_list_creator_data/empty.json", new ParametersList()),
                Arguments.of("parameters_list_creator_data/incorrectFile.json", new ParametersList())
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void test(String arg, ParametersList expected) throws ServiceException {
        ParametersListCreator creator = new ParametersListCreator();
        ParametersList parametersList = creator.createFromFile(arg);
        Assertions.assertEquals(Objects.requireNonNullElseGet(parametersList, ParametersList::new), expected);
    }

    private static Stream<Arguments> dataException(){
        return Stream.of(
                Arguments.of("InCorrectPath.json")
        );
    }

    @ParameterizedTest
    @MethodSource("dataException")
    void testException(String arg) {
        ParametersListCreator creator = new ParametersListCreator();
        Assertions.assertThrows(ServiceException.class, () -> {
            creator.createFromFile(arg);
        });
    }
}
