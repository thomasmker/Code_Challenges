package com.thomashayashi.TaumAndBday;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/taum-and-bday/problem
 */
class TaumAndBdayTest {

    @Test
    void checkMinimumCost(){
        assertEquals(20, taumBday(10, 10, 1,1, 1));
        assertEquals(37, taumBday(5, 9, 2,3, 4));
        assertEquals(12, taumBday(3, 6, 9,1 ,1));
        assertEquals(35, taumBday(7, 7, 4,2 ,1));
    }

    private long taumBday(int b, int w, int bc, int wc, int z) {
        return ((long) b * Math.min(bc, wc + z)) + ((long) w * Math.min(wc, bc + z));
    }
}
