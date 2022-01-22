package by.zakharanka.task02array.service.impl.matrix;

import by.zakharanka.task02array.entity.Matrix;
import by.zakharanka.task02array.entity.exception.EntityException;
import by.zakharanka.task02array.service.exception.ServiceException;

/**
 * class that implements matrix addition
 */
public class Adder {

    /**
     * method implements matrix addition
     * addition sequentially from each element of the reduced each element of the added
     * @param matrix1 term
     * @param matrix2 term
     * @return sum
     */
    //TODO: parametrization
    public Matrix<Integer> addition(Matrix<Integer> matrix1, Matrix<Integer> matrix2) throws ServiceException, EntityException {
        if(matrix1.getNumRow() != matrix2.getNumRow() || matrix1.getNumColumn() != matrix2.getNumColumn()){
            throw new ServiceException("Not correct sizes Matrix");
        }
        int row = matrix1.getNumRow();
        int column = matrix1.getNumColumn();
        Matrix<Integer> matrixResult = new Matrix<>(new Integer[row][column]);
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                matrixResult.setElement(i, j, matrix1.getElement(i, j) + matrix2.getElement(i, j));
            }
        }
        return matrixResult;
    }
}
