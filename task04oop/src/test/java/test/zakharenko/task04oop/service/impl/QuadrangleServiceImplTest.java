package test.zakharenko.task04oop.service.impl;

import by.zakharenko.task04oop.entity.Point;
import by.zakharenko.task04oop.entity.Quadrangle;
import by.zakharenko.task04oop.service.QuadrangleService;
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

class QuadrangleServiceImplTest {
    private static List<Quadrangle> list;
    private static QuadrangleService quadrangleService;

    @BeforeAll
    public static void init(){
        ServiceFactory factory = ServiceFactory.getInstance();
        quadrangleService = factory.getQuadrangleService();
        list = new ArrayList<>(Arrays.asList(
                new Quadrangle(new Point(1, 1), new Point(1, 3), new Point(3, 3), new Point(3, 1)),
                new Quadrangle(new Point(1, 1), new Point(1, 5), new Point(10, 5), new Point(10, 1)),
                new Quadrangle(new Point(1, 1), new Point(3, 3), new Point(5, 3), new Point(6, 1)),
                new Quadrangle(new Point(1, 1), new Point(6, 5), new Point(3, 7), new Point(4, 4))
        ));
    }

    public static Stream<Arguments> findPerimeterData(){
        return Stream.of(
                Arguments.of(list.get(0), 8.0),
                Arguments.of(list.get(1), 26.0),
                Arguments.of(list.get(2), 12.06449497)
        );
    }

    @ParameterizedTest
    @MethodSource("findPerimeterData")
    void findPerimeterTest(Quadrangle quadrangle, Double expected){
        Assertions.assertEquals(expected, quadrangleService.findPerimeter(quadrangle), 0.00001);
    }

    public static Stream<Arguments> findAreaData(){
        return Stream.of(
                Arguments.of(list.get(0), 4.0),
                Arguments.of(list.get(1), 36.0),
                Arguments.of(list.get(2), 7.0)
        );
    }

    @ParameterizedTest
    @MethodSource("findAreaData")
    void findAreaTest(Quadrangle quadrangle, Double expected){
        Assertions.assertEquals(expected, quadrangleService.findArea(quadrangle), 0.00001);
    }

    public static Stream<Arguments> isConvexData(){
        return Stream.of(
                Arguments.of(list.get(0), true),
                Arguments.of(list.get(1), true),
                Arguments.of(list.get(2), true),
                Arguments.of(list.get(3), false)
        );
    }

    @ParameterizedTest
    @MethodSource("isConvexData")
    void isConvexTest(Quadrangle quadrangle, boolean expected){
        Assertions.assertEquals(expected, quadrangleService.isConvex(quadrangle));
    }
}
