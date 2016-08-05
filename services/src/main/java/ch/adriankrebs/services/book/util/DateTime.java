package ch.adriankrebs.services.book.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Created by Adrian on 8/5/2016.
 */
public class DateTime {


    public static void main(String[] args) {

        // without timezones
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());

        LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);
        LocalDate date2 = LocalDate.of(2015, 1, 20);

        // just a private constructor so new LocalDate() is no allowed-> just static methods


        // IMMUTABLE!

        LocalDate date = LocalDate.of(2014, Month.JANUARY, 20);
        System.out.println(date); // 2014-01-20
        date = date.plusDays(2);
        System.out.println(date); // 2014-01-22
        date = date.plusWeeks(1);

        System.out.println(date); // 2014-01-29
        date = date.plusMonths(1);
        System.out.println(date); // 2014-02-28
        date = date.plusYears(5);
        System.out.println(date); // 2019-02-28


        // Formatting

        LocalDate date123 = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(11, 12, 34);
        LocalDateTime dateTime = LocalDateTime.of(date, time);System.out.println(date
                .format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));



        DateTimeFormatter shortDateTime =
                DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        shortDateTime =
                DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        System.out.println(shortDateTime.format(dateTime)); // 1/20/20
        System.out.println(shortDateTime.format(date)); // 1/20/20
        System.out.println(
                shortDateTime.format(time)); // UnsupportedTemporalTypeException

        DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm");
        System.out.println(dateTime.format(f)); // January 20, 2020, 11:12

        DateTimeFormatter f12313 = DateTimeFormatter.ofPattern("MM dd yyyy");
        LocalDate date12321 = LocalDate.parse("01 02 2015", f);
        LocalTime time123123 = LocalTime.parse("11:22");
        System.out.println(date12321); // 2015-01-02
        System.out.println(time123123); // 11:22


        LocalDate.parse("2018-04-30", DateTimeFormatter.ISO_LOCAL_DATE);

        LocalDateTime d = LocalDateTime.of(2015, 5, 10, 11, 22, 33);
        Period p = Period.of(1, 2, 3);
        d = d.minus(p);
        DateTimeFormatter f2 = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT); // only time
        DateTimeFormatter f3 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT); // time and date
        System.out.println(d.format(f2));

        // Period does not allow chaining. Only the last Period method called counts, so only
        //the two years are subtracted.


        LocalDate dateTest = LocalDate.parse("2018-04-30", DateTimeFormatter.ISO_LOCAL_DATE);
        // dateTest.plusHours(2); // doesnt work sincce date has no time
    }




}
