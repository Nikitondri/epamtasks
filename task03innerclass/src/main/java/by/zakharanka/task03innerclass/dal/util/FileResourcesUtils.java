package by.zakharanka.task03innerclass.dal.util;

import by.zakharanka.task03innerclass.dal.exception.DalException;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class FileResourcesUtils {
    public static final String ERROR_PATH = "file not found!";
    public static final String ERROR_FILE = "file Not correct";

    public File getFileFromResource(String fileName) throws DalException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new DalException(ERROR_PATH);
        } else {
            try {
                return new File(resource.toURI());
            } catch (URISyntaxException e) {
                throw new DalException(ERROR_FILE);
            }
        }

    }
}
