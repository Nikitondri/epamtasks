package by.zakharanka.task03inheritance.service.creator;

import by.zakharanka.task03inheritance.service.exception.ServiceException;

public interface Creator<T> {
    T createFromFile(String path) throws ServiceException;
}
