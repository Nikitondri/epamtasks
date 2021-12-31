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

    public static final String ERROR_MESSAGE = "Error creator";

    private static Stream<Arguments> data(){
        List<String> list = new ArrayList<>();
        list.add("tariffLimit2");
        list.add("555");
        return Stream.of(
                Arguments.of("parameters_list_creator_data/parameters.json", new ParametersList(list)),
                Arguments.of("InCorrectPath.json", new ParametersList()),
                Arguments.of("parameters_list_creator_data/empty.json", new ParametersList()),
                Arguments.of("parameters_list_creator_data/incorrectFile.json", new ParametersList())
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void test(String arg, ParametersList expected){
        try {
            ParametersListCreator creator = new ParametersListCreator();
            ParametersList parametersList = creator.createFromFile(arg);
            Assertions.assertEquals(Objects.requireNonNullElseGet(parametersList, ParametersList::new).toString(), expected.toString());
        } catch (ServiceException e){
            Assertions.assertEquals(ERROR_MESSAGE, e.getMessage());
        }
    }
}
