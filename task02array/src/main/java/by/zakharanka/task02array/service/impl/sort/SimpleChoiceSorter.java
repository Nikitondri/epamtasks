package by.zakharanka.task02array.service.impl.sort;

import by.zakharanka.task02array.entity.Array;
import by.zakharanka.task02array.entity.exception.EntityException;

public class SimpleChoiceSorter implements Sort{
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

