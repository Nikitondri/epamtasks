package by.zakharanka.task01javabasic.entity;

import java.util.ArrayList;
import java.util.List;

public class Data<T>{
    private List<T> list = new ArrayList<>();

    public void push(T arg){
        list.add(arg);
    }

    public void push(int index, T arg){
        list.add(index, arg);
    }

    public T getData(int index){
        return list.get(index);
    }

    public void setData(int index, T arg){
        list.set(index, arg);
    }

}
