package com.thomashayashi.DiagonalDifference;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/one-week-preparation-kit-diagonal-difference/problem
 */
class DiagonalDifferenceTest {
    @Test
    void checkLonelyNumber(){
        assertEquals(2, diagonalDifference(Arrays.asList(Arrays.asList(1,2,3), Arrays.asList(4,5,6), Arrays.asList(9,8,9))));
    }

    private int diagonalDifference(List<List<Integer>> arr) {
        int index = 0, leftDiagonal = 0, rightDiagonal = 0;
        int size = arr.size() - 1;
        for(List<Integer> row : arr) {
            leftDiagonal += row.get(index);
            rightDiagonal += row.get(size - index);
            index++;
        }

        return Math.abs(leftDiagonal - rightDiagonal);
    }
}
