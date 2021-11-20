package by.zakharanka.task01javabasic.service;

import by.zakharanka.task01javabasic.entity.Data;

public class GeometricService {

    public double findAreaСircle (Data<Double> data){
        double length = data.getData(0); //l = 2pir r
        return Math.pow((length / (2 * Math.PI)), 2) * Math.PI;
    }
}
