package by.zakharanka.task02array.dal.impl;

import by.zakharanka.task02array.dal.MatrixDal;
import by.zakharanka.task02array.dal.exception.DalException;
import by.zakharanka.task02array.dal.reader.MatrixReader;
import by.zakharanka.task02array.entity.Data;

public class TxtFileMatrixDal implements MatrixDal {

    /**
     * the method encapsulates the action of reading a matrix from a file
     * @see MatrixDal
     * @see MatrixReader
     * @param path the path to the file
     * @return a string containing an matrix
     */
    @Override
    public Data<String> readMatrix(String path) throws DalException {
        MatrixReader matrixReader = new MatrixReader(path);
        return matrixReader.readMatrix();
    }
}
