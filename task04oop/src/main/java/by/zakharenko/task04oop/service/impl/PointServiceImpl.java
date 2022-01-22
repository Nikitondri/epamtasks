package by.zakharenko.task04oop.service.impl;

import by.zakharenko.task04oop.entity.Point;
import by.zakharenko.task04oop.service.PointService;

public class PointServiceImpl implements PointService {
    private static final int FIRST_QUARTER = 1;
    private static final int SECOND_QUARTER = 2;
    private static final int THIRD_QUARTER = 3;
    private static final int FOURTH_QUARTER = 4;

    @Override
    public double findLength(Point pointA, Point pointB) {
        return Math.sqrt((pointB.getX() - pointA.getX()) * (pointB.getX() - pointA.getX()) +
                (pointB.getY() - pointA.getY()) * (pointB.getY() - pointA.getY()));
    }

    @Override
    public int findQuarter(Point point) {
        if(point.getX() > 0 && point.getY() > 0){
            return FIRST_QUARTER;
        } else if(point.getX() < 0 && point.getY() > 0){
            return SECOND_QUARTER;
        } else if(point.getX() < 0 && point.getY() < 0){
            return THIRD_QUARTER;
        } else if(point.getX() > 0 && point.getY() < 0){
            return FOURTH_QUARTER;
        }
        return 0;
    }

    @Override
    public boolean isOnOneLine(Point pointA, Point pointB, Point pointC) {
        return ((pointC.getX() - pointA.getX()) * (pointB.getY() - pointA.getY())) ==
                ((pointC.getY() - pointA.getY()) * (pointB.getX() - pointA.getX()));
    }
}
