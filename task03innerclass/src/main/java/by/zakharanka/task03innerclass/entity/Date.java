package by.zakharanka.task03innerclass.entity;


public class Date {
    private int day;
    private int month;

    public Date(){

    }

    public Date(int newDay, int newMonth){
        day = newDay;
        month = newMonth;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

}
