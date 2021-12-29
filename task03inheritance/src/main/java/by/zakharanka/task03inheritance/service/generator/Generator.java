package by.zakharanka.task03inheritance.service.generator;

import by.zakharanka.task03inheritance.service.exception.ServiceException;

public interface Generator {
    void generateRandomDataToFile() throws ServiceException;

}
