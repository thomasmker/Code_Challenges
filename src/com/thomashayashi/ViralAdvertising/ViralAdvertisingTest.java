package com.thomashayashi.ViralAdvertising;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/strange-advertising/problem
 */
class ViralAdvertisingTest {
    @Test
    void checkAccumulatedLikes(){
        assertEquals(2, viralAdvertising(1));
        assertEquals(5, viralAdvertising(2));
        assertEquals(9, viralAdvertising(3));
        assertEquals(24, viralAdvertising(5));
    }

    private int viralAdvertising(int n) {
        int peopleShared = 5;
        int cumulativeLikes = 0;
        for(int day = 1; day <=n; day++) {
            int likes =  peopleShared / 2;
            peopleShared = likes * 3;
            cumulativeLikes += likes;
        }
        return cumulativeLikes;
    }
}
