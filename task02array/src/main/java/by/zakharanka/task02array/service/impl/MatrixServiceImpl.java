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

    /**
     * calls the multiplication method from the class {@code Multiplier}
     * @see Multiplier
     * @see MatrixService
     * @param matrix1 factor
     * @param matrix2 factor
     * @return the string with the result of the multiplication
     */
    @Override
    public String multiplication(Matrix<Integer> matrix1, Matrix<Integer> matrix2) throws ServiceException {
        Multiplier  multiplier = new Multiplier();
        return multiplier.multiply(matrix1, matrix2).toString();
    }

    /**
     * calls the addition method from the class {@code Adder}
     * @see Adder
     * @see MatrixService
     * @param matrix1 term
     * @param matrix2 term
     * @return the string with the result of the addition
     */
    @Override
    public String addition(Matrix<Integer> matrix1, Matrix<Integer> matrix2) throws ServiceException {
        Adder adder = new Adder();
        try{
            return adder.addition(matrix1, matrix2).toString();
        }catch (EntityException e){
            throw new ServiceException(e);
        }
    }

    /**
     * calls the transposition method from the class {@code Transporter}
     * @see Transporter
     * @see MatrixService
     * @param matrix transpose matrix
     * @return the string with the result of the transposition
     */
    @Override
    public String transposition(Matrix<Integer> matrix) {
        Transporter transporter = new Transporter();
        return transporter.transposition(matrix).toString();
    }

    /**
     * calls the subtract method from the class {@code Subtractor}
     * @see Subtractor
     * @see MatrixService
     * @param matrix1 decreasing
     * @param matrix2 subtraction
     * @return the string with the result of the subtraction
     */
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
