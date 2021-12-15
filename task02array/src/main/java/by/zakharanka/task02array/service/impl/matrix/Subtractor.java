package by.zakharanka.task02array.service.impl.matrix;

import by.zakharanka.task02array.entity.Matrix;
import by.zakharanka.task02array.entity.exception.EntityException;
import by.zakharanka.task02array.service.exception.ServiceException;

public class Subtractor {
    public Matrix subtract(Matrix matrix1, Matrix matrix2) throws ServiceException, EntityException {
        if(matrix1.getNumRow() != matrix2.getNumRow() || matrix1.getNumColumn() != matrix2.getNumColumn()){
            //TODO: add log
            throw new ServiceException("Error");
        }
        int row = matrix1.getNumRow();
        int column = matrix1.getNumColumn();
        Matrix matrixResult = new Matrix(row, column);
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                matrixResult.setElement(i, j, matrix1.getElement(i, j) - matrix2.getElement(i, j));
            }
        }
        return matrixResult;
    }
}
