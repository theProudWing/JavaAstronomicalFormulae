/**
 * Created by: Ben Jones
 * Date:05/07/2026
 * Time:14:56
 */

package main.java;

public class EasterCalculator {

    public static void main(String[] args){
        EasterCalculator calc = new EasterCalculator();

        calc.dateOfEasterSunday(2027);
    }

    // This method takes a Gregorian calendar 'year' as a param and prints the date of Easter Sunday within that year.
    private void dateOfEasterSunday(final int year){
        if (year < 1583){
            System.out.println("Error: Provided year is before 1583. Please provide a year in the Gregorian Calendar.");
        }
        else {
            int x = year;
            int a = x % 19;
            int b = x / 100;
            int c = x % 100;
            int d = b / 4;
            int e = b % 4;
            int f = (b + 8) / 25;
            int g = (b - f + 1) / 3;
            int h = ((19 * a) + (b - d - g) + 15) % 30;
            int i = c / 4;
            int k = c % 4;
            int l = (32 + (2 * e) + (2 * i) - h - k) % 7;
            int m = (a + (11 * h) + (22 * l)) / 451;

            int monthNum = (h + l - (7 * m) + 114) / 31;
            int dayOfMonth = ((h + l - (7 * m) + 114) % 31) + 1;

            System.out.println("In " + year + ", Easter Sunday falls on the " + formattedOrdinalNumber(dayOfMonth) + " of " + dateName(monthNum) + ".");
        }
    }
    public String dateName(final int month){
        return switch (month) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> "Error: Integer Provided does not correspond to a Julian Month";
        };
    }
    public String formattedOrdinalNumber(final int number){
        String numberString = Integer.toString(number);
        String suffix = "th";
        int finalDigit = Character.getNumericValue(numberString.charAt(numberString.length() - 1));
        suffix = switch (finalDigit) {
            case 1 -> "st";
            case 2 -> "nd";
            case 3 -> "rd";
            default -> suffix;
        };
        return numberString + suffix;
    }

}
