package main.java.Chapters;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeapYearTests {

    @Test
    @DisplayName("Years divisible by 400 are leap years")
    void testLeapYearDivisibleBy400() {
        assertTrue(Chapter3.leapYearCalculator(-2000));
        assertTrue(Chapter3.leapYearCalculator(2000));
        assertTrue(Chapter3.leapYearCalculator(1600));
        assertTrue(Chapter3.leapYearCalculator(2800));
        assertTrue(Chapter3.leapYearCalculator(240_000));
    }
    @Test
    @DisplayName("Years divisible by 100 but not 400 are NOT leap years")
    void testNotLeapYearDivisibleBy100(){
        assertFalse(Chapter3.leapYearCalculator(-900));
        assertFalse(Chapter3.leapYearCalculator(900));
        assertFalse(Chapter3.leapYearCalculator(1800));
        assertFalse(Chapter3.leapYearCalculator(2100));
        assertFalse(Chapter3.leapYearCalculator(39_900));
    }
    @Test
    @DisplayName("Years divisible by 4 but not 100 ARE leap years.")
    void testLeapYearDivisibleBy4(){
        assertTrue(Chapter3.leapYearCalculator(-536));
        assertTrue(Chapter3.leapYearCalculator(536));
        assertTrue(Chapter3.leapYearCalculator(1584));
        assertTrue(Chapter3.leapYearCalculator(1904));
        assertTrue(Chapter3.leapYearCalculator(2004));
        assertTrue(Chapter3.leapYearCalculator(2012));
        assertTrue(Chapter3.leapYearCalculator(3948));
        assertTrue(Chapter3.leapYearCalculator(165_816));
    }
    @Test
    @DisplayName("Years not divisible by 4 are NOT leap years")
    void testNotLeapYear(){
        assertFalse(Chapter3.leapYearCalculator(1));
        assertFalse(Chapter3.leapYearCalculator(535));
        assertFalse(Chapter3.leapYearCalculator(2003));
        assertFalse(Chapter3.leapYearCalculator(118_118));
        assertFalse(Chapter3.leapYearCalculator(420_069));
    }
}