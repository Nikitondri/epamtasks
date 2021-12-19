package by.zakharanka.task02array.service.impl.sort;

import by.zakharanka.task02array.entity.Array;
import by.zakharanka.task02array.entity.exception.EntityException;

public class BubbleSorter implements Sort{
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
