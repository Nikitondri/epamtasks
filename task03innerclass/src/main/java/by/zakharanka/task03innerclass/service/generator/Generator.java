package by.zakharanka.task03innerclass.service.generator;

import by.zakharanka.task03innerclass.service.exception.ServiceException;

public interface Generator {
    void generateRandomDataToFile() throws ServiceException;
}
