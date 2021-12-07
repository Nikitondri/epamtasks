package by.zakharanka.task01javabasic.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GeometricService {

    static final Logger LOGGER = LogManager.getLogger(GeometricService.class.getName());

    /**
     * knowing the circumference, this method calculates the area of this circle,
     * formula: S = pi * (l/(2*pi))^2,
     * @see Math,
     * @param length circumference,
     * @return area of a circle
     */
    public double findCircleArea(double length){
        LOGGER.trace("findCircleArea run");
//        l = 2*pi*r; S = pi*r^2; S = pi * (l/(2*pi))^2
        return Math.pow((length / (2 * Math.PI)), 2) * Math.PI;
    }
}
