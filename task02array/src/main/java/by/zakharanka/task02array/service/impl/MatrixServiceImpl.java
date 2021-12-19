package by.zakharanka.task02array.service.impl;


import by.zakharanka.task02array.entity.Matrix;
import by.zakharanka.task02array.entity.exception.EntityException;
import by.zakharanka.task02array.service.MatrixService;
import by.zakharanka.task02array.service.exception.ServiceException;
import by.zakharanka.task02array.service.impl.matrix.Adder;
import by.zakharanka.task02array.service.impl.matrix.Multiplier;
import by.zakharanka.task02array.service.impl.matrix.Subtractor;
import by.zakharanka.task02array.service.impl.matrix.Transporter;

public class MatrixServiceImpl implements MatrixService {

    @Override
    public String multiplication(Matrix<Integer> matrix1, Matrix<Integer> matrix2) throws ServiceException {
        Multiplier  multiplier = new Multiplier();
        return multiplier.multiply(matrix1, matrix2).toString();
    }

    @Override
    public String addition(Matrix<Integer> matrix1, Matrix<Integer> matrix2) throws ServiceException {
        Adder adder = new Adder();
        try{
            return adder.addition(matrix1, matrix2).toString();
        }catch (EntityException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public String transposition(Matrix<Integer> matrix) {
        Transporter transporter = new Transporter();
        return transporter.transposition(matrix).toString();
    }

    @Override
    public String subtraction(Matrix<Integer> matrix1, Matrix<Integer> matrix2) throws ServiceException {
        Subtractor subtractor = new Subtractor();
        try{
            return subtractor.subtract(matrix1, matrix2).toString();
        } catch (EntityException e){
            throw new ServiceException(e);
        }
    }
}
