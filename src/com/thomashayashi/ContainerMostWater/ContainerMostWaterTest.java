package com.thomashayashi.ContainerMostWater;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/container-with-most-water/
 */
class ContainerMostWaterTest {
    @Test
    void checkContainer(){
        assertEquals(1, maxArea(Arrays.asList(1,1)));
        assertEquals(49, maxArea(Arrays.asList(1,8,6,2,5,4,8,3,7)));
    }

    private int maxArea(List<Integer> height) {
        int left = 0;
        int right = height.size() - 1;
        int res = 0;
        while (left < right) {
            int containerLength = right - left;
            int area = containerLength * Math.min(height.get(left), height.get(right));
            res = Math.max(res, area);
            if (height.get(left) < height.get(right))
                left++;
             else
                right--;
        }
        return res;
    }
}
