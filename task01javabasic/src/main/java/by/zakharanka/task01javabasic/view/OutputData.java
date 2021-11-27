package by.zakharanka.task01javabasic.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OutputData {

    static final Logger LOGGER = LogManager.getLogger(OutputData.class.getName());

    public void output(String arg){
        LOGGER.info("output data");
        System.out.print(arg);
    }

}
