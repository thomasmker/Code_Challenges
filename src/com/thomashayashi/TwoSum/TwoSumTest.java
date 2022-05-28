package com.thomashayashi.TwoSum;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/two-sum/
 */
class TwoSumTest {
    @Test
    void checkSumPossibilities(){
        assertEquals(Arrays.asList(0,1), twoSum(Arrays.asList(2,7,11,15), 9));
        assertEquals(Arrays.asList(1,2), twoSum(Arrays.asList(3,2,4), 6));
    }

    private List<Integer> twoSum(List<Integer> nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            if (map.containsKey(nums.get(i)))
                return Arrays.asList(map.get(nums.get(i)), i);

            map.put(target - nums.get(i), i);
        }
        return Collections.emptyList();
    }
}
