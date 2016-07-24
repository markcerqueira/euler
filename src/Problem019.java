import support.Problem;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Mark on 7/19/16.
 *
 * https://projecteuler.net/problem=19
 */
public class Problem019 extends Problem {

    // Enums matter!
    private enum Day {
        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY;

        public static Day getNextDay(Day currentDay) {
            switch (currentDay) {
                case SUNDAY: return MONDAY;
                case MONDAY: return TUESDAY;
                case TUESDAY: return WEDNESDAY;
                case WEDNESDAY: return THURSDAY;
                case THURSDAY: return FRIDAY;
                case FRIDAY: return SATURDAY;
                case SATURDAY: return SUNDAY;
                default: return null;
            }
        }
    }

    private class Calendar {
        int day;
        int month;
        int year;
        Day dayName;

        public Calendar(int day, int month, int year, Day dayName) {
            this.day = day;
            this.month = month;
            this.year = year;
            this.dayName = dayName;
        }

        public void advanceDay() {
            // Advance the day name first since that is the easy part
            dayName = Day.getNextDay(dayName);

            // New Years
            if (month == 12 && day == 31) {
                month = 1;
                day = 1;
                year++;
                return;
            }

            // First block: Last day of the month (30th) in September, April, June, November
            // Second block: For every other month, if we're at 31, go to the next month
            if ((day == 30 && (month == 9 || month == 4 || month == 6 || month == 11)) || day == 31) {
                month++;
                day = 1;
                return;
            }

            // February requires some special handling
            if (month == 2) {
                boolean leapYear = year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
                // Leap year so advance to day 29
                if (day == 28 && leapYear) {
                    day++;
                    return;
                } else if (day == 29 || (!leapYear && day == 28)) {
                    // Not a leap year or last day of leap year so go to March 1st
                    month = 3;
                    day = 1;
                    return;
                }
            }

            // All other cases not hit above: just advance the day (this covers most cases when we "tick")
            day++;
        }
    }

    @Override
    public long solveProblem() {
        int sundaysOnFirstOfTheMonth = 0;

        // We start on January 1, 1900 and that's a Monday
        Calendar calendar = new Calendar(1, 1, 1900, Day.MONDAY);

        // Keep ticking our calendar until the end of the 20th century
        while (calendar.year <= 2000) {
            // This "ticks" our calendar forward a day
            calendar.advanceDay();

            // We start out in 1900, but only care about the 20th century (starts on 1 Jan 1901)
            if (calendar.year < 1901) {
                continue;
            }

            // Count only Sundays that land on the first day of a month
            if (calendar.dayName == Day.SUNDAY && calendar.day == 1) {
                sundaysOnFirstOfTheMonth++;
            }
        }

        return sundaysOnFirstOfTheMonth;
    }

    @Override
    public String base64EncodedAnswer() {
        return "MTcx";
    }
}
