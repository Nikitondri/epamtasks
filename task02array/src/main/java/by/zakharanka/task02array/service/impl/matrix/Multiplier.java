package by.zakharanka.task02array.service.impl.matrix;

import by.zakharanka.task02array.entity.Matrix;
import by.zakharanka.task02array.entity.exception.EntityException;
import by.zakharanka.task02array.service.creator.MatrixCreator;
import by.zakharanka.task02array.service.exception.ServiceException;

public class Multiplier {
    public Matrix multiply(Matrix p, Matrix q) throws EntityException, ServiceException {
        int v = p.getNumRow();
        int h = q.getNumColumn();
        int controlSize = p.getNumColumn();
        if (controlSize != q.getNumRow()) {
            throw new ServiceException("incompatible matrices");
        }
        MatrixCreator matrixCreator = new MatrixCreator();
        Matrix result = new Matrix(matrixCreator.createArray(v, h));
        try {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < h; j++) {
                    int value = 0;
                    for (int k = 0; k < controlSize; k++) {
                        value += (Integer)p.getElement(i, k) * (Integer)q.getElement(k, j);
                    }
                    result.setElement(i, j, value);
                }
            }
        } catch (EntityException e) {
            // TODO: add log;
        }
        return result;
    }
}
