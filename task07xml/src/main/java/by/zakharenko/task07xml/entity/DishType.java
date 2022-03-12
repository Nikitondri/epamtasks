package by.zakharenko.task07xml.entity;

import java.util.Objects;

public class DishType {
    private int id;
    private String name;

    public DishType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public DishType(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishType dishType = (DishType) o;
        return id == dishType.id && Objects.equals(name, dishType.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "DishType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
