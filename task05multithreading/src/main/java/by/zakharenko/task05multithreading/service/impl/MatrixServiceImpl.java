package by.zakharenko.task05multithreading.service.impl;


import by.zakharenko.task05multithreading.entity.Matrix;
import by.zakharenko.task05multithreading.service.MatrixService;
import by.zakharenko.task05multithreading.service.exception.ServiceException;
import by.zakharenko.task05multithreading.service.impl.matrix.*;

public class MatrixServiceImpl implements MatrixService {

    /**
     * calls the multiplication method from the class {@code Multiplier}
     * @see MultiplierMultithreaded
     * @see MatrixService
     * @param matrix1 factor
     * @param matrix2 factor
     * @return the string with the result of the multiplication
     */
    @Override
    public String multiplication(Matrix<Integer> matrix1, Matrix<Integer> matrix2) throws ServiceException {
        MultiplierMultithreaded multiplierMultithreaded = new MultiplierMultithreaded();
        return multiplierMultithreaded.multiply(matrix1, matrix2).toString();
    }

    @Override
    public String multiplicationByNumber(Matrix<Integer> matrix1, Integer number) {
        MultiplierByNumberMultithreaded multiplierByNumberMultithreaded = new MultiplierByNumberMultithreaded();
        return multiplierByNumberMultithreaded.multiply(matrix1, number).toString();
    }

    /**
     * calls the addition method from the class {@code Adder}
     * @see AdderMultithreaded
     * @see MatrixService
     * @param matrix1 term
     * @param matrix2 term
     * @return the string with the result of the addition
     */
    @Override
    public String addition(Matrix<Integer> matrix1, Matrix<Integer> matrix2) throws ServiceException {
        AdderMultithreaded adderMultithreaded = new AdderMultithreaded();
        try{
            return adderMultithreaded.addition(matrix1, matrix2).toString();
        }catch (ServiceException e){
            throw new ServiceException(e);
        }
    }

    /**
     * calls the transposition method from the class {@code Transporter}
     * @see TransporterMultithreaded
     * @see MatrixService
     * @param matrix transpose matrix
     * @return the string with the result of the transposition
     */
    @Override
    public String transposition(Matrix<Integer> matrix) {
        TransporterMultithreaded transporterMultithreaded = new TransporterMultithreaded();
        return transporterMultithreaded.transposition(matrix).toString();
    }

    /**
     * calls the subtract method from the class {@code Subtractor}
     * @see SubtractorMultithreaded
     * @see MatrixService
     * @param matrix1 decreasing
     * @param matrix2 subtraction
     * @return the string with the result of the subtraction
     */
    @Override
    public String subtraction(Matrix<Integer> matrix1, Matrix<Integer> matrix2) throws ServiceException {
        SubtractorMultithreaded subtractorMultithreaded = new SubtractorMultithreaded();
        try{
            return subtractorMultithreaded.subtract(matrix1, matrix2).toString();
        } catch (ServiceException e){
            throw new ServiceException(e);
        }
    }
}
