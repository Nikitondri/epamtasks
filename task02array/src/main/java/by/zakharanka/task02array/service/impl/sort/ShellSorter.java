package by.zakharanka.task02array.service.impl.sort;

import by.zakharanka.task02array.entity.Array;
import by.zakharanka.task02array.entity.exception.EntityException;

public class ShellSorter implements Sort{
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

//for (int step = n / 2; step > 0; step /= 2) {
//    for (int i = step; i < n; i++) {
//        for (int j = i - step; j >= 0 && a[j] > a[j + step] ; j -= step) {
//            int x = a[j];
//            a[j] = a[j + step];
//            a[j + step] = x;
//        }
//    }
//}
