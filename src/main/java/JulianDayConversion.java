/**
 * Created by: Ben Jones
 * Date:05/07/2026
 * Time:22:29
 */

package main.java;

import java.time.LocalDate;

public class JulianDayConversion {

    public static void main(String[] args){
        JulianDayConversion converter = new JulianDayConversion();

        double millenniumJD = converter.calculateJulianDay( LocalDate.of(2000, 1, 1));
        System.out.println("Millennium Julian Date: " + millenniumJD);

        double currentJD = converter.calculateJulianDay(LocalDate.now());
        System.out.println("Current Julian Date: " + currentJD);

    }

    public double calculateJulianDay(final int YEAR, final int MONTH, final double DAY_OF_MONTH){
        // Create a String with the format "YYYY.MMDD" that can then be converted to a double
        String dateString = YEAR + ".";
        if (MONTH < 10){
            dateString += "0";      // MM must be 2 digits
        }
        dateString += MONTH;
        if (DAY_OF_MONTH < 10){
            dateString += "0";      // DD must be 2 digits
        }
        dateString += DAY_OF_MONTH;

        double dateDouble = Double.parseDouble(dateString); // Used later to check whether date is in the Gregorian Calendar

        int y, m, A, B;

        if (MONTH > 2){
            y = YEAR;
            m = MONTH;
        } else {
            y = YEAR - 1;
            m = MONTH + 12;
        }

        // Base Calculation for determining Julian day
        double JD = ((365.25 * y) + (30.6001 * (m + 1))  + DAY_OF_MONTH + 1_720_994.5);

        // Check whether date is in Gregorian Calendar
        if (dateDouble >= 1582.1015){
            A = y / 100;
            B = 2 - (A + (A/4));

            JD += B;
        }
        return JD;
    }

    public double calculateJulianDay(final LocalDate date){
        final int YEAR = date.getYear();
        final int MONTH = date.getMonthValue();
        final int DAY_OF_MONTH = date.getDayOfMonth();

        return calculateJulianDay(YEAR, MONTH, DAY_OF_MONTH);
    }
}
