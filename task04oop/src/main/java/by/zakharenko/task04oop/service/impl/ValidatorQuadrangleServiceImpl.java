package by.zakharenko.task04oop.service.impl;

import by.zakharenko.task04oop.entity.Point;
import by.zakharenko.task04oop.entity.Quadrangle;
import by.zakharenko.task04oop.service.PointService;
import by.zakharenko.task04oop.service.ValidatorService;
import by.zakharenko.task04oop.service.factory.ServiceFactory;

public class ValidatorQuadrangleServiceImpl implements ValidatorService<Quadrangle> {

    /** method for validating the received string */
    @Override
    public boolean isCorrectLine(String line) {
        return line.matches("\\w+(\\s+\\d+\\.\\d+){8}");
    }

    /**
     * a method that checks the validity of an {@code Quadrangle} object
     * checks if the points do not lie on the same line
     * eliminates the intersection of segments
     * @see PointService
     */
    @Override
    public boolean isCorrectObject(Quadrangle quadrangle) {
        PointService pointService = ServiceFactory.getInstance().getPointService();
        boolean isCorrect = !pointService.isOnOneLine(quadrangle.getPointA(), quadrangle.getPointB(), quadrangle.getPointC()) &&
                !pointService.isOnOneLine(quadrangle.getPointA(), quadrangle.getPointB(), quadrangle.getPointD()) &&
                !pointService.isOnOneLine(quadrangle.getPointA(), quadrangle.getPointC(), quadrangle.getPointD()) &&
                !pointService.isOnOneLine(quadrangle.getPointB(), quadrangle.getPointC(), quadrangle.getPointD());
        if(isCorrect){
            if(pointService.isSegmentsIntersect(quadrangle.getPointA(), quadrangle.getPointB(), quadrangle.getPointC(), quadrangle.getPointD())){
                Point temp = quadrangle.getPointB();
                quadrangle.setPointB(quadrangle.getPointC());
                quadrangle.setPointC(temp);
            }
            return true;
        } else {
            return false;
        }
    }
}
