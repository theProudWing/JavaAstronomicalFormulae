/**
 * Created by: Ben Jones
 * Date:09/07/2026
 * Time:11:04
 */

package main.java.Chapters;

import main.java.JulianDayCalculator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Chapter3 {
    public static void run(){
        JulianDayCalculator converter = new JulianDayCalculator();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MMM dd");

        //double millenniumJD = converter.toJulianDay(LocalDate.of(2000, 1, 1));
        //System.out.println("Millennium: " + millenniumJD);

        //double currentJD = converter.toJulianDay(LocalDate.now());
        //System.out.println("Current: " + currentJD);


        //Example 3.a
        //double sputnik1JD = converter.toJulianDay(1957, 10, 4.81);

        //Example 3.b
        //double example3BJD = converter.toJulianDay(333, 1, 27.5);
        //System.out.println("January 27, 333 @ 12:00 : " + example3BJD);

        //Example of negative years - Working!
        //double bcDateJD = converter.toJulianDay(-584, 5, 28.63);
        //System.out.println("May 28.63, -584 : " + bcDateJD);

        //Converting Back from Julian Day
        //LocalDate sputnikLaunch = converter.fromJulianDay(sputnik1JD);
        //System.out.println("Launch of Sputnik 1: " + sputnikLaunch.toString());

        // Exercise - Calculate the calendar dates of JD = 1842713.0, AND JD = 1507900.13
        //LocalDate answer1 = converter.fromJulianDay(1842713);
        //System.out.println("Answer 1: " + answer1.toString());
        //LocalDate answer2 = converter.fromJulianDay(1507900.13);
        //System.out.println("Answer 2: " + answer2.toString());

        // A Negative Julian Day value throws an exception
        //LocalDate negativeJD = converter.calculateDateFromJulian(-1);

        // The number of days between two calendar dates can be found by calculating the difference
        // between their corresponding Julian Days

        double halleyPeri_1835JD = converter.toJulianDay(1835, 11, 16); // Halley's Comet Perihelion in 1835
        double halleyPeri_1910JD = converter.toJulianDay(1910, 4, 20); // Halley Peri-h in 1910

        double difference = Math.abs(halleyPeri_1910JD - halleyPeri_1835JD);
        //System.out.println(difference);

        // Thus we can estimate future perihelia for Halley's comet
        // Note. that these dates are not accurate due to external factors affecting Halley's orbit
        ArrayList<Double> halleyJDs = new ArrayList<>();
        halleyJDs.add(halleyPeri_1910JD);


        for (int i = 0; i < 10; i++) {
            halleyJDs.add(halleyJDs.get(i) + difference);
        }
        for (double halleyJD : halleyJDs){
            LocalDate halleyCalendarDate = converter.fromJulianDay(halleyJD);
            String formattedDate = halleyCalendarDate.format(formatter);
            //System.out.println(formattedDate);
        }

        // Exercise: identify the date 10_000 days after 1954 June 30.

        LocalDate timeIntervalExerciseDate = LocalDate.of(1954, 6, 30);
        double futureDateJD = converter.toJulianDay(timeIntervalExerciseDate) + 10_000;

        LocalDate timeIntervalExerciseDate2 = converter.fromJulianDay(futureDateJD);
        // System.out.println(timeIntervalExerciseDate2.format(formatter)); // 1981 November 15

        // Example 3.e Weekday of 1954 June 30 (Wednesday)
        System.out.println(converter.dayOfTheWeekJD(converter.toJulianDay(1954, 6, 30)));

    }
    //  A leap year is any year divisible by 4, except years also divisible by 100, which are only leap years if also
    //  divisible by 400. Therefore, 1600, 2000, 2012, and 2024 are all leap years while 1800, 1900, and 1901 are not.

    public static boolean isLeapYear(int year){
        if (year % 4 == 0){
            if (year % 100 == 0){
                return year % 400 == 0;
            }
            return true;
        }
        return false;
    }
}
