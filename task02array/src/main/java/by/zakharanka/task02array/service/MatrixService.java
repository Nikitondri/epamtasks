package by.zakharanka.task02array.service;


import by.zakharanka.task02array.entity.Matrix;
import by.zakharanka.task02array.entity.exception.EntityException;
import by.zakharanka.task02array.service.exception.ServiceException;

public interface MatrixService {
    String multiplication(Matrix<Integer> matrix1, Matrix<Integer> matrix2) throws ServiceException, EntityException;
    String addition(Matrix<Integer> matrix1, Matrix<Integer> matrix2) throws ServiceException;
    String transposition(Matrix<Integer> matrix);
    String subtraction(Matrix<Integer> matrix1, Matrix<Integer> matrix2) throws ServiceException;
}
