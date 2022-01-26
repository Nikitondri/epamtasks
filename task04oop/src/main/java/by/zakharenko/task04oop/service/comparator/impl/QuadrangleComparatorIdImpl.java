package by.zakharenko.task04oop.service.comparator.impl;

import by.zakharenko.task04oop.entity.Quadrangle;
import by.zakharenko.task04oop.service.comparator.QuadrangleComparator;

public class QuadrangleComparatorIdImpl implements QuadrangleComparator {
    @Override
    public int compare(Quadrangle quadrangleOne, Quadrangle quadrangleTwo) {
        return Long.compare(quadrangleOne.getId(), quadrangleTwo.getId());
    }
}
