package by.zakharenko.task04oop.service.impl;

import by.zakharenko.task04oop.entity.Point;
import by.zakharenko.task04oop.service.PointService;

/**
 * class for calculations related to {@code Point} class objects
 * @see Point
 * @see PointService
 */
public class PointServiceImpl implements PointService {
    public static final int FIRST_QUARTER = 1;
    public static final int SECOND_QUARTER = 2;
    public static final int THIRD_QUARTER = 3;
    public static final int FOURTH_QUARTER = 4;

    /** a method that calculates the distance between two points */
    @Override
    public double findLength(Point pointA, Point pointB) {
        return Math.sqrt((pointB.getX() - pointA.getX()) * (pointB.getX() - pointA.getX()) +
                (pointB.getY() - pointA.getY()) * (pointB.getY() - pointA.getY()));
    }

    /**
     * a method that calculates which quarter a point lies in
     * @param point point
     * @return quarter number or 0 if the point lies on the axis
     */
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

    /** method to determine if three points lie on the same line */
    @Override
    public boolean isOnOneLine(Point pointA, Point pointB, Point pointC) {
        return ((pointC.getX() - pointA.getX()) * (pointB.getY() - pointA.getY())) ==
                ((pointC.getY() - pointA.getY()) * (pointB.getX() - pointA.getX()));
    }

    /**
     * a method that determines whether segments given by points intersect
     * @param pointA start of the first segment
     * @param pointB end of the first segment
     * @param pointC start of the second segment
     * @param pointD end of the second segment
     * @return boolean value
     */
    @Override
    public boolean isSegmentsIntersect(Point pointA, Point pointB, Point pointC, Point pointD) {
        double x1 = pointA.getX();
        double x2 = pointB.getX();
        double x3 = pointC.getX();
        double x4 = pointD.getX();
        double y1 = pointA.getY();
        double y2 = pointB.getY();
        double y3 = pointC.getY();
        double y4 = pointD.getY();

        double denominator=(y4-y3)*(x1-x2)-(x4-x3)*(y1-y2);
        if (denominator == 0){
            return (x1 * y2 - x2 * y1) * (x4 - x3) - (x3 * y4 - x4 * y3) * (x2 - x1) == 0 &&
                    (x1 * y2 - x2 * y1) * (y4 - y3) - (x3 * y4 - x4 * y3) * (y2 - y1) == 0;
        }
        else{
            double numeratorA=(x4-x2)*(y4-y3)-(x4-x3)*(y4-y2);
            double numeratorB=(x1-x2)*(y4-y2)-(x4-x2)*(y1-y2);
            double ua=numeratorA/denominator;
            double ub=numeratorB/denominator;
            return ua >= 0 && ua <= 1 && ub >= 0 && ub <= 1;
        }
    }
}
