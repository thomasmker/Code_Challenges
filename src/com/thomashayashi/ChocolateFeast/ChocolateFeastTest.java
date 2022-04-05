package com.thomashayashi.ChocolateFeast;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/chocolate-feast/problem
 */
class ChocolateFeastTest {
    @Test
    void checkEatenChocolate(){
        assertEquals(6, chocolateFeast(10,2,5));
        assertEquals(3, chocolateFeast(12,4,4));
        assertEquals(5, chocolateFeast(6,2,2));
    }

    private int chocolateFeast(int n, int c, int m) {
        int eatenChocolate = n / c;

        int chocolateWrapper = eatenChocolate;
        do {
            eatenChocolate += (chocolateWrapper / m);
            chocolateWrapper = (chocolateWrapper / m) + (chocolateWrapper % m);
        } while(chocolateWrapper >= m);

        return eatenChocolate;
    }
}
