package by.zakharanka.task02array.service.impl.sort;

import by.zakharanka.task02array.entity.Array;
import by.zakharanka.task02array.entity.exception.EntityException;
import by.zakharanka.task02array.service.exception.ServiceException;

public class BinaryMergeSorter implements Sort{
    private void merge(Array<Integer> arr, int l, int m, int r) throws EntityException {
        int n1 = m - l + 1;
        int n2 = r - m;

        Integer[] left = new Integer[n1];
        Integer[] right = new Integer[n2];

        for (int i = 0; i < n1; ++i)
            left[i] = arr.getElement(l + i);
        for (int j = 0; j < n2; ++j)
            right[j] = arr.getElement(m + 1 + j);
        int i = 0;
        int j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr.setElement(k, left[i]);
                i++;
            }
            else {
                arr.setElement(k, right[j]);
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr.setElement(k, left[i]);
            i++;
            k++;
        }
        while (j < n2) {
            arr.setElement(k, right[j]);
            j++;
            k++;
        }
    }

    private void binarySort(Array<Integer> arr, int l, int r) throws ServiceException {
        if (l < r) {
            int m =l+ (r-l)/2;
            binarySort(arr, l, m);
            binarySort(arr, m + 1, r);
            try {
                merge(arr, l, m, r);
            } catch (EntityException e) {
                throw new ServiceException(e);
            }
        }
    }

    @Override
    public void sort(Array<Integer> array) throws EntityException, ServiceException {
        try {
            binarySort(array, 0, array.getSize() - 1);
        } catch (ServiceException e) {
            throw new ServiceException("Not correct matrix");
        }
    }
}



