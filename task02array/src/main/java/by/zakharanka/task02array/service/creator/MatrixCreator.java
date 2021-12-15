package by.zakharanka.task02array.service.creator;

import by.zakharanka.task02array.dal.MatrixDal;
import by.zakharanka.task02array.dal.exception.DalException;
import by.zakharanka.task02array.dal.factory.DalFactory;
import by.zakharanka.task02array.entity.Data;
import by.zakharanka.task02array.entity.Matrix;
import by.zakharanka.task02array.entity.exception.EntityException;
import by.zakharanka.task02array.service.exception.ServiceException;

import java.util.Arrays;
import java.util.Random;

public class MatrixCreator {

    private final String SPLIT_DELIMITER = " ";

    public int[][] createArray(String arg) {
        return null;
    }

    public int[][] createArray(int row, int column){
        return new int[row][column];
    }

    public Matrix createFromDataString(Data<String> data) throws ServiceException{
        int row = data.findSize();
        int[][] matrix = new int[row][];
        for(int i = 0; i < row; i++){
            try {
                matrix[i] = Arrays.stream(data.getElement(i).split(SPLIT_DELIMITER)).mapToInt(Integer::parseInt).toArray();
            } catch (NumberFormatException e){
                throw new ServiceException("Not correct data in file");
            }
        }
        return new Matrix(matrix);
    }

    public Matrix createFromFile(String path) throws ServiceException {
        try{
            DalFactory dalFactory = DalFactory.getInstance();
            MatrixDal matrixDal = dalFactory.getTxtFileMatrixDal();
            return createFromDataString(matrixDal.readMatrix(path));
        }catch (DalException e){
            throw new ServiceException(e);
        }
    }

    public Matrix createRandom(String data) throws ServiceException, EntityException {
        String[] arr = data.split(SPLIT_DELIMITER);
        int row;
        int column;
        int minValue;
        int maxValue;
        try{
            row = Integer.parseInt(arr[0]);
            column = Integer.parseInt(arr[1]);
            minValue = Integer.parseInt(arr[2]);
            maxValue = Integer.parseInt(arr[3]);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
            throw new ServiceException("Not correct random data");
        }
        Matrix matrix = new Matrix(row ,column);
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                Random random = new Random();
                try {
                    matrix.setElement(i, j, (Math.abs(random.nextInt()) + minValue) % maxValue);
                } catch (EntityException e){
                    throw new ServiceException(e);
                }
            }
        }
        return matrix;
    }

    public Matrix createMatrix(String fillMethod, String data) throws ServiceException, EntityException {
        return switch (fillMethod){
            case "FROM_FILE" -> createFromFile(data);
            case "RANDOM" -> createRandom(data);
            default -> throw new ServiceException();
        };
    }

}
