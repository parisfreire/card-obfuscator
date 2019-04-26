package com.cardobfuscator.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Locale;

/**
 * Created by parisfreire on 25/04/2019.
 */
public class DateUtils {

    /**
     * Date parsing utility shared among the project to centralice date parsing
     */
    public static Date parseDateFromString(String dateString){

        DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("MMM-yyyy").toFormatter(Locale.US);
        TemporalAccessor ta = formatter.parse(dateString);
        YearMonth ym = YearMonth.from(ta);
        LocalDateTime dt = LocalDateTime.of(ym.getYear(), ym.getMonthValue(), 1, 0, 0, 0);
        Instant instant = Instant.from(dt.atZone(ZoneId.systemDefault()));
        Date date = Date.from(instant);

        return date;
    }
}
