package by.zakharenko.task05multithreading.service;


import by.zakharenko.task05multithreading.entity.Matrix;
import by.zakharenko.task05multithreading.entity.exception.EntityException;
import by.zakharenko.task05multithreading.service.exception.ServiceException;

public interface MatrixService {
    String multiplication(Matrix<Integer> matrix1, Matrix<Integer> matrix2) throws ServiceException, EntityException;
    String multiplicationByNumber(Matrix<Integer> matrix1, Integer number) throws ServiceException, EntityException;
    String addition(Matrix<Integer> matrix1, Matrix<Integer> matrix2) throws ServiceException;
    String transposition(Matrix<Integer> matrix) throws ServiceException;
    String subtraction(Matrix<Integer> matrix1, Matrix<Integer> matrix2) throws ServiceException;
}
