package com.thomashayashi.JumpingOnClouds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited/problem
 */
class JumpingOnCloudsTest {
    @Test
    void checkEnergy() {
        assertEquals(98, jumpingOnClouds(new int[]{0, 0}, 1));
        assertEquals(96, jumpingOnClouds(new int[]{0, 1}, 1));
        assertEquals(96, jumpingOnClouds(new int[]{0, 0, 1, 0}, 2));
        assertEquals(92, jumpingOnClouds(new int[]{0,0,1,0,0,1,1,0}, 2));
    }

    private int jumpingOnClouds(int[] c, int k) {
        int energy = 100;

        int pos = 0;
        do {
            pos = (pos + k) % c.length;
            energy -= c[pos] * 2 + 1;
        } while(pos != 0);

        return energy;
    }
}
