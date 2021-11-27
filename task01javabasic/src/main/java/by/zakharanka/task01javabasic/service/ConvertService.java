package by.zakharanka.task01javabasic.service;

import by.zakharanka.task01javabasic.entity.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConvertService {

    static final Logger LOGGER = LogManager.getLogger(ConvertService.class.getName());

    private static final double MEMORY_DIFFERENCE = 1024;

    public Data<Double> convertByte(final double numByte){
        LOGGER.info("convertByte run");
        Data<Double> memory = new Data<>();
        memory.push(numByte / MEMORY_DIFFERENCE); //Kilobytes
        memory.push(memory.getData(0) / MEMORY_DIFFERENCE); //Megabytes
        memory.push(memory.getData(1) / MEMORY_DIFFERENCE); //Gigabytes
        memory.push(memory.getData(2) / MEMORY_DIFFERENCE); //Terabytes
        return memory;
    }
}
