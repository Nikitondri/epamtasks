package by.zakharanka.task01javabasic.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

}
