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

        /*
        double millenniumJD = converter.calculateJulianDay( LocalDate.of(2000, 1, 1));
        System.out.println("Millennium: " + millenniumJD);

        double currentJD = converter.calculateJulianDay(LocalDate.now());
        System.out.println("Current: " + currentJD);
        */

        //Example 3.a
        double sputnik1JD = converter.calculateJulianDay(1957, 10, 4.81);


        //Example 3.b
        double example3BJD = converter.calculateJulianDay(333, 1, 27.5);
        System.out.println("January 27, 333 @ 12:00 : " + example3BJD);

        //Example of negative years - Working!
        double bcDateJD = converter.calculateJulianDay(-584, 5, 28.63);
        System.out.println("May 28.63, -584 : " + bcDateJD);

        //Converting Back from Julian Day
        LocalDate sputnikLaunch = converter.calculateDateFromJulian(sputnik1JD);
        System.out.println("Launch of Sputnik 1: " + sputnikLaunch.toString());

        // Exercise - Calculate the calendar dates of JD = 1842713.0, AND JD = 1507900.13
        LocalDate answer1 = converter.calculateDateFromJulian(1842713);
        System.out.println("Answer 1: " + answer1.toString());
        LocalDate answer2 = converter.calculateDateFromJulian(1507900.13);
        System.out.println("Answer 2: " + answer2.toString());

        // A Negative Julian Day value throws an exception
        //LocalDate negativeJD = converter.calculateDateFromJulian(-1);

    }

    public double calculateJulianDay(final int year, final int month, final double dayOfMonth){
        //TODO: Throw an exception if provided date is outside of the calculable range

        // Create a String with the format "YYYY.MMDDdd"
        String dateString = year + ".";
        if (month < 10){
            dateString += "0";      // MM must be 2 digits
        }
        dateString += month;
        if (dayOfMonth < 10){
            dateString += "0";      // DDdd must be at least 2 digits
        }
        dateString += Double.toString(dayOfMonth).replace(".", ""); // remove any '.' from double

        double dateDouble = Double.parseDouble(dateString); // Used later to check whether date is in the Gregorian Calendar

        int y, m, A, B;

        if (month > 2){
            y = year;
            m = month;
        } else {
            y = year - 1;
            m = month + 12;
        }

        // Base Calculation for determining Julian day
        double JD = ((int)(365.25 * y) + (int)(30.6001 * (m + 1))  + dayOfMonth + 1_720_994.5);

        // Check whether date is in Gregorian Calendar
        if (dateDouble >= 1582.1015){
            A = y / 100;
            B = (2 - A) + (int)(A/4);

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

    public LocalDate calculateDateFromJulian(double julianDay) throws IllegalArgumentException{
        if (julianDay < 0){
            throw new IllegalArgumentException("ERROR: Method requires positive Julian Day Values");
        }

        double temp = julianDay + 0.5;
        String tempString = Double.toString(temp);

        int Z = (int) temp;
        double F = Double.parseDouble("0." + tempString.split("\\.")[1]);

        int A;

        if (Z >= 2_299_161){
            int alpha = (int)((Z - 1_867_216.25) / 36524.25);
            A = (Z + 1 + alpha) - (alpha / 4);
        } else {
            A = Z;
        }
        int B = A + 1524;
        int C = (int)((B - 122.1) / 365.25);
        int D = (int)(365.25 * C);
        int E = (int)((B-D) / 30.6001);

        double dayOfMonth = B - D - (int)(30.6001 * E) + F;
        int month = E < 13.5 ? E - 1 : E - 13;
        int year = month > 2 ? C - 4716 : C - 4715;

        return LocalDate.of(year, month, (int)dayOfMonth);
    }
}
