package by.zakharenko.cafe.entity;

import java.util.Objects;

public class Dish extends CafeEntity {
    private final int id;
    private String name;
    private Double cost;
    private boolean isEnable;
    private DishType type;
    private int weight;
    private String description;
    private String picturePath;

    public Dish(int id, String name, Double cost, boolean isEnable, DishType type, int weight,
                String description, String picturePath) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.isEnable = isEnable;
        this.type = type;
        this.weight = weight;
        this.description = description;
        this.picturePath = picturePath;
    }

    public Dish(int id){
        this.id = id;
    }

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

    public DishType getType() {
        return type;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return id == dish.id && isEnable == dish.isEnable && type == dish.type && weight == dish.weight && Objects.equals(name, dish.name) && Objects.equals(cost, dish.cost) && Objects.equals(description, dish.description) && Objects.equals(picturePath, dish.picturePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cost, isEnable, type, weight, description, picturePath);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", isEnable=" + isEnable +
                ", typeId=" + type +
                ", weight=" + weight +
                ", description='" + description + '\'' +
                ", picturePath='" + picturePath + '\'' +
                '}';
    }
}
