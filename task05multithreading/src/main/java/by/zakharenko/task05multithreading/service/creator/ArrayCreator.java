package by.zakharenko.task05multithreading.service.creator;

import by.zakharenko.task05multithreading.dal.ArrayDal;
import by.zakharenko.task05multithreading.dal.exception.DalException;
import by.zakharenko.task05multithreading.dal.factory.DalFactory;
import by.zakharenko.task05multithreading.entity.Array;
import by.zakharenko.task05multithreading.service.exception.ServiceException;


public class ArrayCreator implements Creator<Array<Integer>> {

    private static final String SPLIT_DELIMITER = " ";

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

    @Override
    public Array<Integer> create(String path) throws ServiceException {
        try{
            DalFactory dalFactory = DalFactory.getInstance();
            ArrayDal arrayDal = dalFactory.getTxtFileArrayDal();
            return createFromDataString(arrayDal.readArray(path));
        }catch (DalException e){
            throw new ServiceException(e);
        }
    }

}
