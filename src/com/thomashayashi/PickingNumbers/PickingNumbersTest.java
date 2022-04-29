package com.thomashayashi.PickingNumbers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/picking-numbers/problem
 */
class PickingNumbersTest {
    @Test
    void checkLongestSubSet(){
        assertEquals(2, pickingNumbers(Arrays.asList(1,1)));
        assertEquals(3, pickingNumbers(Arrays.asList(4,6,5,3,3,1)));
        assertEquals(5, pickingNumbers(Arrays.asList(1,2,2,3,1,2)));
    }

    private int pickingNumbers(List<Integer> a) {
        HashMap<Integer, Integer> numOccurrences = new HashMap<>();
        for(Integer num : a) {
            int occurrence = 1;
            if(numOccurrences.containsKey(num))
                occurrence = numOccurrences.get(num) + 1;

            numOccurrences.put(num, occurrence);
        }

        int longestStreak = -1;
        for(Integer num : numOccurrences.keySet()) {
            int currentOccurrence = numOccurrences.get(num);
            int neighborOccurrence = numOccurrences.getOrDefault(num + 1, 0);
            int sum = currentOccurrence + neighborOccurrence;
            if(sum > longestStreak)
                longestStreak = sum;
        }

        return longestStreak;
    }
}
