package com.thomashayashi.StrangeCounter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/strange-code/problem
 */
class StrangeCounterTest {
    @Test
    void checkCounter(){
        assertEquals(3, strangeCounter(1));
        assertEquals(2, strangeCounter(2));
        assertEquals(1, strangeCounter(3));
        assertEquals(6, strangeCounter(4));
        assertEquals(12, strangeCounter(10));
    }

    private long strangeCounter(long t) {
        long n = 2;
        while (3 * (n - 1) < t)
            n *= 2;
        return (3 * (n - 1) - t + 1);
    }

}
