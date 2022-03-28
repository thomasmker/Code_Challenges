package com.thomashayashi.BeutifulDaysMovies;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem
 */
class BeautifulDaysMoviesTest {
    @Test
    void checkBeautifulDays(){
        assertEquals(2, beautifulDays(20,23,6));
        assertEquals(33, beautifulDays(13,45,3));
    }

    private int beautifulDays(int i, int j, int k) {
        int beautifulDay = 0;
        for(int day = i; day <= j; day++) {
            int reversedDay = Integer.parseInt(new StringBuilder(String.valueOf(day)).reverse().toString());
            if(Math.abs(day - reversedDay) % k == 0)
                beautifulDay++;
        }
        return beautifulDay;
    }
}
