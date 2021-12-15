package by.zakharanka.task02array.service;


import by.zakharanka.task02array.entity.Matrix;
import by.zakharanka.task02array.entity.exception.EntityException;
import by.zakharanka.task02array.service.exception.ServiceException;

public interface MatrixService {
    String multiplication(Matrix matrix1, Matrix matrix2) throws ServiceException, EntityException;
    String addition(Matrix matrix1, Matrix matrix2) throws ServiceException;
    String transposition(Matrix matrix);
    String subtraction(Matrix matrix1, Matrix matrix2) throws ServiceException;
}
