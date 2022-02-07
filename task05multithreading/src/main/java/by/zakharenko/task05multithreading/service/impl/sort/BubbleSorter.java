package by.zakharenko.task05multithreading.service.impl.sort;


import by.zakharenko.task05multithreading.entity.Array;
import by.zakharenko.task05multithreading.entity.exception.EntityException;

public class BubbleSorter implements Sort{
    /**
     * method sorts the array using bubble sort
     * @see Sort
     * @param array sortable array
     */
    @Override
    public void sort(Array<Integer> array) throws EntityException {
        boolean isSort;
        for (int i = 0; i < array.getSize() - 1; i++){
            isSort = false;
            for(int j = 0; j < array.getSize() - 1; j++){
                if(array.getElement(j) > array.getElement(j+1)){
                    array.swapElements(j, j+1);
                    isSort = true;
                }
            }
            if(!isSort){
                break;
            }
        }
    }
}
