package by.zakharenko.task05multithreading.service.impl.sort;

import by.zakharenko.task05multithreading.entity.Array;
import by.zakharenko.task05multithreading.entity.exception.EntityException;

public class SimpleInsertSorter implements Sort{
    /**
     * method sorts the array using simple insert sort
     * @see Sort
     * @param array sortable array
     */
    @Override
    public void sort(Array<Integer> array) throws EntityException {
        for(int i = 1; i < array.getSize(); i++){
            for(int j = i; j > 0 && array.getElement(j - 1) > array.getElement(j); j--){
                array.swapElements(j, j - 1);
            }
        }
    }
}
