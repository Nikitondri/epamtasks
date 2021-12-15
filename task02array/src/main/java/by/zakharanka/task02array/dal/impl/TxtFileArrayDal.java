package by.zakharanka.task02array.dal.impl;

import by.zakharanka.task02array.dal.ArrayDal;
import by.zakharanka.task02array.dal.exception.DalException;
import by.zakharanka.task02array.dal.reader.ArrayReader;

public class TxtFileArrayDal implements ArrayDal {
    @Override
    public String readArray(String path) throws DalException {
        ArrayReader arrayReader = new ArrayReader(path);
        return arrayReader.readArray();
    }
}
