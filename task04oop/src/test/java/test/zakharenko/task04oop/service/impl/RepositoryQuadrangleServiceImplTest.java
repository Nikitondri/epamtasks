package test.zakharenko.task04oop.service.impl;

import by.zakharenko.task04oop.entity.Point;
import by.zakharenko.task04oop.entity.Quadrangle;
import by.zakharenko.task04oop.repository.QuadrangleRepository;
import by.zakharenko.task04oop.service.QuadrangleCalculateService;
import by.zakharenko.task04oop.service.RepositoryService;
import by.zakharenko.task04oop.service.exception.ServiceException;
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

public class RepositoryQuadrangleServiceImplTest {
    private static List<Quadrangle> list;
    private static RepositoryService<Quadrangle> repositoryService;

    @BeforeAll
    public static void init(){
        ServiceFactory factory = ServiceFactory.getInstance();
        repositoryService = factory.getRepositoryQuadrangleService();
        list = new ArrayList<>(Arrays.asList(
                new Quadrangle(new Point(1, 1), new Point(1, 3), new Point(3, 3), new Point(3, 1)),
                new Quadrangle(new Point(1, 1), new Point(1, 5), new Point(10, 5), new Point(10, 1)),
                new Quadrangle(new Point(1, 1), new Point(3, 3), new Point(5, 3), new Point(6, 1)),
                new Quadrangle(new Point(1, 1), new Point(6, 5), new Point(3, 7), new Point(4, 4)),
                new Quadrangle(new Point(1, 1), new Point(4, 3), new Point(8, 3), new Point(5, 1)),
                new Quadrangle(new Point(3, 1), new Point(2, 4), new Point(3, 7), new Point(4, 4))
        ));
    }

    public static Stream<Arguments> addData(){
        return Stream.of(
                Arguments.of(list.get(0), 1),
                Arguments.of(list.get(1), 2),
                Arguments.of(list.get(2), 3)
        );
    }

    @ParameterizedTest
    @MethodSource("addData")
    void addTest(Quadrangle quadrangle, long expected) throws ServiceException {
        Assertions.assertEquals(expected, repositoryService.add(quadrangle));
    }

    public static Stream<Arguments> removeData(){
        QuadrangleRepository.getInstance().add(new Quadrangle(
                1,
                "Quadrangle01",
                new Point(1, 1),
                new Point(1, 3),
                new Point(3, 3),
                new Point(3, 1)
        ));
        QuadrangleRepository.getInstance().add(new Quadrangle(
                2,
                "Quadrangle02",
                new Point(1, 1),
                new Point(1, 3),
                new Point(3, 3),
                new Point(3, 1)
        ));
        QuadrangleRepository.getInstance().add(new Quadrangle(
                4,
                "Quadrangle04",
                new Point(1, 1),
                new Point(1, 3),
                new Point(3, 3),
                new Point(3, 1)
        ));
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(0, false),
                Arguments.of(2, true),
                Arguments.of(3, false),
                Arguments.of(4, true)
        );
    }

    @ParameterizedTest
    @MethodSource("removeData")
    void removeTest(long id, boolean expected) {
        Assertions.assertEquals(expected, repositoryService.remove(id));
    }

    public static Stream<Arguments> addListData(){
        return Stream.of(
                Arguments.of(
                        new ArrayList<>(Arrays.asList(
                                list.get(0),
                                list.get(1),
                                list.get(2)
                        )),
                        new ArrayList<>(Arrays.asList(
                                1,
                                2,
                                3
                        ))
                )
        );
    }

    @ParameterizedTest
    @MethodSource("addListData")
    void addListTest(List<Quadrangle> quadrangles, List<Long> expected) throws ServiceException {
        Assertions.assertEquals(expected.toString(), repositoryService.addList(quadrangles).toString());
    }
}
