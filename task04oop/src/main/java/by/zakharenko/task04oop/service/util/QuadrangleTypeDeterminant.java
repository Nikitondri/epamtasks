package by.zakharenko.task04oop.service.util;

import by.zakharenko.task04oop.entity.Quadrangle;
import by.zakharenko.task04oop.entity.QuadrangleType;
import by.zakharenko.task04oop.service.PointService;
import by.zakharenko.task04oop.service.factory.ServiceFactory;

public class QuadrangleTypeDeterminant {

    private final double ab;
    private final double bc;
    private final double cd;
    private final double da;
    private final double ac;
    private final double bd;
    private final Quadrangle quadrangle;

    public QuadrangleTypeDeterminant(Quadrangle quadrangle) {
        PointService pointService = ServiceFactory.getInstance().getPointService();
        ab = pointService.findLength(quadrangle.getPointA(), quadrangle.getPointB());
        bc = pointService.findLength(quadrangle.getPointB(), quadrangle.getPointC());
        cd = pointService.findLength(quadrangle.getPointC(), quadrangle.getPointD());
        da = pointService.findLength(quadrangle.getPointD(), quadrangle.getPointA());
        ac = pointService.findLength(quadrangle.getPointA(), quadrangle.getPointC());
        bd = pointService.findLength(quadrangle.getPointB(), quadrangle.getPointD());
        this.quadrangle = quadrangle;
    }

    private boolean isSquare(){
        return ab == bc && ab == cd && ab == da && ac == bd;
    }

    private boolean isRhombus(){
        return ab == bc && ab == cd && ab == da && ac != bd;
    }

    private boolean isRectangle(){
        return ab != bc && ab == cd && ab != da && bc == da && ac == bd;
    }

    private boolean isParallelogram(){
        return ab != bc && ab == cd && ab != da && bc == da && ac != bd;
    }

    private boolean isTrapeze(){
        double x1 = quadrangle.getPointA().getX();
        double x2 = quadrangle.getPointB().getX();
        double x3 = quadrangle.getPointC().getX();
        double x4 = quadrangle.getPointD().getX();
        double y1 = quadrangle.getPointA().getY();
        double y2 = quadrangle.getPointB().getY();
        double y3 = quadrangle.getPointC().getY();
        double y4 = quadrangle.getPointD().getY();
        return ((x1 - x2) * (y3 - y4) == (y1 - y2) * (x3 - x4) && ab != cd) ||
                ((x1 - x4) * (y2 - y3) == (y1 - y4) * (x2 - x3) && da != bc);
    }

    public QuadrangleType determineType(){
        if(isSquare()){
            return QuadrangleType.SQUARE;
        } else if(isRectangle()){
            return QuadrangleType.RECTANGLE;
        } else if(isParallelogram()){
            return QuadrangleType.PARALLELOGRAM;
        } else if(isRhombus()){
            return QuadrangleType.RHOMBUS;
        } else if(isTrapeze()){
            return QuadrangleType.TRAPEZE;
        } else {
            return QuadrangleType.ARBITRARY;
        }
    }
}
