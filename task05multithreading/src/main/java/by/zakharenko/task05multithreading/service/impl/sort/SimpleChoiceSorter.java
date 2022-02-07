package by.zakharenko.task05multithreading.service.impl.sort;


import by.zakharenko.task05multithreading.entity.Array;
import by.zakharenko.task05multithreading.entity.exception.EntityException;

public class SimpleChoiceSorter implements Sort{
    /**
     * method sorts the array using simple choice sort
     * @see Sort
     * @param array sortable array
     */
    @Override
    public void sort(Array<Integer> array) throws EntityException {
        for(int min = 0; min < array.getSize() - 1; min++){
            int least = min;
            for(int j = min + 1; j < array.getSize(); j++){
                if(array.getElement(j) < array.getElement(least)){
                    least = j;
                }
            }
            array.swapElements(min, least);
        }
    }
}

