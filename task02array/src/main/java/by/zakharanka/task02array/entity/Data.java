package by.zakharanka.task02array.entity;

import java.util.ArrayList;
import java.util.List;

public class Data<T> {
    private List<T> list = new ArrayList<>();

    public T getElement(int index){
        return list.get(index);
    }

    public void setElement(int index, T value){
        list.set(index, value);
    }

    public int findSize() {
        return list.size();
    }

    public void put(T value){
        list.add(value);
    }

    @Override
    public String toString() {
        return "Data{" +
                "list=" + list +
                '}';
    }
}
