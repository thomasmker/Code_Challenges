package com.thomashayashi.UtopianTree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/utopian-tree/problem
 */
class UtopianTreeTest {
    @Test
    void checkUtopianTreeHeight(){
        assertEquals(1, utopianTree(0));
        assertEquals(2, utopianTree(1));
        assertEquals(3, utopianTree(2));
        assertEquals(6, utopianTree(3));
        assertEquals(7, utopianTree(4));
        assertEquals(14, utopianTree(5));
    }

    private int utopianTree(int n) {
        if(n == 0)
            return 1;
        else if(n % 2 == 1)
            return utopianTree(n - 1) * 2;
        else
            return utopianTree(n - 1) + 1;
    }
}
