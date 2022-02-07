package by.zakharenko.task05multithreading.service;

import by.zakharenko.task05multithreading.entity.Array;
import by.zakharenko.task05multithreading.service.exception.ServiceException;

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
