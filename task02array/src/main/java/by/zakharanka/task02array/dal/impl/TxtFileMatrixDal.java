package by.zakharanka.task02array.dal.impl;

import by.zakharanka.task02array.dal.MatrixDal;
import by.zakharanka.task02array.dal.exception.DalException;
import by.zakharanka.task02array.dal.reader.MatrixReader;
import by.zakharanka.task02array.entity.Data;

public class TxtFileMatrixDal implements MatrixDal {
    @Override
    public Data<String> readMatrix(String path) throws DalException {
        MatrixReader matrixReader = new MatrixReader(path);
        return matrixReader.readMatrix();
    }
}
