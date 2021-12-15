package by.zakharanka.task02array.service.creator;

import by.zakharanka.task02array.dal.ArrayDal;
import by.zakharanka.task02array.dal.MatrixDal;
import by.zakharanka.task02array.dal.exception.DalException;
import by.zakharanka.task02array.dal.factory.DalFactory;
import by.zakharanka.task02array.entity.Array;
import by.zakharanka.task02array.entity.Data;
import by.zakharanka.task02array.entity.Matrix;
import by.zakharanka.task02array.entity.exception.EntityException;
import by.zakharanka.task02array.service.exception.ServiceException;

import java.util.Arrays;
import java.util.Random;

public class ArrayCreator {

    private final String SPLIT_DELIMITER = " ";

    public Array<Integer> createFromDataString(String data) throws ServiceException {
        String[] arrStr = data.split(SPLIT_DELIMITER);
        Integer[] array = new Integer[arrStr.length];
        for(int i = 0; i < arrStr.length; i++){
            try {
                array[i] = Integer.parseInt(arrStr[i]);
            } catch (NumberFormatException e){
                throw new ServiceException("Not correct data into file");
            }
        }
        return new Array<>(array);
    }

    public Array<Integer> createFromFile(String path) throws ServiceException {
        try{
            DalFactory dalFactory = DalFactory.getInstance();
            ArrayDal arrayDal = dalFactory.getTxtFileArrayDal();
            return createFromDataString(arrayDal.readArray(path));
        }catch (DalException e){
            throw new ServiceException(e);
        }
    }

    public Array<Integer> createRandom(String data) throws ServiceException, EntityException {
        String[] arr = data.split(SPLIT_DELIMITER);
        int size;
        int minValue;
        int maxValue;
        try {
            size = Integer.parseInt(arr[0]);
            minValue = Integer.parseInt(arr[1]);
            maxValue = Integer.parseInt(arr[2]);
        } catch(NumberFormatException | ArrayIndexOutOfBoundsException e){
            throw new ServiceException("Not Correct random data");
        }
        Array<Integer> array = new Array<>(new Integer[size]);
        for(int i = 0; i < size; i++){
            Random random = new Random();
            try {
                array.setElement(i, (Math.abs(random.nextInt()) + minValue) % maxValue);
            } catch (EntityException e){
                throw new ServiceException(e);
            }
        }
        return array;
    }

    public Array<Integer> createArray(String fillMethod, String data) throws ServiceException, EntityException {
        return switch (fillMethod){
            case "FROM_FILE" -> createFromFile(data);
            case "RANDOM" -> createRandom(data);
            default -> throw new ServiceException("Wrong_Fill");
        };
    }

}
