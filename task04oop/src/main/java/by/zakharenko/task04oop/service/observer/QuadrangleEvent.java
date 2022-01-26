package by.zakharenko.task04oop.service.observer;

import by.zakharenko.task04oop.entity.Quadrangle;

import java.util.EventObject;

public class QuadrangleEvent extends EventObject {

    public QuadrangleEvent(Object source) {
        super(source);
    }

    @Override
    public Quadrangle getSource() {
        return (Quadrangle) super.getSource();
    }
}
