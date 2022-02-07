package by.zakharenko.task05multithreading.entity;

import java.util.ArrayList;
import java.util.List;

public class Data<T> {
    private final List<T> list;

    public Data(List<T> newList) {
        list = newList;
    }

    public Data(){
        list = new ArrayList<>();
    }

    public T getElement(int index){
        return list.get(index);
    }

    public List<T> getList() {
        return new ArrayList<>(list);
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

    public T remove(int index){
        return list.remove(index);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Data:\n");
        for (T ts : list) {
            res.append(ts).append(" ");
        }
        return res.toString();
    }
}
