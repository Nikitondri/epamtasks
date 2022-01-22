package by.zakharenko.task04oop.service.impl;

import by.zakharenko.task04oop.entity.Point;
import by.zakharenko.task04oop.entity.Quadrangle;
import by.zakharenko.task04oop.service.PointService;
import by.zakharenko.task04oop.service.QuadrangleService;
import by.zakharenko.task04oop.service.factory.ServiceFactory;

public class QuadrangleServiceImpl implements QuadrangleService {

    @Override
    public double findPerimeter(Quadrangle quadrangle) {
        PointService pointService = ServiceFactory.getInstance().getPointService();
        return pointService.findLength(quadrangle.getPointA(), quadrangle.getPointB()) +
                pointService.findLength(quadrangle.getPointB(), quadrangle.getPointC()) +
                pointService.findLength(quadrangle.getPointC(), quadrangle.getPointD()) +
                pointService.findLength(quadrangle.getPointD(), quadrangle.getPointA());
    }

    @Override
    public double findArea(Quadrangle quadrangle) {
        PointService pointService = ServiceFactory.getInstance().getPointService();
        double ab = pointService.findLength(quadrangle.getPointA(), quadrangle.getPointB());
        double bc = pointService.findLength(quadrangle.getPointB(), quadrangle.getPointC());
        double cd = pointService.findLength(quadrangle.getPointC(), quadrangle.getPointD());
        double da = pointService.findLength(quadrangle.getPointD(), quadrangle.getPointA());
        double ac = pointService.findLength(quadrangle.getPointA(), quadrangle.getPointC());
        double bd = pointService.findLength(quadrangle.getPointB(), quadrangle.getPointD());
        return 0.25 * Math.sqrt(4 * ac * ac * bd * bd - Math.pow((ab * ab + cd * cd - bc * bc - da * da), 2));
    }

    @Override
    public boolean isConvex(Quadrangle quadrangle) {
        Point pA = quadrangle.getPointA();
        Point pB = quadrangle.getPointB();
        Point pC = quadrangle.getPointC();
        Point pD = quadrangle.getPointD();
        return area(pA, pB, pC) * area(pC, pD, pA) > 0 && area(pB, pC, pD) * area(pD, pA, pB) > 0;
    }

    private double area(Point pointA, Point pointB, Point pointC){
        return (pointA.getX() * (pointB.getY() - pointC.getY())) +
                (pointB.getX() * (pointC.getY() - pointA.getY())) +
                (pointC.getX() * (pointA.getY() - pointB.getY()));
    }
}
