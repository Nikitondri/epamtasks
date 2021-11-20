package by.zakharanka.task01javabasic.service;

import by.zakharanka.task01javabasic.entity.Data;

public class GeometricService {

    public double findCircleArea(Data<Double> data){
//        l = 2*pi*r; S = pi*r^2; S = pi * (l/(2*pi))^2
        double length = data.getData(0);
        return Math.pow((length / (2 * Math.PI)), 2) * Math.PI;
    }
}
