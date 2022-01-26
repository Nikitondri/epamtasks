package by.zakharenko.task04oop.dao;

import by.zakharenko.task04oop.dao.exception.DAOException;

import java.util.List;

public interface ReaderDAO {
    List<String> readFile(String path) throws DAOException;
}
