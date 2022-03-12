package by.zakharenko.task07xml.entity;

import java.util.Objects;

public class Dish {
    private int id;
    private String name;
    private Double cost;
    private boolean isEnable;
    private DishType typeId;
    private int weight;
    private String description;
    private String picturePath;

    public Dish(int id, String name, Double cost, boolean isEnable, DishType typeId,
                int weight, String description, String picturePath) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.isEnable = isEnable;
        this.typeId = typeId;
        this.weight = weight;
        this.description = description;
        this.picturePath = picturePath;
    }

    public Dish(){ }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getCost() {
        return cost;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public DishType getTypeId() {
        return typeId;
    }

    public int getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    public void setTypeId(DishType typeId) {
        this.typeId = typeId;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return id == dish.id && isEnable == dish.isEnable && weight == dish.weight && Objects.equals(name, dish.name) && Objects.equals(cost, dish.cost) && Objects.equals(typeId, dish.typeId) && Objects.equals(description, dish.description) && Objects.equals(picturePath, dish.picturePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cost, isEnable, typeId, weight, description, picturePath);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", isEnable=" + isEnable +
                ", typeId=" + typeId +
                ", weight=" + weight +
                ", description='" + description + '\'' +
                ", picturePath='" + picturePath + '\'' +
                '}';
    }
}
