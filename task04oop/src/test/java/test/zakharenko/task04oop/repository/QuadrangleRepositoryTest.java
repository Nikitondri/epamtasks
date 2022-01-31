package test.zakharenko.task04oop.repository;

import by.zakharenko.task04oop.entity.Point;
import by.zakharenko.task04oop.entity.Quadrangle;
import by.zakharenko.task04oop.repository.QuadrangleRepository;
import by.zakharenko.task04oop.repository.Repository;
import by.zakharenko.task04oop.repository.specification.Specification;
import by.zakharenko.task04oop.repository.specification.quadrangle.SpecificationByQuadrangleLessId;
import by.zakharenko.task04oop.repository.specification.quadrangle.SpecificationByQuadrangleMoreId;
import by.zakharenko.task04oop.repository.specification.quadrangle.SpecificationByQuadrangleId;
import by.zakharenko.task04oop.repository.specification.quadrangle.SpecificationByQuadrangleName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

class QuadrangleRepositoryTest {
    private static Repository<Quadrangle> repository;

    @BeforeAll
    public static void init(){
        repository = QuadrangleRepository.getInstance();
        repository.add(new Quadrangle(1, "Quadrangle99", new Point(1, 1), new Point(1, 3), new Point(3, 3), new Point(3, 1)));
        repository.add(new Quadrangle(2, "Quadrangle02", new Point(1, 1), new Point(1, 5), new Point(10, 5), new Point(10, 1)));
        repository.add(new Quadrangle(3, "Quadrangle03", new Point(1, 1), new Point(3, 3), new Point(5, 3), new Point(6, 1)));
        repository.add(new Quadrangle(4, "Quadrangle04", new Point(1, 1), new Point(6, 5), new Point(3, 8), new Point(4, 4)));
        repository.add(new Quadrangle(5, "Quadrangle05", new Point(1, 1), new Point(4, 3), new Point(8, 3), new Point(5, 1)));
        repository.add(new Quadrangle(6, "Quadrangle06", new Point(3, 1), new Point(2, 4), new Point(3, 7), new Point(4, 4)));
    }


    private static Stream<Arguments> findBySpecificationData(){
        return Stream.of(
                Arguments.of(new SpecificationByQuadrangleId(1), new ArrayList<>(Collections.singletonList(
                        repository.get(1)
                ))),
                Arguments.of(new SpecificationByQuadrangleName("Quadrangle04"), new ArrayList<>(Collections.singletonList(
                        repository.get(4)
                ))),
                Arguments.of(
                        new SpecificationByQuadrangleMoreId(2).and(new SpecificationByQuadrangleLessId(5)),
                        new ArrayList<>(Arrays.asList(
                                repository.get(3),
                                repository.get(4)
                        ))
                ),
                Arguments.of(new SpecificationByQuadrangleMoreId(3),
                        new ArrayList<>(Arrays.asList(
                                repository.get(4),
                                repository.get(5),
                                repository.get(6)
                        ))
                )
        );
    }

    @ParameterizedTest
    @MethodSource("findBySpecificationData")
    void findBySpecificationTest(Specification<Quadrangle> specification, List<Quadrangle> expected){
        Assertions.assertEquals(expected, repository.findBySpecification(specification));
    }
}
