package by.zakharanka.task02array.service.impl.matrix;

import by.zakharanka.task02array.entity.Matrix;

/**
 * class that implements matrix Transposition
 */
public class Transporter {

    /**
     * the method implements the transposition of matrices by swapping the required elements of the matrix
     * @param matrix for later transposition
     * @return transposed matrix
     */
    public Matrix<Integer> transposition(Matrix<Integer> matrix){
        for(int i = 0; i < matrix.getNumRow(); i++){
            for(int j = i; j < matrix.getNumColumn(); j++){
                matrix.swapElements(i, j, j, i);
            }
        }
        return matrix;
    }
}
