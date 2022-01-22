package by.zakharenko.task04oop.service;

import by.zakharenko.task04oop.entity.Quadrangle;

public interface QuadrangleService {
    double findPerimeter(Quadrangle quadrangle);
    double findArea(Quadrangle quadrangle);
    boolean isConvex(Quadrangle quadrangle);
}
