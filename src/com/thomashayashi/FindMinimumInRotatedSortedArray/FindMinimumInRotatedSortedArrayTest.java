package com.thomashayashi.FindMinimumInRotatedSortedArray;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
class FindMinimumInRotatedSortedArrayTest {

    @Test
    void checkMinimum(){
        assertEquals(1, findMin(Arrays.asList(3,4,5,1,2)));
        assertEquals(0, findMin(Arrays.asList(4,5,6,7,0,1,2)));
        assertEquals(11, findMin(Arrays.asList(11,13,15,17)));
    }

    private int findMin(List<Integer> numbers) {
        int l = 0;
        int r = numbers.size() - 1;

        while (l <= r) {
            if (numbers.get(l) <= numbers.get(r))
                return numbers.get(l);

            int mid = (l + r) / 2;
            if (numbers.get(mid) >= numbers.get(l))
                l = mid + 1;
            else
                r = mid;
        }
        return 0;
    }
}
