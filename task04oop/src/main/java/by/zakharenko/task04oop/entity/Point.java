package by.zakharenko.task04oop.entity;

import java.util.Objects;

/**
 * Point class whose fields contain coordinates in three-dimensional space
 */
public class Point {
    /** coordinates possessed by a point */
    private double x;
    private double y;

    public Point(double newX, double newY) {
        x = newX;
        y = newY;
    }

    public Point(){}

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
