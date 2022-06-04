package com.thomashayashi.HalloweenSale;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/halloween-sale/problem
 */
class HalloweenSaleTest {
    @Test
    void checkGames(){
        assertEquals(0, howManyGames(15,1,1,10));
        assertEquals(5, howManyGames(20,3,6,70));
        assertEquals(6, howManyGames(20,3,6,80));
    }

    private int howManyGames(int p, int d, int m, int s) {
        int games = 0;
        while(s >= 0) {
            s -= Math.max(p, m);
            p -= d;
            games++;
        }

        return Math.max(0, games - 1);
    }
}
