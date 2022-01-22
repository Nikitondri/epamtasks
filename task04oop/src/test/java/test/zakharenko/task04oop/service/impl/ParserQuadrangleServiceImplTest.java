package test.zakharenko.task04oop.service.impl;

import by.zakharenko.task04oop.entity.Point;
import by.zakharenko.task04oop.entity.Quadrangle;
import by.zakharenko.task04oop.service.ParserService;
import by.zakharenko.task04oop.service.factory.ServiceFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class ParserQuadrangleServiceImplTest {
    private static List<List<String>> listStrings;
    private static List<List<Quadrangle>> listQuadrangles;

    @BeforeAll
    public static void init(){
        listStrings = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(
                      "Quadrangle01 1.0 1.0 1.0 3.0 3.0 3.0 3.0 1.0",
                      "Quadrangle  02 1.0 1.0 1  .0 3.0 3.0 3.0 3.0 1.0",
                      "Quadrangle03 1.0 1.0 1.0 3.0 3.0 3.0 3.0 1.0",
                      "Quadrangle03 1 .0 1.0 1 .0 3.0 3.0 3.0 3.0 1.0"
                )),
                new ArrayList<>(Arrays.asList(
                        "Quadrangle01   1.0   1.0 1.0 3.0   3.0 3.0   3.0 1.0",
                        "Quadrangle02 1. 0 1.0 1.0 3.0 3.0 3.0 3.0 1.0"
                ))
        ));
        listQuadrangles = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(
                        new Quadrangle(
                                "Quadrangle01",
                                new Point(1.0, 1.0),
                                new Point(1.0, 3.0),
                                new Point(3.0, 3.0),
                                new Point(3.0, 1.0)
                        ),
                        new Quadrangle(
                                "Quadrangle03",
                                new Point(1.0, 1.0),
                                new Point(1.0, 3.0),
                                new Point(3.0, 3.0),
                                new Point(3.0, 1.0)
                        )
                )),
                new ArrayList<>(Arrays.asList(
                        new Quadrangle(
                                "Quadrangle01",
                                new Point(1.0, 1.0),
                                new Point(1.0, 3.0),
                                new Point(3.0, 3.0),
                                new Point(3.0, 1.0)
                        )
                ))
        ));
    }

    public static Stream<Arguments> parseData(){
        return Stream.of(
                Arguments.of(listStrings.get(0), listQuadrangles.get(0)),
                Arguments.of(listStrings.get(1), listQuadrangles.get(1))
        );
    }

    @ParameterizedTest
    @MethodSource("parseData")
    void parseTest(List<String> arg, List<Quadrangle> expected){
        ParserService<Quadrangle> parserService = ServiceFactory.getInstance().getParserQuadrangleService();
        Assertions.assertEquals(expected, parserService.parse(arg));
    }
}
