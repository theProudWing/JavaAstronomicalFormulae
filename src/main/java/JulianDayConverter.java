/**
 * Created by: Ben Jones
 * Date:05/07/2026
 * Time:22:29
 */

package main.java;

import java.time.LocalDate;

public class JulianDayConverter {

    public double toJulianDay(final int year, final int month, final double dayOfMonth) {
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

    public double toJulianDay(final LocalDate date){
        final int YEAR = date.getYear();
        final int MONTH = date.getMonthValue();
        final int DAY_OF_MONTH = date.getDayOfMonth();

        return toJulianDay(YEAR, MONTH, DAY_OF_MONTH);
    }

    public LocalDate fromJulianDay(final double julianDay) throws IllegalArgumentException {
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
