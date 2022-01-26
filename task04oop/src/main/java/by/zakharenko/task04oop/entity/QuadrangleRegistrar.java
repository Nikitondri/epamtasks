package by.zakharenko.task04oop.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class QuadrangleRegistrar {
    private long id;
    private double perimeter;
    private double area;
    private boolean isConvex;
    private Set<Integer> quarters;
    private QuadrangleType type;

    public QuadrangleRegistrar(long id, double perimeter, double area, boolean isConvex, Set<Integer> quarters, QuadrangleType type) {
        this.id = id;
        this.perimeter = perimeter;
        this.area = area;
        this.isConvex = isConvex;
        this.quarters = quarters;
        this.type = type;
    }

    public QuadrangleRegistrar(long id) {
        this.id = id;
    }

    public QuadrangleRegistrar(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public boolean isConvex() {
        return isConvex;
    }

    public void setConvex(boolean convex) {
        isConvex = convex;
    }

    public Set<Integer> getQuarters() {
        return new HashSet<>(quarters);
    }

    public void setQuarters(Set<Integer> quarters) {
        this.quarters = quarters;
    }

    public QuadrangleType getType() {
        return type;
    }

    public void setType(QuadrangleType type) {
        this.type = type;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuadrangleRegistrar that = (QuadrangleRegistrar) o;
        return id == that.id && Double.compare(that.perimeter, perimeter) == 0 && Double.compare(that.area, area) == 0 && isConvex == that.isConvex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, perimeter, area, isConvex);
    }

    @Override
    public String toString() {
        return "QuadrangleRegistrar{" +
                "id=" + id +
                ", perimeter=" + perimeter +
                ", area=" + area +
                ", isConvex=" + isConvex +
                '}';
    }
}
