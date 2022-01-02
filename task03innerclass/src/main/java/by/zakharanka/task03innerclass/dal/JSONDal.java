package by.zakharanka.task03innerclass.dal;

import by.zakharanka.task03innerclass.dal.exception.DalException;
import by.zakharanka.task03innerclass.entity.Date;

public interface JSONDal {
    Date readDateFromJSON(String path) throws DalException;
    int readYearFromJSON(String path) throws DalException;
    void writeYearToJSON(String path, Integer year) throws DalException;
    void writeDateToJSON(String path, Date date) throws DalException;
}
