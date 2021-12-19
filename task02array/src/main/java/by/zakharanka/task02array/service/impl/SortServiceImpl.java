package by.zakharanka.task02array.service.impl;

import by.zakharanka.task02array.entity.Array;
import by.zakharanka.task02array.entity.exception.EntityException;
import by.zakharanka.task02array.service.SortService;
import by.zakharanka.task02array.service.exception.ServiceException;
import by.zakharanka.task02array.service.impl.sort.*;

public class SortServiceImpl implements SortService {
    @Override
    public String bubbleSort(Array<Integer> arr) throws ServiceException {
        BubbleSorter bubbleSorter = new BubbleSorter();
        try{
            bubbleSorter.sort(arr);
            return arr.toString();
        }catch (EntityException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public String shakerSort(Array<Integer> arr) throws ServiceException {
        ShakerSorter shakerSorter = new ShakerSorter();
        try{
            shakerSorter.sort(arr);
            return arr.toString();
        }catch (EntityException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public String simpleChoiceSort(Array<Integer> arr) throws ServiceException {
        SimpleChoiceSorter simpleChoiceSorter = new SimpleChoiceSorter();
        try{
            simpleChoiceSorter.sort(arr);
            return arr.toString();
        }catch (EntityException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public String simpleInsertSort(Array<Integer> arr) throws ServiceException {
        SimpleInsertSorter simpleInsertSorter = new SimpleInsertSorter();
        try{
            simpleInsertSorter.sort(arr);
            return arr.toString();
        }catch (EntityException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public String insertSort(Array<Integer> arr) {
        return null;
    }

    @Override
    public String binaryMergeSort(Array<Integer> arr) throws ServiceException {
        BinaryMergeSorter binaryMergeSorter = new BinaryMergeSorter();
        try{
            binaryMergeSorter.sort(arr);
            return arr.toString();
        }catch (EntityException | ServiceException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public String shellSort(Array<Integer> arr) throws ServiceException {
        ShellSorter shellSorter = new ShellSorter();
        try{
            shellSorter.sort(arr);
            return arr.toString();
        }catch (EntityException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public String externalSort(Array<Integer> arr) {
        return null;
    }
}
