package by.zakharenko.task04oop.entity;

import by.zakharenko.task04oop.service.exception.ServiceException;
import by.zakharenko.task04oop.service.observer.Observable;
import by.zakharenko.task04oop.service.observer.Observer;
import by.zakharenko.task04oop.service.observer.QuadrangleEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Quadrangle implements Observable<QuadrangleEvent> {
    private long id;
    private String name;
    /** 4 points that belong to a quadrangle */
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;
    /** a list of observers that perform actions to change class fields */
    private final List<Observer<QuadrangleEvent>> observers = new ArrayList<>();

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

    public Quadrangle(long id, String name, Point pointA, Point pointB, Point pointC, Point pointD) {
        this.id = id;
        this.name = name;
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
    }

    public Quadrangle(){ }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
        notifyObservers();
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
        notifyObservers();
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
        notifyObservers();
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
        notifyObservers();
    }

    public Point getPointD() {
        return pointD;
    }

    public void setPointD(Point pointD) {
        this.pointD = pointD;
        notifyObservers();
    }

    public int findObserversSize(){
        return observers.size();
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

    /** method that adds observers */
    @Override
    public void subscribe(Observer<QuadrangleEvent> observer) {
        observers.add(observer);
    }

    /** method that removes observers */
    @Override
    public void unsubscribe(Observer<QuadrangleEvent> observer) {
        observers.remove(observer);
    }

    /** method that fires when fields change */
    @Override
    public void notifyObservers() {
        observers.forEach(observer -> {
            try {
                observer.update(new QuadrangleEvent(this));
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        });
    }
}
