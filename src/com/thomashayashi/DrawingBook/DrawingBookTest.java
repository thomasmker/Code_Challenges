package com.thomashayashi.DrawingBook;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/*
 * Full description: https://www.hackerrank.com/challenges/drawing-book/problem
 */
import static org.junit.jupiter.api.Assertions.assertEquals;

class DrawingBookTest {
    @Test
    void checkPageCount(){
        assertEquals(0, pageCount(1,1));
        assertEquals(0, pageCount(5,4));

        assertEquals(1, pageCount(4,3));
    }

    private int pageCount(int n, int p) {
        // Going from front
        // 0,1 = 0
        // 2,3 = 1
        // 4,5 = 2

        // Going from back
        // 4,5 = 0
        // 2,3 = 1
        // 0,1 = 2

        boolean isCloserToBack = (n - p) < p;
        if(isCloserToBack)
            p = (n - p) + isEvenPage(p);

        return p / 2;
    }

    private int isEvenPage(int p) {
        return (p % 2 == 0) ? 0 : 1;
    }
}
