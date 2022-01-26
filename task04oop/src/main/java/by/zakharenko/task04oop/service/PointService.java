package by.zakharenko.task04oop.service;

import by.zakharenko.task04oop.entity.Point;

public interface PointService {
    double findLength(Point pointA, Point pointB);
    int findQuarter(Point point);
    boolean isOnOneLine(Point pointA, Point pointB, Point pointC);
    boolean isSegmentsIntersect(Point pointA, Point pointB, Point pointC, Point pointD);
}
