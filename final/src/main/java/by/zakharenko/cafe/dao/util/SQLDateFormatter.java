package by.zakharenko.cafe.dao.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class SQLDateFormatter {
    private static final String SQL_DATE_PATTER = "yyyy-MM-dd HH:mm:ss";
    private static final SimpleDateFormat formatDateSQL = new SimpleDateFormat(SQL_DATE_PATTER);

    public static String format(LocalDateTime date){
        return formatDateSQL.format(date);
    }
}
