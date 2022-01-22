package test.zakharenko.task04oop.repository;

import by.zakharenko.task04oop.repository.QuadrangleRepository;
import by.zakharenko.task04oop.repository.specification.Specification;
import by.zakharenko.task04oop.repository.specification.quadrangle.FindSpecificationByQuadrangleId;
import by.zakharenko.task04oop.repository.specification.quadrangle.FindSpecificationByQuadrangleLessId;
import by.zakharenko.task04oop.repository.specification.quadrangle.FindSpecificationByQuadrangleMoreId;
import by.zakharenko.task04oop.repository.specification.quadrangle.FindSpecificationByQuadrangleName;
import by.zakharenko.task04oop.entity.Point;
import by.zakharenko.task04oop.entity.Quadrangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

class QuadrangleRepositoryTest {
    private static Stream<Arguments> dayOfWeekData(){
        return Stream.of(
                Arguments.of(1, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("dayOfWeekData")
    void dayOfWeekTest(int x, int y){
        Quadrangle quadrangle1 = new Quadrangle("1", new Point(1, 1), new Point(2, 2), new Point(3, 3), new Point(1, 1));
        Quadrangle quadrangle2 = new Quadrangle("3", new Point(1, 1), new Point(2, 2), new Point(3, 3), new Point(1, 1));
        Quadrangle quadrangle3 = new Quadrangle("3", new Point(1, 1), new Point(2, 2), new Point(3, 3), new Point(1, 1));
        Quadrangle quadrangle4 = new Quadrangle("4", new Point(1, 1), new Point(2, 2), new Point(3, 3), new Point(1, 1));
        quadrangle1.setId(10);
        quadrangle2.setId(2);
        quadrangle3.setId(3);
        quadrangle4.setId(1);
        QuadrangleRepository repo = QuadrangleRepository.getInstance();
        repo.add(quadrangle1);
        repo.add(quadrangle2);
        repo.add(quadrangle3);
        repo.add(quadrangle4);
        Specification<Quadrangle> specification = new FindSpecificationByQuadrangleName("3");
        Specification<Quadrangle> specification1 = new FindSpecificationByQuadrangleId(3);
        Specification<Quadrangle> specification2 = new FindSpecificationByQuadrangleMoreId(1);
        Specification<Quadrangle> specification3 = new FindSpecificationByQuadrangleLessId(4);

        Comparator<Quadrangle> comparator = new Comparator<Quadrangle>() {
            @Override
            public int compare(Quadrangle o1, Quadrangle o2) {
                return (int)(o1.getId() - o2.getId());
            }
        };
        List<Quadrangle> list = repo.sortByComparator(comparator);
        for(Quadrangle q: list){
            System.out.println(q);
        }
        Assertions.assertEquals(x, y);
    }
}
