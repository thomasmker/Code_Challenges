package com.thomashayashi.TwoSum;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
class TwoSumTwoTest {
    @Test
    void checkSumPossibilities(){
        assertEquals(Arrays.asList(1,2), twoSum(Arrays.asList(2,7,11,15), 9));
        assertEquals(Arrays.asList(1,3), twoSum(Arrays.asList(2,3,4), 6));
    }

    private List<Integer> twoSum(List<Integer> numbers, int target) {
        int a_pointer = 0;
        int b_pointer = numbers.size() - 1;
        int num_a, num_b;

        while(a_pointer < b_pointer) {
            num_a = numbers.get(a_pointer);
            num_b = numbers.get(b_pointer);

            if(num_a + num_b == target)
                break;

            if(num_a + num_b < target)
                a_pointer++;
            else
                b_pointer--;
        }

        return Arrays.asList(a_pointer + 1, b_pointer + 1);
    }
}
