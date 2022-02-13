package by.zakharenko.task06composite.dao.impl;

import by.zakharenko.task06composite.dao.ReaderDAO;
import by.zakharenko.task06composite.dao.exception.DAOException;
import by.zakharenko.task06composite.dao.util.FileResourcesUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReaderDaoTxtImpl implements ReaderDAO {
    @Override
    public String readFile(String path) throws DAOException {
        FileResourcesUtils util = new FileResourcesUtils();
        try {
            return Files.readString(Path.of(util.getFileFromResource(path).toURI()));
        } catch (IOException e) {
            throw new DAOException("Incorrect path");
        }
    }
}
