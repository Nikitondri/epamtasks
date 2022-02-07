package by.zakharenko.task05multithreading.dal.impl;

import by.zakharenko.task05multithreading.dal.ArrayDal;
import by.zakharenko.task05multithreading.dal.exception.DalException;
import by.zakharenko.task05multithreading.dal.reader.ArrayReader;
import by.zakharenko.task05multithreading.dal.util.FileResourcesUtils;

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
        FileResourcesUtils fileResourcesUtils = new FileResourcesUtils();
        ArrayReader arrayReader = new ArrayReader(fileResourcesUtils.getFileFromResource(path).getPath());
        return arrayReader.readArray();
    }
}
