package by.zakharenko.task05multithreading.service.creator;

import by.zakharenko.task05multithreading.service.exception.ServiceException;

public interface Creator<T> {
    T create(String path) throws ServiceException;

}
