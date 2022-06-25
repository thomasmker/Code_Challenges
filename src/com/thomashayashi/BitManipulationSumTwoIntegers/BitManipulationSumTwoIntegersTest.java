package com.thomashayashi.BitManipulationSumTwoIntegers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/sum-of-two-integers/
 */
class BitManipulationSumTwoIntegersTest {
    @Test
    void checkSum(){
        assertEquals(3, getSum(1,2));
        assertEquals(5, getSum(2,3));
    }

    private int getSum(int a, int b) {
        while (b != 0) {
            int tmp = (a & b) << 1;
            a = (a ^ b);
            b = tmp;
        }
        return a;
    }
}
