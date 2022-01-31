package by.zakharenko.task04oop.service.comparator;

import by.zakharenko.task04oop.entity.Quadrangle;

import java.util.Comparator;

/**
 * an interface that describes the behavior that comparator
 * classes for {@code Quadrangle} class should have
 */
public interface QuadrangleComparator extends Comparator<Quadrangle> {
    @Override
    int compare(Quadrangle o1, Quadrangle o2);
}
