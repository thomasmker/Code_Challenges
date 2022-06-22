package com.thomashayashi.BitManipulationReverseBits;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/reverse-bits/
 */
class BitManipulationReverseBitsTest {
    @Test
    void checkIndex(){
        assertEquals(0, reverseBits(0));
        assertEquals(964176192, reverseBits(43261596));
    }

    private int reverseBits(int n) {
        int pos = 31;
        int revNum = 0;
        while (pos >= 0) {
            revNum <<= 1;
            if ((n & 1) == 1)
                revNum++;

            n >>= 1;
            pos--;
        }
        return revNum;
    }
}
