package by.zakharanka.task01javabasic.service;

public class GeometricService {

    public double findCircleArea(double length){
//        l = 2*pi*r; S = pi*r^2; S = pi * (l/(2*pi))^2
        return Math.pow((length / (2 * Math.PI)), 2) * Math.PI;
    }
}
