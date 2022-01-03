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

    /**
     * @see Calendar
     * @return number of days in a year
     */
    public int dayOfYear(){
        Calendar cal = new GregorianCalendar(year, Calendar.JANUARY, 0);
        return cal.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * @see Calendar
     * @return boolean variable with leap year result
     */
    public boolean isLeapYear(){
        Calendar cal = new GregorianCalendar(year + 1, Calendar.JANUARY, 0);
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
    }

    /**
     * determines the day of the week by date
     * @see Calendar
     * @return String object with the name of the day of the week
     */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyCalendar calendar = (MyCalendar) o;
        return year == calendar.year && redDay.equals(calendar.redDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, redDay);
    }

    @Override
    public String toString() {
        return "MyCalendar{" +
                "year=" + year +
                ", redDay=" + redDay +
                '}';
    }

    public class RedDay {
        Map<Calendar, String> redDayMap = new LinkedHashMap<>();

        /**
         * determines whether the calendar day is red
         * @see Calendar
         * @return boolean variable with red day result
         */
        public boolean isRedDay(int day, int month){
            Calendar cal = new GregorianCalendar(year, month, day);
            return redDayMap.containsKey(cal);
        }

        public void addRedDay(int day, int month, String name){
            redDayMap.put(new GregorianCalendar(year, month, day), name);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RedDay redDays = (RedDay) o;
            return redDayMap.equals(redDays.redDayMap);
        }

        @Override
        public int hashCode() {
            return Objects.hash(redDayMap);
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
