package by.zakharanka.task02array.entity;

import by.zakharanka.task02array.entity.exception.EntityException;

import java.util.Arrays;

public class Array<T> {

    private T[] arr;

    public Array(T[] newArr){
        arr = newArr;
    }


    public int getSize(){
        return arr.length;
    }

    public T getElement(int index) throws EntityException {
        if(checkSize(index)){
            return arr[index];
        } else {
            throw new EntityException();
        }
    }

    public void setElement(int index, T value) throws EntityException {
        if(checkSize(index)){
            arr[index] = value;
        } else {
            throw new EntityException();
        }
    }

    public boolean checkSize(int index){
        return index >= 0 && index < arr.length;
    }

    public void swapElements(int index1, int index2){
        T buf = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = buf;
    }

    @Override
    public String toString() {
        return "Array{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Array<?> array = (Array<?>) o;
        return Arrays.equals(arr, array.arr);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arr);
    }
}
