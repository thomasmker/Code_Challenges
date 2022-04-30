package com.thomashayashi.MiniMaxSum;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/one-week-preparation-kit-mini-max-sum/problem
 */
class MiniMaxSumTest {
    @Test
    void checkMinMaxSum(){
        assertEquals(Arrays.asList(10L,14L), miniMaxSum(Arrays.asList(1,2,3,4,5)));
        assertEquals(Arrays.asList(299L,9271L), miniMaxSum(Arrays.asList(7,69,2,221,8974)));
    }

    private List<Long> miniMaxSum(List<Integer> arr) {
        Collections.sort(arr);
        long sum = 0;
        for(Integer n : arr) sum += n;
        long min = sum - arr.get(arr.size() - 1);
        long max = sum - arr.get(0);
        return Arrays.asList(min, max);
    }

}
