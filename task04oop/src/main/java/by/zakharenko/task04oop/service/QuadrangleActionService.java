package by.zakharenko.task04oop.service;

import by.zakharenko.task04oop.entity.Point;
import by.zakharenko.task04oop.entity.Quadrangle;
import by.zakharenko.task04oop.service.comparator.QuadrangleComparatorType;
import by.zakharenko.task04oop.service.exception.ServiceException;

import java.util.List;

public interface QuadrangleActionService {
    void addQuadranglesFromFile(String path) throws ServiceException;
    List<Quadrangle> sort(QuadrangleComparatorType type);
    void setName(long id, String newName) throws ServiceException;
    void setPoint(long id, Point newPoint, int numPoint) throws ServiceException;
    Quadrangle findQuadrangle(long id);
    String findParameter(long id, String parameterType) throws ServiceException;
    boolean removeQuadrangle(long id);
}
