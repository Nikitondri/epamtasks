package by.zakharanka.task02array.service.impl.sort;

import by.zakharanka.task02array.entity.Array;
import by.zakharanka.task02array.entity.exception.EntityException;

public class ShakerSorter implements Sort{
    @Override
    public void sort(Array<Integer> array) throws EntityException {
        int beginIndex = 0;
        int endIndex = array.getSize() - 1;
        int newBeginIndex;
        int newEndIndex;
        while(beginIndex <= endIndex){
            newBeginIndex = endIndex;
            newEndIndex = beginIndex;
            for (int i = beginIndex; i < endIndex; i++){
                if(array.getElement(i) > array.getElement(i + 1)){
                    array.swapElements(i, i + 1);
                    newEndIndex = i + 1;
                }
            }
            endIndex = newEndIndex - 1;
            for(int i = endIndex; i > beginIndex; i--){
                if(array.getElement(i) < array.getElement(i - 1)){
                    array.swapElements(i, i - 1);
                    newBeginIndex = i - 1;
                }
            }
            beginIndex = newBeginIndex + 1;
        }
    }
}
