package com.thomashayashi.LeftRotation;

import java.util.*;


public class LeftRotation {

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        int arraySize = a.size();
        d = d % arraySize;

        Map<Integer, Integer> newPositions = new TreeMap<>();
        for(int currentIndex = a.size() - 1; currentIndex >= 0; currentIndex--) {
            int currentValue = a.get(currentIndex);
            int newIndexPosition = currentIndex - d;

            if (newIndexPosition < 0)
                newIndexPosition = newIndexPosition + arraySize;

            newPositions.put(newIndexPosition, currentValue);
        }

        return new ArrayList<>(newPositions.values());
    }

}
