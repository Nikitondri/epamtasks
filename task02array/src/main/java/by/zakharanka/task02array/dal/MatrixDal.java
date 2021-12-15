package by.zakharanka.task02array.dal;

import by.zakharanka.task02array.dal.exception.DalException;
import by.zakharanka.task02array.entity.Data;

public interface MatrixDal {
    Data<String> readMatrix(String path) throws DalException;
}
