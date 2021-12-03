package by.zakharanka.task01javabasic.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Data<T>{
    private final List<T> list = new ArrayList<>();

    public Data() {

    }

    public Data(List<T> arg){
        Collections.copy(list, arg);
    }

    public void push(T arg){
        list.add(arg);
    }

    public int size(){
        return list.size();
    }

    public T getData(int index){
        return list.get(index);
    }

    @Override
    public String toString() {
        return "Data{" +
                "list=" + list +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data<?> data = (Data<?>) o;
        return list.equals(data.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }
}
