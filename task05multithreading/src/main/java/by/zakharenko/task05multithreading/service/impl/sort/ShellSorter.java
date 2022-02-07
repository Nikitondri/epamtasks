package by.zakharenko.task05multithreading.service.impl.sort;


import by.zakharenko.task05multithreading.entity.Array;
import by.zakharenko.task05multithreading.entity.exception.EntityException;

public class ShellSorter implements Sort{
    /**
     * method sorts the array using shell sort
     * @see Sort
     * @param array sortable array
     */
    @Override
    public void sort(Array<Integer> array) throws EntityException {
        for(int step = array.getSize() / 2; step > 0; step /= 2){
            for(int i = step; i < array.getSize(); i++){
                for(int j = i - step; j >= 0 && array.getElement(j) > array.getElement(j + step); j -= step){
                    array.swapElements(j, j + step);
                }
            }
        }
    }
}

