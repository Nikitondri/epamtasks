package by.zakharanka.task03innerclass.service.creator;

import by.zakharanka.task03innerclass.service.exception.ServiceException;

public interface Creator<T> {
    T createFromFile(String path) throws ServiceException;
}
