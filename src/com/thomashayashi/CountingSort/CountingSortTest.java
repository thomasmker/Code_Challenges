package com.thomashayashi.CountingSort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/one-week-preparation-kit-countingsort1/problem
 */
class CountingSortTest {
    @Test
    void countSorts(){
        assertEquals(Arrays.asList(0,3,1,1), countingSort(Arrays.asList(1,1,3,2,1)));
    }

    private List<Integer> countingSort(List<Integer> arr) {
        int[] counter = new int[4];
        for(Integer num: arr)
            counter[num] += 1;
        return Arrays.stream(counter).boxed().collect(Collectors.toList());
    }
}
