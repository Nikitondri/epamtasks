package by.zakharanka.task03innerclass.entity;


import java.util.Objects;

/**
 * a class whose fields contain information about the day and month
 */
public class Date {
    private int day;
    private int month;

    public Date(){

    }

    public Date(int newDay, int newMonth){
        if(newDay > 0 && newDay <= 31 && newMonth >= 0 && newMonth < 12) {
            day = newDay;
            month = newMonth;
        }
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return day == date.day && month == date.month;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month);
    }

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + month +
                '}';
    }
}
