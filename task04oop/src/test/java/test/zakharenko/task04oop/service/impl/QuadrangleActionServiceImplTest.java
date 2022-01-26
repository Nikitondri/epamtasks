package test.zakharenko.task04oop.service.impl;

import by.zakharenko.task04oop.entity.Point;
import by.zakharenko.task04oop.entity.Quadrangle;
import by.zakharenko.task04oop.service.QuadrangleActionService;
import by.zakharenko.task04oop.service.comparator.QuadrangleComparatorType;
import by.zakharenko.task04oop.service.exception.ServiceException;
import by.zakharenko.task04oop.service.factory.ServiceFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class QuadrangleActionServiceImplTest {
    private static QuadrangleActionService quadrangleActionService;

    @BeforeAll
    public static void init() throws ServiceException {
        ServiceFactory factory = ServiceFactory.getInstance();
        quadrangleActionService = factory.getQuadrangleActionService();
        quadrangleActionService.addQuadranglesFromFile("testfiles/test_file.json");
        quadrangleActionService.addQuadranglesFromFile("testfiles/test_file.txt");
        quadrangleActionService.setName(1, "Quadrangle99");
        quadrangleActionService.setPoint(4, new Point(3, 8), 3);
    }


    public static Stream<Arguments> findQuadrangleData(){
        return Stream.of(
                Arguments.of(1, new Quadrangle(
                        1,
                        "Quadrangle99",
                        new Point(1.0, 1.0),
                        new Point(1.0, 3.0),
                        new Point(3.0, 3.0),
                        new Point(3.0, 1.0)
                )),
                Arguments.of(4, new Quadrangle(
                        4,
                        "Quadrangle04",
                        new Point(1.0, 1.0),
                        new Point(6.0, 5.0),
                        new Point(3.0, 7.0),
                        new Point(4.0, 4.0)
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("findQuadrangleData")
    void findQuadrangleTest(long id, Quadrangle expected){
        Assertions.assertEquals(expected, quadrangleActionService.findQuadrangle(id));
    }

    public static Stream<Arguments> sortData() throws ServiceException {
        List<Quadrangle> list1 = new ArrayList<>();
        list1.add(new Quadrangle(1, "Quadrangle99", new Point(1, 1), new Point(1, 3), new Point(3, 3), new Point(3, 1)));
        list1.add(new Quadrangle(2, "Quadrangle02", new Point(1, 1), new Point(1, 5), new Point(10, 5), new Point(10, 1)));
        list1.add(new Quadrangle(3, "Quadrangle03", new Point(1, 1), new Point(3, 3), new Point(5, 3), new Point(6, 1)));
        list1.add(new Quadrangle(4, "Quadrangle04", new Point(1, 1), new Point(6, 5), new Point(3, 8), new Point(4, 4)));
        list1.add(new Quadrangle(5, "Quadrangle05", new Point(1, 1), new Point(4, 3), new Point(8, 3), new Point(5, 1)));
        list1.add(new Quadrangle(6, "Quadrangle06", new Point(3, 1), new Point(2, 4), new Point(3, 7), new Point(4, 4)));
        List<Quadrangle> list2 = new ArrayList<>();
        list2.add(new Quadrangle(1, "Quadrangle99", new Point(1, 1), new Point(1, 3), new Point(3, 3), new Point(3, 1)));
        list2.add(new Quadrangle(4, "Quadrangle04", new Point(1, 1), new Point(6, 5), new Point(3, 8), new Point(4, 4)));
        list2.add(new Quadrangle(6, "Quadrangle06", new Point(3, 1), new Point(2, 4), new Point(3, 7), new Point(4, 4)));
        list2.add(new Quadrangle(3, "Quadrangle03", new Point(1, 1), new Point(3, 3), new Point(5, 3), new Point(6, 1)));
        list2.add(new Quadrangle(5, "Quadrangle05", new Point(1, 1), new Point(4, 3), new Point(8, 3), new Point(5, 1)));
        list2.add(new Quadrangle(2, "Quadrangle02", new Point(1, 1), new Point(1, 5), new Point(10, 5), new Point(10, 1)));
        List<Quadrangle> list3 = new ArrayList<>();
        list3.add(new Quadrangle(1, "Quadrangle99", new Point(1, 1), new Point(1, 3), new Point(3, 3), new Point(3, 1)));
        list3.add(new Quadrangle(3, "Quadrangle03", new Point(1, 1), new Point(3, 3), new Point(5, 3), new Point(6, 1)));
        list3.add(new Quadrangle(6, "Quadrangle06", new Point(3, 1), new Point(2, 4), new Point(3, 7), new Point(4, 4)));
        list3.add(new Quadrangle(5, "Quadrangle05", new Point(1, 1), new Point(4, 3), new Point(8, 3), new Point(5, 1)));
        list3.add(new Quadrangle(4, "Quadrangle04", new Point(1, 1), new Point(6, 5), new Point(3, 8), new Point(4, 4)));
        list3.add(new Quadrangle(2, "Quadrangle02", new Point(1, 1), new Point(1, 5), new Point(10, 5), new Point(10, 1)));
        List<Quadrangle> list4 = new ArrayList<>();
        list4.add(new Quadrangle(2, "Quadrangle02", new Point(1, 1), new Point(1, 5), new Point(10, 5), new Point(10, 1)));
        list4.add(new Quadrangle(3, "Quadrangle03", new Point(1, 1), new Point(3, 3), new Point(5, 3), new Point(6, 1)));
        list4.add(new Quadrangle(4, "Quadrangle04", new Point(1, 1), new Point(6, 5), new Point(3, 8), new Point(4, 4)));
        list4.add(new Quadrangle(5, "Quadrangle05", new Point(1, 1), new Point(4, 3), new Point(8, 3), new Point(5, 1)));
        list4.add(new Quadrangle(6, "Quadrangle06", new Point(3, 1), new Point(2, 4), new Point(3, 7), new Point(4, 4)));
        list4.add(new Quadrangle(1, "Quadrangle99", new Point(1, 1), new Point(1, 3), new Point(3, 3), new Point(3, 1)));

        return Stream.of(
                Arguments.of(QuadrangleComparatorType.ID_SORT, list1),
                Arguments.of(QuadrangleComparatorType.NAME_SORT, list4),
                Arguments.of(QuadrangleComparatorType.AREA_SORT, list2),
                Arguments.of(QuadrangleComparatorType.PERIMETER_SORT, list3)
        );
    }

    @ParameterizedTest
    @MethodSource("sortData")
    void sortTest(QuadrangleComparatorType type, List<Quadrangle> expected){
        Assertions.assertEquals(expected, quadrangleActionService.sort(type));
    }

    public static Stream<Arguments> removeQuadrangleData(){
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(0, false),
                Arguments.of(2, true),
                Arguments.of(8, false),
                Arguments.of(4, true)
        );
    }

    @ParameterizedTest
    @MethodSource("removeQuadrangleData")
    void removeQuadrangleTest(long id, boolean expected) {
        Assertions.assertEquals(expected, quadrangleActionService.removeQuadrangle(id));
    }

    public static Stream<Arguments> findParameterData(){
        return Stream.of(
                Arguments.of(1, "type", "SQUARE"),
                Arguments.of(1, "perimeter", "8.0"),
                Arguments.of(1, "area", "4.0"),
                Arguments.of(1, "isConvex", "true")
        );
    }

    @ParameterizedTest
    @MethodSource("findParameterData")
    void findParameterTest(long id, String parameter, String expected) throws ServiceException {
        Assertions.assertEquals(expected, quadrangleActionService.findParameter(id, parameter));
    }
}
