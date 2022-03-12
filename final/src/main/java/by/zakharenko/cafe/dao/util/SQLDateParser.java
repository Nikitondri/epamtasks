package by.zakharenko.cafe.dao.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SQLDateParser {
    private static final String SQL_DATE_PATTER = "yyyy-MM-dd HH:mm:ss";

    public static LocalDateTime parse(String date) {
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(SQL_DATE_PATTER));
    }
}
