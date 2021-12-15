package by.zakharanka.task02array.service;

import by.zakharanka.task02array.entity.Array;
import by.zakharanka.task02array.service.exception.ServiceException;

public interface SortService {
    String bubbleSort(Array<Integer> arr) throws ServiceException;
    String shakerSort(Array<Integer> arr) throws ServiceException;
    String simpleChoiceSort(Array<Integer> arr) throws ServiceException;
    String simpleInsertSort(Array<Integer> arr) throws ServiceException;
    String insertSort(Array<Integer> arr) throws ServiceException;
    String binaryMergeSort(Array<Integer> arr) throws ServiceException;
    String shellSort(Array<Integer> arr) throws ServiceException;
    String externalSort(Array<Integer> arr) throws ServiceException;
}
