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
        Stack<Integer> warmerDay = new Stack<>();
        List<Integer> results = new ArrayList<>(Collections.nCopies(temperatures.size(), 0));
        for(int day = 0; day < temperatures.size(); day++) {
            while(!warmerDay.isEmpty() && temperatures.get(warmerDay.peek()) < temperatures.get(day)) {
                int prevDay = warmerDay.pop();
                results.set(prevDay, day - prevDay);
            }
            warmerDay.push(day);
        }

        return results;
    }
}
