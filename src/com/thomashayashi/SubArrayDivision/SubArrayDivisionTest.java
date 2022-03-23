package com.thomashayashi.SubArrayDivision;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/the-birthday-bar/problem
 */
class SubArrayDivisionTest {
    @Test
    void checkSubArrayDivision() {
        assertEquals(0, birthday(Arrays.asList(1,1),1,2));
        assertEquals(1, birthday(Arrays.asList(1,1),2,2));

        assertEquals(0, birthday(Arrays.asList(1,1,1,1,1),3,1));
        assertEquals(2, birthday(Arrays.asList(1,2,1,3,2),3,2));
        assertEquals(0, birthday(Arrays.asList(1,1,1,1,1),3,2));
    }

    private int birthday(List<Integer> s, int d, int m) {
        int numOfDivisions = 0;
        int[] segments = s.stream().mapToInt(Integer::intValue).toArray();
        for(int i = 0; i < s.size(); i++) {
            if(i+m <= s.size()) {
                int[] slice = Arrays.copyOfRange(segments, i, i + m);
                int sum = IntStream.of(slice).sum();
                if (sum == d)
                    numOfDivisions++;
            }
        }
        return numOfDivisions;
    }
}
