package by.zakharenko.task04oop.service.comparator.impl;

import by.zakharenko.task04oop.entity.Quadrangle;
import by.zakharenko.task04oop.entity.QuadrangleRegistrar;
import by.zakharenko.task04oop.repository.QuadrangleRegistrarRepository;
import by.zakharenko.task04oop.service.comparator.QuadrangleComparator;

public class QuadrangleComparatorAreaImpl implements QuadrangleComparator {
    @Override
    public int compare(Quadrangle quadrangleOne, Quadrangle quadrangleTwo) {
        QuadrangleRegistrar quadrangleRegistrarOne = QuadrangleRegistrarRepository.getInstance().get(quadrangleOne.getId());
        QuadrangleRegistrar quadrangleRegistrarTwo = QuadrangleRegistrarRepository.getInstance().get(quadrangleTwo.getId());
        return Double.compare(quadrangleRegistrarOne.getArea(), quadrangleRegistrarTwo.getArea());
    }
}
