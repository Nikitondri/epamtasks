package by.zakharanka.task01javabasic.service;

import by.zakharanka.task01javabasic.entity.time.Watch;
import by.zakharanka.task01javabasic.entity.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TimeService {

    static final Logger LOGGER = LogManager.getLogger(TimeService.class.getName());

    public Data<Integer> checkNewTime(int currHour, int currMin, int currSec, int hour, int min, int sec){
        LOGGER.info("checkNewTime run");
//        filling current time
        Watch watch = new Watch(currHour, currMin, currSec);
//        return new time
        return watch.timer(hour, min, sec);
    }
}
