package com.thomashayashi.CarFleet;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/car-fleet/
 */
class CarFleetTest {

    @Test
    void checkTemperature(){
        assertEquals(1, carFleet(0, List.of(1), Collections.emptyList()));
        assertEquals(1, carFleet(10, List.of(3), List.of(3)));
        assertEquals(3, carFleet(12, Arrays.asList(10,8,0,5,3), Arrays.asList(2,4,1,1,3)));
    }

    private int carFleet(int target, List<Integer> position, List<Integer> speed) {
        if (position.size() == 1) return 1;

        int[][] combine = new int[position.size()][2];
        for (int i = 0; i < position.size(); i++) {
            combine[i][0] = position.get(i);
            combine[i][1] = speed.get(i);
        }
        Arrays.sort(combine, java.util.Comparator.comparingInt(o -> o[0]));

        Stack<Double> stack = new Stack<>();
        for (int i = combine.length - 1; i >= 0; i--) {
            double currentTime = (double) (target - combine[i][0]) / combine[i][1];

            if (!stack.isEmpty() && currentTime <= stack.peek())
                continue;

            stack.push(currentTime);
        }
        return stack.size();
    }
}
