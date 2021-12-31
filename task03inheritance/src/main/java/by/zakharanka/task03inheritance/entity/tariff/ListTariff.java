package by.zakharanka.task03inheritance.entity.tariff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ListTariff<T extends Tariff> {
    List<T> list;

    public ListTariff(){
        list = new ArrayList<>();
    }

    public void addTariff(T tariff){
        list.add(tariff);
    }

    public void addListTariff(T[] arrTariff){
        Collections.addAll(list, arrTariff);
    }

    public void swapTariffs(int index1, int index2){
        T buf = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, buf);
    }

    public int size(){
        return list.size();
    }

    public T getTariff(int index){
        return list.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListTariff<?> that = (ListTariff<?>) o;
        return list.equals(that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(list.getClass().toString() + ":\n");
        for (T t : list) {
            result.append(t.toString()).append("\n");
        }
        result.append("\n");
        return result.toString();
    }
}
