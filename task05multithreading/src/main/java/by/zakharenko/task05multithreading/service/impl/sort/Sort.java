package by.zakharenko.task05multithreading.service.impl.sort;

import by.zakharenko.task05multithreading.entity.Array;
import by.zakharenko.task05multithreading.entity.exception.EntityException;
import by.zakharenko.task05multithreading.service.exception.ServiceException;

@FunctionalInterface
public interface Sort {
    void sort(Array<Integer> array) throws EntityException, ServiceException;
}
