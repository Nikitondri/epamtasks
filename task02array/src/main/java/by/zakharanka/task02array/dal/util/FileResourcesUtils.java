package by.zakharanka.task02array.dal.util;

import by.zakharanka.task02array.dal.exception.DalException;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class FileResourcesUtils {
    public File getFileFromResource(String fileName) throws DalException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new DalException("file not found!");
        } else {
            try {
                return new File(resource.toURI());
            } catch (URISyntaxException e) {
                throw new DalException("File Not correct");
            }
        }

    }
}
