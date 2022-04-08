package com.thomashayashi.HurdleRace;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/the-hurdle-race/problem
 */
public class HurdleRaceTest {
    @Test
    void checkNumPotions(){
        assertEquals(2, hurdleRace(4, Arrays.asList(1,6,3,5,2)));
        assertEquals(0, hurdleRace(7, Arrays.asList(2,5,4,5,2)));
    }

    private int hurdleRace(int k, List<Integer> height) {
        int potions = Collections.max(height) - k;
        return Math.max(potions, 0);
    }
}
