package by.zakharanka.task03inheritance.entity;

import java.util.ArrayList;
import java.util.List;

public class ParametersList {
    private List<String> list = new ArrayList<>();

    public String getElement(int index){
        return list.get(index);
    }

    public ParametersList(List<String> list) {
        this.list = list;
    }

    public ParametersList(){

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Parameters:\n");
        for (String ts : list) {
            res.append(ts).append(" ");
        }
        return res.toString();
    }
}