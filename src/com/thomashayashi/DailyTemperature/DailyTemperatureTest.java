package com.thomashayashi.DailyTemperature;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/generate-parentheses/
 */
class DailyTemperatureTest {
    @Test
    void checkTemperature(){
        assertEquals(Arrays.asList(1,1,0), dailyTemperatures(Arrays.asList(30,60,90)));
        assertEquals(Arrays.asList(1,1,1,0), dailyTemperatures(Arrays.asList(30,40,50,60)));
        assertEquals(Arrays.asList(1,1,4,2,1,1,0,0), dailyTemperatures(Arrays.asList(73,74,75,71,69,72,76,73)));
    }

    private List<Integer> dailyTemperatures(List<Integer> temperatures) {
        Stack<Integer> warmerDayIndex = new Stack<>();
        List<Integer> results = new ArrayList<>(Collections.nCopies(temperatures.size(), 0));
        for(int i = 0; i < temperatures.size(); i++) {
            while(!warmerDayIndex.isEmpty() && temperatures.get(warmerDayIndex.peek()) < temperatures.get(i)) {
                int prevDay = warmerDayIndex.pop();
                results.set(prevDay, i - prevDay);
            }
            warmerDayIndex.push(i);
        }

        return results;
    }
}
