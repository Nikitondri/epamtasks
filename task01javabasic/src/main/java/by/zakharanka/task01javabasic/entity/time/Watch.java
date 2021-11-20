package by.zakharanka.task01javabasic.entity.time;

import by.zakharanka.task01javabasic.entity.Data;

public class Watch {
    public static final int MAX_SEC = 59;
    public static final int MAX_MIN = 59;
    public static final int MAX_HOUR = 23;

    private final int currHour;
    private final int currMin;
    private final int currSec;

    public Watch(int currHour, int currMin, int currSec) {
        this.currHour = currHour;
        this.currMin = currMin;
        this.currSec = currSec;
    }

    public Data<Integer> timer(int hour, int min, int sec){
        int newHour;
        int newMin;
        int newSec;
//          remainder of division is new time
//          integer division - the value to add to the next number
        newSec = sec + currSec;
        if(newSec > MAX_SEC){
            min += (newSec / (MAX_SEC + 1));
            newSec %= (MAX_SEC + 1);
        }

        newMin = min + currMin;
        if(newMin > MAX_MIN){
            hour += (newMin / (MAX_MIN + 1));
            newMin %= (MAX_MIN + 1);
        }

        newHour = hour + currHour;
        if(newHour > MAX_HOUR){
            newHour %= (MAX_HOUR + 1);
        }
//        fill new time
        Data<Integer> dataTime = new Data<>();
        dataTime.push(newHour);
        dataTime.push(newMin);
        dataTime.push(newSec);
        return dataTime;
    }
}
