package test.zakharenko.task04oop.repository;

import by.zakharenko.task04oop.entity.Point;
import by.zakharenko.task04oop.entity.Quadrangle;
import by.zakharenko.task04oop.entity.QuadrangleRegistrar;
import by.zakharenko.task04oop.repository.QuadrangleRegistrarRepository;
import by.zakharenko.task04oop.repository.Repository;
import by.zakharenko.task04oop.repository.specification.Specification;
import by.zakharenko.task04oop.repository.specification.quadrangleregistrar.*;
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
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class QuadrangleRegistrarRepositoryTest {

    @BeforeAll
    public static void init() throws ServiceException {
        RepositoryService<Quadrangle> repositoryService = ServiceFactory.getInstance().getRepositoryQuadrangleService();
        repositoryService.add(new Quadrangle(1, "Quadrangle99", new Point(1, 1), new Point(1, 3), new Point(3, 3), new Point(3, 1)));
        repositoryService.add(new Quadrangle(2, "Quadrangle02", new Point(1, 1), new Point(1, 5), new Point(10, 5), new Point(10, 1)));
        repositoryService.add(new Quadrangle(3, "Quadrangle03", new Point(1, 1), new Point(3, 3), new Point(5, 3), new Point(6, 1)));
        repositoryService.add(new Quadrangle(4, "Quadrangle04", new Point(1, 1), new Point(6, 5), new Point(3, 8), new Point(4, 4)));
        repositoryService.add(new Quadrangle(5, "Quadrangle05", new Point(1, 1), new Point(4, 3), new Point(8, 3), new Point(5, 1)));
        repositoryService.add(new Quadrangle(6, "Quadrangle06", new Point(3, 1), new Point(2, 4), new Point(3, 7), new Point(4, 4)));
    }


    private static Stream<Arguments> findBySpecificationData(){
        Repository<QuadrangleRegistrar> repository = QuadrangleRegistrarRepository.getInstance();
        return Stream.of(
                Arguments.of(new SpecificationByQuadrangleRegistrarArea(4), new ArrayList<>(Collections.singletonList(
                        repository.get(1)
                ))),
                Arguments.of(new SpecificationByQuadrangleRegistrarMoreArea(6).and(new SpecificationByQuadrangleRegistrarLessArea(10)),
                        new ArrayList<>(Arrays.asList(
                                repository.get(3),
                                repository.get(5)
                ))),
                Arguments.of(
                        new SpecificationByQuadrangleRegistrarPerimeter(8).or(new SpecificationByQuadrangleRegistrarPerimeter(26)),
                        new ArrayList<>(Arrays.asList(
                                repository.get(1),
                                repository.get(2)
                ))),
                Arguments.of(
                        new SpecificationByQuadrangleRegistrarMorePerimeter(7).and(new SpecificationByQuadrangleRegistrarLessPerimeter(9)),
                        new ArrayList<>(Collections.singletonList(
                                repository.get(1)
                ))),
                Arguments.of(
                        new SpecificationByQuadrangleRegistrarIsConvex(),
                        new ArrayList<>(Arrays.asList(
                                repository.get(1),
                                repository.get(2),
                                repository.get(3),
                                repository.get(5),
                                repository.get(6)
                ))),
                Arguments.of(
                        new SpecificationByQuadrangleRegistrarQuarter(2).not(),
                        new ArrayList<>(Arrays.asList(
                                repository.get(1),
                                repository.get(2),
                                repository.get(3),
                                repository.get(4),
                                repository.get(5),
                                repository.get(6)
                        )))
        );
    }

    @ParameterizedTest
    @MethodSource("findBySpecificationData")
    void findBySpecificationTest(Specification<QuadrangleRegistrar> specification, List<QuadrangleRegistrar> expected){
        Repository<QuadrangleRegistrar> repository = QuadrangleRegistrarRepository.getInstance();
        Assertions.assertEquals(expected, repository.findBySpecification(specification));
    }
}
