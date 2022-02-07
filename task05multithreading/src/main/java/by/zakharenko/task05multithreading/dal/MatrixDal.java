package by.zakharenko.task05multithreading.dal;

import by.zakharenko.task05multithreading.dal.exception.DalException;
import by.zakharenko.task05multithreading.entity.Data;

public interface MatrixDal {
    Data<String> readMatrix(String path) throws DalException;
}
