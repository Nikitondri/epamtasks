package by.zakharanka.task01javabasic.service;

import by.zakharanka.task01javabasic.entity.Watch;
import by.zakharanka.task01javabasic.entity.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * class for time operations
 */
public class TimeService {

    static final Logger LOGGER = LogManager.getLogger(TimeService.class.getName());

    /**
     * used in {@code TimerTaskImpl} class
     * @see Watch
     * @param currHour current hour
     * @param currMin current min
     * @param currSec current second
     * @param hour hours by which to increase the current time
     * @param min minutes by which to increase the current time
     * @param sec second by which to increase the current time
     * @return {@code Data} object with new time
     */
    public Data<Integer> checkNewTime(int currHour, int currMin, int currSec, int hour, int min, int sec){
        LOGGER.trace("checkNewTime run");
//        filling current time
        Watch watch = new Watch(currHour, currMin, currSec);
//        return new time
        return watch.timer(hour, min, sec);
    }
}
