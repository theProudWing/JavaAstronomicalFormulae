package main.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrdinalNumberTests {

    EasterCalculator calc = new EasterCalculator();

    @Test
    void formattedOrdinalNumber() {
        assertEquals("0th", calc.formattedOrdinalNumber(0));
        assertEquals("1st", calc.formattedOrdinalNumber(1));
        assertEquals("2nd", calc.formattedOrdinalNumber(2));
        assertEquals("3rd", calc.formattedOrdinalNumber(3));
        assertEquals("4th", calc.formattedOrdinalNumber(4));
        assertEquals("5th", calc.formattedOrdinalNumber(5));
        assertEquals("10th", calc.formattedOrdinalNumber(10));
        assertEquals("11th", calc.formattedOrdinalNumber(11));
        assertEquals("12th", calc.formattedOrdinalNumber(12));
        assertEquals("13th", calc.formattedOrdinalNumber(13));
        assertEquals("14th", calc.formattedOrdinalNumber(14));
        assertEquals("15th", calc.formattedOrdinalNumber(15));
        assertEquals("20th", calc.formattedOrdinalNumber(20));
        assertEquals("21st", calc.formattedOrdinalNumber(21));
        assertEquals("22nd", calc.formattedOrdinalNumber(22));
        assertEquals("23rd", calc.formattedOrdinalNumber(23));
        assertEquals("111th", calc.formattedOrdinalNumber(111));
        assertEquals("112th", calc.formattedOrdinalNumber(112));
        assertEquals("113th", calc.formattedOrdinalNumber(113));
        assertEquals("222nd", calc.formattedOrdinalNumber(222));
        assertEquals("313th", calc.formattedOrdinalNumber(313));
        assertEquals("100000th", calc.formattedOrdinalNumber(100_000));
        assertEquals("100001st", calc.formattedOrdinalNumber(100_001));
    }
}