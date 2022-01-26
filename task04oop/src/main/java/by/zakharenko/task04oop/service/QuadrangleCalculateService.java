package by.zakharenko.task04oop.service;

import by.zakharenko.task04oop.entity.Quadrangle;
import by.zakharenko.task04oop.entity.QuadrangleType;

import java.util.Set;

public interface QuadrangleCalculateService {
    double findPerimeter(Quadrangle quadrangle);
    double findArea(Quadrangle quadrangle);
    boolean isConvex(Quadrangle quadrangle);
    Set<Integer> findQuarters(Quadrangle quadrangle);
    QuadrangleType determineType(Quadrangle quadrangle);
}
