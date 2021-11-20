package by.zakharanka.task01javabasic.service;

import by.zakharanka.task01javabasic.entity.time.Watch;
import by.zakharanka.task01javabasic.entity.Data;

public class TimeService {

    public Data<Integer> checkNewTime(Data<Integer> currTime, Data<Integer> time){
//        filling current time
        Watch watch = new Watch(currTime.getData(0), currTime.getData(1), currTime.getData(2));
//        return new time
        return watch.timer(time.getData(0), time.getData(1), time.getData(2));
    }
}
