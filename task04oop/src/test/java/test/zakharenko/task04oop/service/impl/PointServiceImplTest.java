package test.zakharenko.task04oop.service.impl;

import by.zakharenko.task04oop.entity.Point;
import by.zakharenko.task04oop.service.PointService;
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

class PointServiceImplTest {

    private static List<Point> list;
    private static PointService pointService;

    @BeforeAll
    public static void init(){
        ServiceFactory factory = ServiceFactory.getInstance();
        pointService = factory.getPointService();
        list = new ArrayList<>(Arrays.asList(
                new Point(1, 1),
                new Point(3, 1),
                new Point(1, 3),
                new Point(3, 3),
                new Point(-5, -2),
                new Point(5, -1),
                new Point(0, 0),
                new Point(0.5, 0),//7
                new Point(-1, 1),
                new Point(0, 5),
                new Point(0, 1),//10
                new Point(2, 1),
                new Point(2, 2),
                new Point(0, -1),//13
                new Point(-0.5, 0)
        ));
    }

    public static Stream<Arguments> findLengthData(){
        return Stream.of(
                Arguments.of(list.get(0), list.get(1), 2.0),
                Arguments.of(list.get(0), list.get(2), 2.0),
                Arguments.of(list.get(0), list.get(0), 0.0),
                Arguments.of(list.get(0), list.get(3), 2.82842712),
                Arguments.of(list.get(4), list.get(5), 10.0498756211),
                Arguments.of(list.get(6), list.get(7), 0.5)
        );
    }

    @ParameterizedTest
    @MethodSource("findLengthData")
    void findLengthTest(Point pointA, Point pointB, Double expected){
        Assertions.assertEquals(expected, pointService.findLength(pointA, pointB), 0.00001);
    }

    public static Stream<Arguments> findQuarterData(){
        return Stream.of(
                Arguments.of(list.get(0), 1),
                Arguments.of(list.get(4), 3),
                Arguments.of(list.get(5), 4),
                Arguments.of(list.get(8), 2),
                Arguments.of(list.get(6), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("findQuarterData")
    void findQuarterTest(Point point, int expected){
        Assertions.assertEquals(expected, pointService.findQuarter(point));
    }

    public static Stream<Arguments> isOnOneLineData(){
        return Stream.of(
                Arguments.of(list.get(8), list.get(1), list.get(0), true),
                Arguments.of(list.get(3), list.get(1), list.get(0), false),
                Arguments.of(list.get(6), list.get(9), list.get(10), true),
                Arguments.of(list.get(11), list.get(1), list.get(0), true),
                Arguments.of(list.get(0), list.get(3), list.get(12), true),
                Arguments.of(list.get(0), list.get(7), list.get(12), false)
        );
    }

    @ParameterizedTest
    @MethodSource("isOnOneLineData")
    void isOnOneLineTest(Point pointA, Point pointB, Point pointC, boolean expected){
        Assertions.assertEquals(expected, pointService.isOnOneLine(pointA, pointB, pointC));
    }

    public static Stream<Arguments> isSegmentsIntersectData(){
        return Stream.of(
                Arguments.of(list.get(0), list.get(3), list.get(1), list.get(2), true),
                Arguments.of(list.get(0), list.get(1), list.get(2), list.get(3), false),
                Arguments.of(list.get(0), list.get(12), list.get(1), list.get(3), false),
                Arguments.of(list.get(0), list.get(12), list.get(1), list.get(2), true),
                Arguments.of(list.get(10), list.get(13), list.get(7), list.get(14), true)
        );
    }

    @ParameterizedTest
    @MethodSource("isSegmentsIntersectData")
    void isSegmentsIntersectTest(Point pointA, Point pointB, Point pointC, Point pointD, boolean expected){
        Assertions.assertEquals(expected, pointService.isSegmentsIntersect(pointA, pointB, pointC, pointD));
    }
}
