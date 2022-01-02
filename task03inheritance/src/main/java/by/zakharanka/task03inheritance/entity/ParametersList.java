package by.zakharanka.task03inheritance.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParametersList that = (ParametersList) o;
        return list.equals(that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
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