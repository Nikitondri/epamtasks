package by.zakharenko.task05multithreading.dal.impl;

import by.zakharenko.task05multithreading.dal.MatrixDal;
import by.zakharenko.task05multithreading.dal.exception.DalException;
import by.zakharenko.task05multithreading.dal.reader.MatrixReader;
import by.zakharenko.task05multithreading.dal.util.FileResourcesUtils;
import by.zakharenko.task05multithreading.entity.Data;

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
        FileResourcesUtils fileResourcesUtils = new FileResourcesUtils();
        MatrixReader matrixReader = new MatrixReader(fileResourcesUtils.getFileFromResource(path).getPath());
        return matrixReader.readMatrix();
    }
}
