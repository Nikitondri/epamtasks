package by.zakharenko.task04oop.entity;

import java.util.Objects;

public class Quadrangle {
    private long id;
    private String name;
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;
    private QuadrangleType type;

    public Quadrangle(String newName, Point newPointA, Point newPointB, Point newPointC, Point newPointD) {
        id = 0;
        name = newName;
        pointA = newPointA;
        pointB = newPointB;
        pointC = newPointC;
        pointD = newPointD;
    }

    public Quadrangle(Point newPointA, Point newPointB, Point newPointC, Point newPointD) {
        id = 0;
        name = null;
        pointA = newPointA;
        pointB = newPointB;
        pointC = newPointC;
        pointD = newPointD;
    }

    public Quadrangle(){ }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    public Point getPointD() {
        return pointD;
    }

    public void setPointD(Point pointD) {
        this.pointD = pointD;
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
        Quadrangle that = (Quadrangle) o;
        return id == that.id && name.equals(that.name) && pointA.equals(that.pointA) && pointB.equals(that.pointB) && pointC.equals(that.pointC) && pointD.equals(that.pointD);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, pointA, pointB, pointC, pointD);
    }

    @Override
    public String toString() {
        return "Quadrangle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pointA=" + pointA +
                ", pointB=" + pointB +
                ", pointC=" + pointC +
                ", pointD=" + pointD +
                '}';
    }
}
