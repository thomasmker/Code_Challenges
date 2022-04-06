package com.thomashayashi.SherlockAndSquares;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/sherlock-and-squares/problem
 */
class SherlockAndSquaresTest {
    @Test
    void checkSquares(){
        assertEquals(2, squares(3,9));
        assertEquals(0, squares(17,24));
        assertEquals(3, squares(35,70));
        assertEquals(22, squares(100,1000));
    }

    private int squares(int a, int b) {
        int start = (int)Math.sqrt(a);
        int end = (int)Math.sqrt(b);

        int squares = 0;
        for(int i = start; i <= end; i++) {
            double squareNum = Math.pow(i , 2);
            if(squareNum >= a && squareNum <= b)
                squares++;
        }
        return squares;
    }
}
