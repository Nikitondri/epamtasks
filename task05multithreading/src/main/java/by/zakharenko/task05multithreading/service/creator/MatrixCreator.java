package by.zakharenko.task05multithreading.service.creator;

import by.zakharenko.task05multithreading.dal.MatrixDal;
import by.zakharenko.task05multithreading.dal.exception.DalException;
import by.zakharenko.task05multithreading.dal.factory.DalFactory;
import by.zakharenko.task05multithreading.entity.Data;
import by.zakharenko.task05multithreading.entity.Matrix;
import by.zakharenko.task05multithreading.service.exception.ServiceException;

import java.util.Arrays;

public class MatrixCreator implements Creator<Matrix<Integer>> {

    private static final String SPLIT_DELIMITER = " ";

    private Matrix<Integer> createFromDataString(Data<String> data) throws ServiceException {
        int row = data.findSize();
        int[][] matrix = new int[row][];
        for(int i = 0; i < row; i++){
            try {
                matrix[i] = Arrays.stream(data.getElement(i).split(SPLIT_DELIMITER)).mapToInt(Integer::parseInt).toArray();
            } catch (NumberFormatException e){
                throw new ServiceException("Not correct data in file");
            }
        }
        Integer[][] matrixResult = new Integer[matrix.length][matrix[0].length];
        for(int i = 0; i < matrixResult.length; i++){
            for(int j = 0; j < matrixResult[0].length; j++){
                matrixResult[i][j] = matrix[i][j];
            }
        }
        return new Matrix<>(matrixResult);
    }

    @Override
    public Matrix<Integer> create(String path) throws ServiceException {
        try{
            DalFactory dalFactory = DalFactory.getInstance();
            MatrixDal matrixDal = dalFactory.getTxtFileMatrixDal();
            return createFromDataString(matrixDal.readMatrix(path));
        }catch (DalException e){
            throw new ServiceException(e);
        }
    }

}
