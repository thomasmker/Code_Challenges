package com.thomashayashi.TimeConversion;

/*
 * Full description: https://www.hackerrank.com/challenges/one-week-preparation-kit-time-conversion/problem
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeConversionTest {

    @Test
    void checkConvertedTime(){
        assertEquals("00:00:00", timeConversion("12:00:00AM"));
        assertEquals("01:00:00", timeConversion("01:00:00AM"));
        assertEquals("12:00:00", timeConversion("12:00:00PM"));
        assertEquals("13:00:00", timeConversion("01:00:00PM"));
    }

    private String timeConversion(String s) {
        String period = s.substring(s.length() - 2);
        String hour = s.substring(0,2);
        String minutes_seconds = s.substring(2,s.length() - 2);

        if (hour.equals("12"))
            hour = "00";

        if (period.equals("PM"))
            hour = Integer.valueOf(12 + Integer.parseInt(hour)).toString();

        return hour + minutes_seconds;
    }
}
