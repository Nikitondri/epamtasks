package by.zakharenko.task05multithreading.dal;

import by.zakharenko.task05multithreading.dal.exception.DalException;

public interface ArrayDal {
    String readArray(String path) throws DalException;
}
