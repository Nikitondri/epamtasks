package by.zakharenko.task04oop.dal.util;

import by.zakharenko.task04oop.dal.exception.DAOException;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class FileResourcesUtils {
    public static final String ERROR_PATH = "file not found!";
    public static final String ERROR_FILE = "file Not correct";

    public File getFileFromResource(String fileName) throws DAOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new DAOException(ERROR_PATH);
        } else {
            try {
                return new File(resource.toURI());
            } catch (URISyntaxException e) {
                throw new DAOException(ERROR_FILE);
            }
        }

    }
}
