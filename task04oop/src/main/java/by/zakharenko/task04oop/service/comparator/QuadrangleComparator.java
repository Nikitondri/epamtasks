package by.zakharenko.task04oop.service.comparator;

import by.zakharenko.task04oop.entity.Quadrangle;

import java.util.Comparator;

public interface QuadrangleComparator extends Comparator<Quadrangle> {
    @Override
    int compare(Quadrangle o1, Quadrangle o2);
}
