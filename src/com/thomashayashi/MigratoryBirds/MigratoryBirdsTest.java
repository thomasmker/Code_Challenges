package com.thomashayashi.MigratoryBirds;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/migratory-birds/problem
 */
class MigratoryBirdsTest {
    @Test
    void checkMostFrequentBird(){
        assertEquals(1,migratoryBirds(Arrays.asList(1,1)));
        assertEquals(2,migratoryBirds(Arrays.asList(2,2)));
        assertEquals(2,migratoryBirds(Arrays.asList(2,1,2)));
        assertEquals(1,migratoryBirds(Arrays.asList(2,1,2,1)));

        assertEquals(4,migratoryBirds(Arrays.asList(1,4,4,4,5,3)));
        assertEquals(3,migratoryBirds(Arrays.asList(1,2,3,4,5,4,3,2,1,3,4)));
    }

    private int migratoryBirds(List<Integer> arr) {

        TreeMap<Integer, Integer> birdCount = new TreeMap<>();
        for (int birdType : arr) {
            int currentBirdCount = 1;
            if (birdCount.containsKey(birdType))
                currentBirdCount = birdCount.get(birdType) + 1;

            birdCount.put(birdType, currentBirdCount);
        }

        int mostFrequentBirdId = 0;
        int maxBirdCount = 0;
        for(Integer birdType : birdCount.keySet()) {
            int currentBirdCount = birdCount.get(birdType);
            if(currentBirdCount > maxBirdCount) {
                maxBirdCount = currentBirdCount;
                mostFrequentBirdId = birdType;
            }
        }

        return mostFrequentBirdId;
    }
}
