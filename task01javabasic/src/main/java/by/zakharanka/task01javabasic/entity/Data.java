package by.zakharanka.task01javabasic.entity;

import java.util.ArrayList;
import java.util.List;

public class Data<T>{
    private final List<T> list = new ArrayList<>();

    public void push(T arg){
        list.add(arg);
    }

    public T getData(int index){
        return list.get(index);
    }

}
