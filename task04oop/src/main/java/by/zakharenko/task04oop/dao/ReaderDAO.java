package by.zakharenko.task04oop.dao;

import by.zakharenko.task04oop.dao.exception.DAOException;

import java.util.List;

/**
 * an interface that uses classes that read string data
 * from a file and return a list of strings
 */
public interface ReaderDAO {
    List<String> readFile(String path) throws DAOException;
}
