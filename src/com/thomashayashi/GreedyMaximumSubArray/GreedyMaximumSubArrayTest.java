package com.thomashayashi.GreedyMaximumSubArray;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/maximum-subarray/
 */
class GreedyMaximumSubArrayTest {
    @Test
    void checkMaxSubArraySum(){
        assertEquals(6, maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
        assertEquals(23, maxSubArray(new int[] {5,4,-1,7,8}));
    }

    private int maxSubArray(int[] nums) {
        if(nums.length == 1)
            return nums[0];

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(int n : nums){
            sum += n;
            max = Math.max(max, sum);

            if(sum < 0)
                sum = 0;
        }
        return max;
    }
}
