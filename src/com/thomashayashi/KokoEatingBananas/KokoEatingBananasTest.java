package com.thomashayashi.KokoEatingBananas;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/koko-eating-bananas/
 */
class KokoEatingBananasTest {
    @Test
    void checkIndex(){
        assertEquals(4, minEatingSpeed(Arrays.asList(3,6,7,11), 8));
        assertEquals(30, minEatingSpeed(Arrays.asList(30,11,23,4,20), 5));
        assertEquals(23, minEatingSpeed(Arrays.asList(30,11,23,4,20), 6));
    }

    private int minEatingSpeed(List<Integer> piles, int h) {
        int left = 1;
        int right = getRight(piles);

        while (left < right) {
            int hourSpent = 0;

            int middle = (left + right) / 2;
            for (int pile : piles)
                hourSpent += Math.ceil((double) pile / middle);

            if (hourSpent <= h)
                right = middle;
            else
                left = middle + 1;
        }

        return right;
    }

    private int getRight(List<Integer> piles) {
        int right = 1;
        for (int pile : piles)
            right = Math.max(right, pile);
        return right;
    }
}
