package com.thomashayashi.BinarySearch;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/binary-search/
 */
class BinarySearchTest {

    @Test
    void checkSearch(){
        assertEquals(4, search(Arrays.asList(-1,0,3,5,9,12), 9));
        assertEquals(-1, search(Arrays.asList(-1,0,3,5,9,12), 2));
    }

    private int search(List<Integer> nums, int target) {
        int i = 0;
        int j = nums.size() - 1;

        while(i <= j){
            int mid = (i+j)/2;

            if(nums.get(mid) == target)
                return mid;
            else if(nums.get(mid) < target)
                i = mid+1;
            else
                j = mid-1;
        }

        return -1;
    }
}
