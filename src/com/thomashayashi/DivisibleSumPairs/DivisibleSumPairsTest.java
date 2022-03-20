package com.thomashayashi.DivisibleSumPairs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/divisible-sum-pairs/problem
 */
class DivisibleSumPairsTest {
    @Test
    void checkNumOfDivisibleSumPairs() {
        assertEquals(0, divisibleSumPairs(2, 2, Arrays.asList(1,2)));
        assertEquals(1, divisibleSumPairs(2, 2, Arrays.asList(1,1)));

        assertEquals(5, divisibleSumPairs(6, 3, Arrays.asList(1,3,2,6,1,2)));
    }

    public int divisibleSumPairs(int n, int k, List<Integer> ar) {
        HashMap<Integer, Integer> sumPairOccurrences = getSumPairOccurrences(n, ar);
        return getTotalDivisibleSumPairs(k, sumPairOccurrences);
    }

    private HashMap<Integer, Integer> getSumPairOccurrences(int n, List<Integer> ar) {
        HashMap<Integer, Integer> sumPairOccurrences = new HashMap<>();
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int sumPair = ar.get(i) + ar.get(j);
                if(sumPairOccurrences.containsKey(sumPair))
                    sumPairOccurrences.put(sumPair, sumPairOccurrences.get(sumPair) + 1);
                else
                    sumPairOccurrences.put(sumPair, 1);
            }
        }
        return sumPairOccurrences;
    }

    private int getTotalDivisibleSumPairs(int k, HashMap<Integer, Integer> sumPairOccurrences) {
        int totalDivisibleSumPairs = 0;
        for(Integer sum : sumPairOccurrences.keySet()) {
            if(sum % k == 0)
                totalDivisibleSumPairs += sumPairOccurrences.get(sum);
        }

        return totalDivisibleSumPairs;
    }
}
