package com.thomashayashi.LongestConsecutiveSequence;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestConsecutiveSequenceTest {
    @Test
    void checkIndex(){
        assertEquals(4, longestConsecutive(Arrays.asList(100,4,200,1,3,2)));
        assertEquals(9, longestConsecutive(Arrays.asList(0,3,7,2,5,8,4,6,0,1)));
    }

    private int longestConsecutive(List<Integer> nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int n: nums)
            map.put(n, true);

        int longest = 0;
        for (int n: nums) {
            if (!map.get(n))
                continue;

            map.put(n, false);
            int current = 1;
            int left = n - 1;
            int right = n + 1;
            while(map.containsKey(left)) {
                map.put(left, false);
                left--;
                current++;
            }
            while(map.containsKey(right)) {
                map.put(right, false);
                right++;
                current++;
            }

            if (current > longest)
                longest = current;

        }
        return longest;
    }
}
