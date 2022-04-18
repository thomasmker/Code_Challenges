package com.thomashayashi.MinimumDistances;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/minimum-distances/problem
 */
class MinimumDistancesTest {
    @Test
    void checkMinimumDistance(){
        assertEquals(-1, minimumDistances(Arrays.asList(3,2,1)));
        assertEquals(2, minimumDistances(Arrays.asList(3,2,1,2,3)));
    }

    private int minimumDistances(List<Integer> a) {
        HashMap<Integer, List<Integer>> numIndex = new HashMap<>();

        for(int i = 0; i < a.size(); i++) {
            int num = a.get(i);
            List<Integer> index = new ArrayList<>();

            if (numIndex.containsKey(num))
                index = numIndex.get(num);

            index.add(i);
            numIndex.put(num, index);
        }

        Integer minDistance = null;
        for(Integer num : numIndex.keySet()) {
            List<Integer> index = numIndex.get(num);
            if(index.size() == 1) continue;

            int distance = Math.abs(index.get(0) - index.get(1));
            if(minDistance == null || minDistance > distance)
                minDistance = distance;
        }

        return minDistance == null ? - 1: minDistance;
    }
}
