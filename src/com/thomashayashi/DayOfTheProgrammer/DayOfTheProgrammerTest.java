package com.thomashayashi.DayOfTheProgrammer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/day-of-the-programmer/problem
 */
class DayOfTheProgrammerTest {

    private static final int DREAD_YEAR = 1918;
    @Test
    void checkThe256thDayOfTheYear(){
        assertEquals("12.09.1800", dayOfProgrammer(1800));
        assertEquals("26.09.1918", dayOfProgrammer(1918));
        assertEquals("12.09.2016", dayOfProgrammer(2016));
        assertEquals("13.09.2017", dayOfProgrammer(2017));
    }

    private String dayOfProgrammer(int year) {
        if(isDreadYear(year)) return "26.09.1918";
        boolean isLeapYear =  isLeapYearBeforeDreadYear(year) || isLeapYearAfterDreadYear(year);
        return String.format("%s.09.%s", isLeapYear ? 12 : 13, year);
    }

    private boolean isDreadYear(int year) {
        return year == DREAD_YEAR;
    }

    private boolean isLeapYearBeforeDreadYear(int year) {
        return (year < DREAD_YEAR) && (year % 4 == 0);
    }

    private boolean isLeapYearAfterDreadYear(int year) {
        return (year > DREAD_YEAR) && (year % 400 == 0 || ((year % 4 == 0) && (year%100 != 0)));
    }

}
