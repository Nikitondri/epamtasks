package by.zakharanka.task02array.service.impl.sort;

import by.zakharanka.task02array.entity.Array;
import by.zakharanka.task02array.entity.exception.EntityException;

@FunctionalInterface
public interface Sort {
    void sort(Array<Integer> array) throws EntityException;
}
