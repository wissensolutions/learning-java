package java8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;
import java.util.TimeZone;

/**
 * Date Api
 *  Oracle has introduced some date api in place of java.util.Date, java.util.Calendar
 *  1. LocalDate : Only represents Date
 *  2. LocalTime: Represents time
 *  3. LocalDateTime: Represents both date and time
 *  4. Instant : Introduced in the view of java.util.Date
 *  5. ZonedDateTime : Introduced in the view of java.util.Calendar
 */
public class DateExamples {
    public static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    public static void main(String[] args){
        //LocalDate
        LocalDate todayDate = LocalDate.now();
        System.out.println("LocalDate output = "+todayDate);

        //LocalTime
        LocalTime time = LocalTime.now();
        System.out.println("LocalTime output = "+time);

        //LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("LocalDateTime output = "+localDateTime);
        //Formatting LocalDateTime to a specified pattern
        System.out.println("Pattern Output: " + DATE_FORMATTER.format(localDateTime));

        //Instant
        Instant instant = Instant.now();
        System.out.println("Instant output = "+ instant);

        //ZonedDateTime
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("ZonedDateTime output = "+zonedDateTime);

        //Getting time of particular timezone
        System.out.println("Converting current time to PDT timezone output = "+LocalDateTime.ofInstant(Instant.now(),ZoneId.of(TimeZone.getTimeZone("America/Los_Angeles").getID())));


    }
}
