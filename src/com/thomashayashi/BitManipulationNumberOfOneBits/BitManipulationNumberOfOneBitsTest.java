package com.thomashayashi.BitManipulationNumberOfOneBits;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/number-of-1-bits/
 */
class BitManipulationNumberOfOneBitsTest {
    @Test
    void checkNumberOfOne(){
        assertEquals(0, hammingWeight(0));
        assertEquals(1, hammingWeight(1));
        assertEquals(1, hammingWeight(2));
        assertEquals(2, hammingWeight(3));
        assertEquals(1, hammingWeight(4));
    }

    private int hammingWeight(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++){
            if((n & 1) == 1)
                count++;
            n = n >> 1;
        }
        return count;
    }
}
