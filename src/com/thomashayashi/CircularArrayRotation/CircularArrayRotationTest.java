package com.thomashayashi.CircularArrayRotation;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/circular-array-rotation/problem
 */
class CircularArrayRotationTest {
    @Test
    void checkRotation(){
        assertEquals(Arrays.asList(2,1), circularArrayRotation(Arrays.asList(1,2),1,Arrays.asList(0,1)));
        assertEquals(Arrays.asList(5,3), circularArrayRotation(Arrays.asList(3,4,5),2,Arrays.asList(1,2)));
        assertEquals(Arrays.asList(2,3,1), circularArrayRotation(Arrays.asList(1,2,3),2,Arrays.asList(0,1,2)));
    }

    private List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        int arraySize = a.size();
        k = k % arraySize;

        Map<Integer, Integer> newPositions = new TreeMap<>();
        for(int i = 0; i < a.size(); i++) {
            int currentValue = a.get(i);
            int newIndexPosition = i + k;

            if (newIndexPosition > arraySize - 1)
                newIndexPosition = newIndexPosition % arraySize;

            newPositions.put(newIndexPosition, currentValue);
        }

        List<Integer> shiftedArray = new ArrayList<>(newPositions.values());

        List<Integer> elements = new ArrayList<>();
        for(Integer query : queries)
            elements.add(shiftedArray.get(query));

        return elements;
    }
}
