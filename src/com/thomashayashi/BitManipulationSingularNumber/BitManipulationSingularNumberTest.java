package com.thomashayashi.BitManipulationSingularNumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/single-number/
 */
class BitManipulationSingularNumberTest {
    @Test
    void checkUniqueIntegerBitManipulation(){
        assertEquals(1, singleNumber(new int[] {2,2,1}));
        assertEquals(4, singleNumber(new int[] {4,1,2,1,2}));
    }

    private int singleNumber(int[] nums) {
        int x1 = nums[0];
        for (int i = 1; i < nums.length; i++)
            x1 ^= nums[i];
        return x1;
    }
}
