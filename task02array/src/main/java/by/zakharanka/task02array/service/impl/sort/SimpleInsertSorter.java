package by.zakharanka.task02array.service.impl.sort;

import by.zakharanka.task02array.entity.Array;
import by.zakharanka.task02array.entity.exception.EntityException;

public class SimpleInsertSorter implements Sort{
    @Override
    public void sort(Array<Integer> array) throws EntityException {
        for(int i = 1; i < array.getSize(); i++){
            for(int j = i; j > 0 && array.getElement(j - 1) > array.getElement(j); j--){
                array.swapElements(j, j - 1);
            }
        }
    }
}
