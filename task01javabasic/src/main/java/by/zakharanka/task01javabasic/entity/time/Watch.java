package by.zakharanka.task01javabasic.entity.time;

import by.zakharanka.task01javabasic.entity.Data;



/**
 * class stores the current set time and performs operations over time
 */
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

    /**
     * Determines what time will be
     * used in class {@code TimeService} in {@code checkNewTime} method for implementation task TimerTaskImpl
     * @param hour which increases the time
     * @param min which increases the time
     * @param sec which increases the time
     * @return new time
     */
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

    @Override
    public String toString() {
        return "Time: " + currHour + ":" +
                currMin + ":" +
                currSec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Watch watch = (Watch) o;
        return currHour == watch.currHour && currMin == watch.currMin && currSec == watch.currSec;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + currHour;
        result = prime * result + currMin;
        result = prime * result + currSec;
        return result;
    }
}
