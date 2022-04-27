package com.thomashayashi.EqualizeTheArray;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/cut-the-sticks/problem
 */
class EqualizeTheArrayTest {
    @Test
    void checkArray(){
        assertEquals(2, equalizeArray(Arrays.asList(1,2,2,3)));
        assertEquals(2, equalizeArray(Arrays.asList(3,3,2,1,3)));
    }

    private int equalizeArray(List<Integer> arr) {
        int max = 1;
        Map<Integer, Integer> nums = new HashMap<>();
        for (Integer i : arr) {
            int value = 1;
            if (nums.containsKey(i))
                value = nums.get(i) + 1;

            nums.put(i, value);
            if (max < value) max = value;
        }
        return arr.size() - max;
    }
}
