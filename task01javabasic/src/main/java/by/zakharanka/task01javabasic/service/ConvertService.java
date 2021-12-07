package by.zakharanka.task01javabasic.service;

import by.zakharanka.task01javabasic.entity.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * class for converting different units of measurement
 */
public class ConvertService {

    static final Logger LOGGER = LogManager.getLogger(ConvertService.class.getName());

    private static final double MEMORY_DIFFERENCE = 1024;

    /**
     * the units of information after the byte differ by 1024
     * when converting information units, divide each subsequent value by 1024
     * @param numByte the number of byte to convert into other units of information
     * @return {@code Data} object with other units of information
     */
    public Data<Double> convertByte(final double numByte){
        LOGGER.trace("convertByte run");
        Data<Double> memory = new Data<>();
        memory.push(numByte / MEMORY_DIFFERENCE); //Kilobytes
        memory.push(memory.getData(0) / MEMORY_DIFFERENCE); //Megabytes
        memory.push(memory.getData(1) / MEMORY_DIFFERENCE); //Gigabytes
        memory.push(memory.getData(2) / MEMORY_DIFFERENCE); //Terabytes
        return memory;
    }
}
