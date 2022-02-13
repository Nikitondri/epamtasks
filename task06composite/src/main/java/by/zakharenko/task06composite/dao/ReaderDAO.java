package by.zakharenko.task06composite.dao;

import by.zakharenko.task06composite.dao.exception.DAOException;

public interface ReaderDAO {
    String readFile(String path) throws DAOException;
}
