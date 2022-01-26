package test.zakharenko.task04oop.service.impl;

import by.zakharenko.task04oop.entity.Quadrangle;
import by.zakharenko.task04oop.service.ValidatorService;
import by.zakharenko.task04oop.service.factory.ServiceFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ValidatorQuadrangleCalculateServiceImplTest {
    public static Stream<Arguments> isCorrectLineData(){
        return Stream.of(
                Arguments.of("Quadrangle01 1.0 1.0 1.0 3.0 3.0 3.0 3.0 1.0", true),
                Arguments.of("123 1.0 1.0 1.0 1.0 3.0 3.0 3.0 3.0 1.0", false),
                Arguments.of("W_1 1.0 1.0 1.0 3.0 3.0 3.0 3.0 1.0", true),
                Arguments.of("Quadrangle01 1.0 1.0 1.0 3.0 3.0 3.0 3.0 1.0 1.9", false),
                Arguments.of("Quadrangle01     1.0   1.0   0.0   3.0   3.0   3.0  3.0 1.0", true),
                Arguments.of("Quadrangle01     1.0   1.0   0. 0   3.0   3.0   3.0  3.0 1.0", false)
        );
    }

    @ParameterizedTest
    @MethodSource("isCorrectLineData")
    void isCorrectLineTest(String line, boolean expected){
        ValidatorService<Quadrangle> validatorService = ServiceFactory.getInstance().getValidatorQuadrangleService();
        Assertions.assertEquals(expected, validatorService.isCorrectLine(line));
    }

}
