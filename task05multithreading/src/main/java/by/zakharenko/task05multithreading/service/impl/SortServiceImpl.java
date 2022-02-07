package by.zakharenko.task05multithreading.service.impl;


import by.zakharenko.task05multithreading.entity.Array;
import by.zakharenko.task05multithreading.entity.exception.EntityException;
import by.zakharenko.task05multithreading.service.SortService;
import by.zakharenko.task05multithreading.service.exception.ServiceException;
import by.zakharenko.task05multithreading.service.impl.sort.*;

public class SortServiceImpl implements SortService {
    /**
     * calls the sort method from the class {@code BubbleSorter}
     * @see BubbleSorter
     * @see SortService
     * @param arr sortable array
     * @return sort result
     */
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

    /**
     * calls the sort method from the class {@code ShakerSorter}
     * @see ShakerSorter
     * @see SortService
     * @param arr sortable array
     * @return sort result
     */
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

    /**
     * calls the sort method from the class {@code SimpleChoiceSorter}
     * @see SimpleChoiceSorter
     * @see SortService
     * @param arr sortable array
     * @return sort result
     */
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

    /**
     * calls the sort method from the class {@code SimpleInsertSorter}
     * @see SimpleInsertSorter
     * @see SortService
     * @param arr sortable array
     * @return sort result
     */
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

    /**
     * calls the sort method from the class {@code AddressCalculationSorter}
     * @see AddressCalculationSorter
     * @see SortService
     * @param arr sortable array
     * @return sort result
     */
    @Override
    public String insertSort(Array<Integer> arr) throws ServiceException {
        AddressCalculationSorter addressCalculationSorter = new AddressCalculationSorter();
        try{
            addressCalculationSorter.sort(arr);
            return arr.toString();
        }catch (EntityException | ServiceException e){
            throw new ServiceException(e);
        }
    }

    /**
     * calls the sort method from the class {@code BinaryMergeSorter}
     * @see BinaryMergeSorter
     * @see SortService
     * @param arr sortable array
     * @return sort result
     */
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

    /**
     * calls the sort method from the class {@code ShellSorter}
     * @see ShellSorter
     * @see SortService
     * @param arr sortable array
     * @return sort result
     */
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
