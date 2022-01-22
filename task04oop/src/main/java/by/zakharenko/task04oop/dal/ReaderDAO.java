package by.zakharenko.task04oop.dal;

import by.zakharenko.task04oop.dal.exception.DAOException;

import java.util.List;

public interface ReaderDAO {
    List<String> readFile(String path) throws DAOException;
}
