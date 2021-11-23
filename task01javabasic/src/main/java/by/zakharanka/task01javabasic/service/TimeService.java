package by.zakharanka.task01javabasic.service;

import by.zakharanka.task01javabasic.entity.time.Watch;
import by.zakharanka.task01javabasic.entity.Data;

public class TimeService {

    public Data<Integer> checkNewTime(int currHour, int currMin, int currSec, int hour, int min, int sec){
//        filling current time
        Watch watch = new Watch(currHour, currMin, currSec);
//        return new time
        return watch.timer(hour, min, sec);
    }
}
