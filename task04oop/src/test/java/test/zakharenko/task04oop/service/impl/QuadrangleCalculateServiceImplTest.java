package test.zakharenko.task04oop.service.impl;

import by.zakharenko.task04oop.entity.Point;
import by.zakharenko.task04oop.entity.Quadrangle;
import by.zakharenko.task04oop.entity.QuadrangleType;
import by.zakharenko.task04oop.service.QuadrangleCalculateService;
import by.zakharenko.task04oop.service.factory.ServiceFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

class QuadrangleCalculateServiceImplTest {
    private static List<Quadrangle> list;
    private static QuadrangleCalculateService quadrangleCalculateService;

    @BeforeAll
    public static void init(){
        ServiceFactory factory = ServiceFactory.getInstance();
        quadrangleCalculateService = factory.getQuadrangleCalculateService();
        list = new ArrayList<>(Arrays.asList(
                new Quadrangle(new Point(1, 1), new Point(1, 3), new Point(3, 3), new Point(3, 1)),
                new Quadrangle(new Point(1, 1), new Point(1, 5), new Point(10, 5), new Point(10, 1)),
                new Quadrangle(new Point(1, 1), new Point(3, 3), new Point(5, 3), new Point(6, 1)),
                new Quadrangle(new Point(1, 1), new Point(6, 5), new Point(3, 7), new Point(4, 4)),
                new Quadrangle(new Point(1, 1), new Point(4, 3), new Point(8, 3), new Point(5, 1)),
                new Quadrangle(new Point(3, 1), new Point(2, 4), new Point(3, 7), new Point(4, 4)), //5
                new Quadrangle(new Point(-1, -1), new Point(-1, 1), new Point(1, 1), new Point(1, -1)),
                new Quadrangle(new Point(-1, 0), new Point(-1, 1), new Point(1, 1), new Point(1, 0))
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
        Assertions.assertEquals(expected, quadrangleCalculateService.findPerimeter(quadrangle), 0.00001);
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
        Assertions.assertEquals(expected, quadrangleCalculateService.findArea(quadrangle), 0.00001);
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
        Assertions.assertEquals(expected, quadrangleCalculateService.isConvex(quadrangle));
    }

    public static Stream<Arguments> determineTypeData(){
        return Stream.of(
                Arguments.of(list.get(0), QuadrangleType.SQUARE),
                Arguments.of(list.get(1), QuadrangleType.RECTANGLE),
                Arguments.of(list.get(2), QuadrangleType.TRAPEZE),
                Arguments.of(list.get(3), QuadrangleType.ARBITRARY),
                Arguments.of(list.get(4), QuadrangleType.PARALLELOGRAM),
                Arguments.of(list.get(5), QuadrangleType.RHOMBUS)
        );
    }

    @ParameterizedTest
    @MethodSource("determineTypeData")
    void determineTypeTest(Quadrangle quadrangle, QuadrangleType expected){
        Assertions.assertEquals(expected, quadrangleCalculateService.determineType(quadrangle));
    }

    public static Stream<Arguments> findQuartersData(){
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);
        Set<Integer> set3 = new HashSet<>();
        set3.add(1);
        set3.add(2);
        return Stream.of(
                Arguments.of(list.get(0), set1),
                Arguments.of(list.get(6), set2),
                Arguments.of(list.get(7), set3)
        );
    }

    @ParameterizedTest
    @MethodSource("findQuartersData")
    void findQuartersTest(Quadrangle quadrangle, Set<Integer> expected){
        Assertions.assertEquals(expected, quadrangleCalculateService.findQuarters(quadrangle));
    }
}
