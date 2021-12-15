package by.zakharanka.task02array.dal;

import by.zakharanka.task02array.dal.exception.DalException;

public interface ArrayDal {
    String readArray(String path) throws DalException;
}
