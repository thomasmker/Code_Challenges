package com.thomashayashi.LibraryFine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/library-fine/problem
 */
class LibraryFineTest {
    @Test
    void checkFine(){
        assertEquals(10000, libraryFine(1,1,2000,1,1,1999));
        assertEquals(1500, libraryFine(1,5,2000,1,2,2000));
        assertEquals(150, libraryFine(11,1,2000,1,1,2000));
        assertEquals(0, libraryFine(9,1,2000,10,1,2000));
        assertEquals(0, libraryFine(1,1,1999,1,1,2000));
    }

    private int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        if(y1 > y2) return 10000;
        if(y1 < y2) return 0;
        if(m1 > m2) return 500 * (m1 - m2);
        if(m1 < m2) return 0;
        if(d1 > d2) return 15 * (d1 - d2);
        return 0;
    }
}
