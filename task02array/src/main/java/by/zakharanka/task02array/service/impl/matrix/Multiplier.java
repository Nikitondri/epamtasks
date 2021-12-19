package by.zakharanka.task02array.service.impl.matrix;

import by.zakharanka.task02array.entity.Matrix;
import by.zakharanka.task02array.entity.exception.EntityException;
import by.zakharanka.task02array.service.exception.ServiceException;

/**
 * class that implements matrix multiply
 */
public class Multiplier {

    /**
     * a method of multiplying two matrices that implements a
     * mathematical algorithm for matrix multiplication
     * @param p multiplier
     * @param q multiplier
     * @return product
     */
    public Matrix<Integer> multiply(Matrix<Integer> p, Matrix<Integer> q) throws ServiceException {
        int v = p.getNumRow();
        int h = q.getNumColumn();
        int controlSize = p.getNumColumn();
        if (controlSize != q.getNumRow()) {
            throw new ServiceException("incompatible matrices");
        }
        Matrix<Integer> result = new Matrix<>(new Integer[v][h]);
        try {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < h; j++) {
                    int value = 0;
                    for (int k = 0; k < controlSize; k++) {
                        value += p.getElement(i, k) * q.getElement(k, j);
                    }
                    result.setElement(i, j, value);
                }
            }
        } catch (EntityException e) {
            throw new ServiceException("Not correct matrix");
        }
        return result;
    }
}
