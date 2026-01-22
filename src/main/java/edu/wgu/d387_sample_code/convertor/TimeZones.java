package edu.wgu.d387_sample_code.convertor;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class TimeZones {

    public static String[] time() {
        String[] time = new String[3];

        ZoneId zEastern=ZoneId.of("America/New_York");
        ZoneId zMountain=ZoneId.of("America/Denver");
        ZoneId zUTC = ZoneId.of("UTC");
        ZoneId zoneId=ZoneId.systemDefault();

        LocalDateTime localDateTime=LocalDateTime.now();
        //System.out.println("local time "+localDateTime.toString());
        ZonedDateTime zonedDateTime=localDateTime.atZone(zoneId);

        ZonedDateTime zonedDateTimeEastern=zonedDateTime.withZoneSameInstant(zEastern);
        LocalDateTime localDateTimeEastern=zonedDateTimeEastern.toLocalDateTime();
        //System.out.println("Eastern time "+localDateTimeEastern.toString());

        ZonedDateTime zonedDateTimeMountain=zonedDateTime.withZoneSameInstant(zMountain);
        LocalDateTime localDateTimeMountain=zonedDateTimeMountain.toLocalDateTime();
        //System.out.println("Mountain time "+localDateTimeMountain.toString());

        ZonedDateTime zonedDateTimeUTC=zonedDateTime.withZoneSameInstant(zUTC);
        LocalDateTime localDateTimeUTC=zonedDateTimeUTC.toLocalDateTime();
        //System.out.println("UTC time "+localDateTimeUTC.toString());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
        time[0] = zonedDateTimeEastern.format(formatter) + " ET / ";
        time[1] = zonedDateTimeMountain.format(formatter) + " MT / ";
        time[2] = zonedDateTimeUTC.format(formatter) + " UTC ";

        return time;
    }

}

