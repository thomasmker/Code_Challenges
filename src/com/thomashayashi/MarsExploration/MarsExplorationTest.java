package com.thomashayashi.MarsExploration;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/mars-exploration/problem
 */
class MarsExplorationTest {
    @Test
    void checkSOSMessages(){
        assertEquals(0, marsExploration("SOS"));
        assertEquals(1, marsExploration("SOT"));
        assertEquals(2, marsExploration("TOT"));
        assertEquals(3, marsExploration("TQT"));
        assertEquals(1, marsExploration("SOSSOT"));
    }

    private int marsExploration(String s) {
        String sos = "SOS";
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != sos.charAt(i % 3))
                count++;
        }

        return count;
    }
}
