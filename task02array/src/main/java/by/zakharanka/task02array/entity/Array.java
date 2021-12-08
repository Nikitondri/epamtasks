package by.zakharanka.task02array.entity;

import by.zakharanka.task02array.exception.ArrayException;

import java.util.Arrays;

public class Array<T> {

    private T[] arr;

    public Array(T[] newArr){
        arr = newArr;
    }

    public int getSize(){
        return arr.length;
    }

    public T getElement(int index) throws ArrayException {
        if(checkSize(index)){
            return arr[index];
        } else {
            throw new ArrayException();
        }
    }

    public void setElement(int index, T value) throws ArrayException {
        if(checkSize(index)){
            arr[index] = value;
        } else {
            throw new ArrayException();
        }
    }

    public boolean checkSize(int index){
        return index >= 0 && index < arr.length;
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
