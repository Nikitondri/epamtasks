package by.zakharanka.task02array.dal.impl;

import by.zakharanka.task02array.dal.ArrayDal;
import by.zakharanka.task02array.dal.exception.DalException;
import by.zakharanka.task02array.dal.reader.ArrayReader;


public class TxtFileArrayDal implements ArrayDal {
    /**
     * the method encapsulates the action of reading a array from a file
     * @see ArrayDal
     * @see ArrayReader
     * @param path the path to the file
     * @return a string containing an array
     */
    @Override
    public String readArray(String path) throws DalException {
        ArrayReader arrayReader = new ArrayReader(path);
        return arrayReader.readArray();
    }
}
