package main.java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

class JulianDayCalculatorTests {

    JulianDayCalculator calc = new JulianDayCalculator();

    @Test
    void testCorrectDaysOfWeek() {
        LocalDate weltmeister = LocalDate.of(2010, 11, 14);
        assertEquals("Sunday", calc.dayOfTheWeekJD(calc.toJulianDay(weltmeister)));

        LocalDate worldCup66Final = LocalDate.of(1966, 7, 30);
        assertEquals("Saturday", calc.dayOfTheWeekJD(calc.toJulianDay(worldCup66Final)));

        LocalDate nextFullMoonFriday13 = LocalDate.of(2049, 8, 13);
        assertEquals("Friday", calc.dayOfTheWeekJD(calc.toJulianDay(nextFullMoonFriday13)));

        LocalDate creation = LocalDate.of(2026, 7, 9);
        assertEquals("Thursday", calc.dayOfTheWeekJD(calc.toJulianDay(creation)));

        LocalDate apollo11Launch = LocalDate.of(1969, 7, 16);
        assertEquals("Wednesday", calc.dayOfTheWeekJD(calc.toJulianDay(apollo11Launch)));

        LocalDate dDay = LocalDate.of(1944, 6, 6);
        assertEquals("Tuesday", calc.dayOfTheWeekJD(calc.toJulianDay(dDay)));

        LocalDate armistice = LocalDate.of(1918, 11, 11);
        assertEquals("Monday", calc.dayOfTheWeekJD(calc.toJulianDay(armistice)));

    }
}