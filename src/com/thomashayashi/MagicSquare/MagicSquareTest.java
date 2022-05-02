package com.thomashayashi.MagicSquare;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/magic-square-forming/problem
 */
class MagicSquareTest {
    @Test
    void checkMagicSquare(){
        assertEquals(0, formingMagicSquare(Arrays.asList(Arrays.asList(4,9,2), Arrays.asList(3,5,7), Arrays.asList(8,1,6))));
        assertEquals(1, formingMagicSquare(Arrays.asList(Arrays.asList(4,9,2), Arrays.asList(3,5,7), Arrays.asList(8,1,5))));
    }

    private int formingMagicSquare(List<List<Integer>> s) {
        List<Integer> square = new ArrayList<>();
        square.addAll(s.get(0));
        square.addAll(s.get(1));
        square.addAll(s.get(2));

        int[][] matrix={{4,9,2,3,5,7,8,1,6},
                {2,7,6,9,5,1,4,3,8},
                {6,1,8,7,5,3,2,9,4},
                {8,3,4,1,5,9,6,7,2},
                {2,9,4,7,5,3,6,1,8},
                {6,7,2,1,5,9,8,3,4},
                {8,1,6,3,5,7,4,9,2},
                {4,3,8,9,5,1,2,7,6}};

        int minOff = 99;
        for (int i = 0; i < 8; i++) {
            int off = 0;
            for (int j = 0; j < 9; j++) {
                if (square.get(j) != matrix[i][j]) {
                    off += Math.abs(square.get(j) - matrix[i][j]);
                }
            }
            if (off < minOff) minOff = off;
        }

        return minOff;
    }
}
