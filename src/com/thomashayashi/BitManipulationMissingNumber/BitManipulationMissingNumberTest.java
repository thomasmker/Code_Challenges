package com.thomashayashi.BitManipulationMissingNumber;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/missing-number/
 */
class BitManipulationMissingNumberTest {
    @Test
    void checkMissingNumber(){
        assertEquals(2, missingNumber(new int[] {3 ,0 ,1}));
        assertEquals(4, missingNumber(new int[] {3 ,0 ,1, 2}));
    }

    private int missingNumber(int[] nums) {
        int total = nums.length * (nums.length+1)/2;

        int sum = 0;
        for (int num : nums)
            sum += num;

        return total - sum;
    }
}
