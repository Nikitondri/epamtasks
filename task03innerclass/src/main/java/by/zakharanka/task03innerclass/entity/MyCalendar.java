package by.zakharanka.task03innerclass.entity;

import java.util.*;

public class MyCalendar {
    private static MyCalendar instance;

    private final int year;
    private final RedDay redDay;

    private MyCalendar(int newYear) {
        redDay = new RedDay();
        year = newYear;
    }

    public static MyCalendar getInstance(int newYear){
        if(newYear != 0){
            instance = new MyCalendar(newYear);
        }
        return instance;
    }

    public int dayOfYear(){
        Calendar cal = new GregorianCalendar(year, Calendar.JANUARY, 0);
        return cal.get(Calendar.DAY_OF_YEAR);
    }

    public boolean isLeapYear(){
        Calendar cal = new GregorianCalendar(year, Calendar.JANUARY, 0);
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
    }

    public String dayOfWeek(int day, int month){
        Calendar cal = new GregorianCalendar(year, month, day);
        return cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.getDefault());
    }

    public int dayInMonth(int month){
        Calendar cal = new GregorianCalendar(year, month, 0);
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public int getYear() {
        return year;
    }

    public RedDay getRedDay() {
        return redDay;
    }

    public class RedDay {
        Map<Calendar, String> redDayMap = new LinkedHashMap<>();

        public boolean isRedDay(int day, int month){
            Calendar cal = new GregorianCalendar(year, month, day);
            return redDayMap.containsKey(cal);
        }

        public void addRedDay(int day, int month, String name){
            redDayMap.put(new GregorianCalendar(year, month, day), name);
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder("Red days:\n");
            for(Calendar calendar:redDayMap.keySet()){
                result.append(calendar.get(Calendar.DAY_OF_MONTH))
                        .append(" ").
                        append(calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault())).
                        append(": ").
                        append(redDayMap.get(calendar)).
                        append("\n");
            }
            return result.toString();
        }
    }

}
