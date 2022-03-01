package com.thomashayashi.ArrayDS;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
* Given a n x n 2D Array arr
* An hourglass in A is a subset of values with indices falling in this pattern:
* a b c
*   d
* e f g
*
* Print the largest (maximum) hourglass sum found in arr
*
* Full description: https://www.hackerrank.com/challenges/2d-array/problem
* */
public class HourGlassTest {

    @Test
    void shouldReturnZeroWithAllZeros() {
        List<Integer> row1 = Arrays.asList(0,0,0);
        List<Integer> row2 = Arrays.asList(0,0,0);
        List<Integer> row3 = Arrays.asList(0,0,0);

        List<List<Integer>> arr = new ArrayList<>(Arrays.asList(row1, row2, row3));
        int hourGlassSum = HourGlass.hourglassSum(arr);
        assertEquals(0, hourGlassSum);
    }

    @Test
    void shouldIgnoreWaistNumbersAndReturnZero() {
        List<Integer> row1 = Arrays.asList(0,0,0);
        List<Integer> row2 = Arrays.asList(1,0,1);
        List<Integer> row3 = Arrays.asList(0,0,0);

        List<List<Integer>> arr = new ArrayList<>(Arrays.asList(row1, row2, row3));
        int hourGlassSum = HourGlass.hourglassSum(arr);
        assertEquals(0, hourGlassSum);
    }

    @Test
    void shouldGetTheHourGlassValuesIgnoringFourAndSix() {
        List<Integer> row1 = Arrays.asList(1,2,3);
        List<Integer> row2 = Arrays.asList(4,5,6);
        List<Integer> row3 = Arrays.asList(7,8,9);

        List<List<Integer>> arr = new ArrayList<>(Arrays.asList(row1, row2, row3));
        List<List<Integer>> hourGlassValues = HourGlass.getHourGlassesValues(arr);
        assertEquals(Arrays.asList(1,2,3,5,7,8,9), hourGlassValues.get(0));
    }

    @Test
    void shouldReturnSevenWithHourGlassWithOnes() {
        List<Integer> row1 = Arrays.asList(1,1,1);
        List<Integer> row2 = Arrays.asList(0,1,0);
        List<Integer> row3 = Arrays.asList(1,1,1);

        List<List<Integer>> arr = new ArrayList<>(Arrays.asList(row1, row2, row3));
        int hourGlassSum = HourGlass.hourglassSum(arr);
        assertEquals(7, hourGlassSum);
    }

    @Test
    void shouldReturnTwoHorizontalHourGlasses() {
        List<Integer> row1 = Arrays.asList( 1, 2, 3, 4);
        List<Integer> row2 = Arrays.asList( 5, 6, 7, 8);
        List<Integer> row3 = Arrays.asList( 9,10,11,12);

        List<List<Integer>> arr = new ArrayList<>(Arrays.asList(row1, row2, row3));
        List<List<Integer>> hourGlassValues = HourGlass.getHourGlassesValues(arr);
        assertEquals(Arrays.asList(1,2,3,6,9,10,11), hourGlassValues.get(0));
        assertEquals(Arrays.asList(2,3,4,7,10,11,12), hourGlassValues.get(1));
    }

    @Test
    void shouldReturnTwoVerticalHourGlasses() {
        List<Integer> row1 = Arrays.asList( 1, 2, 3);
        List<Integer> row2 = Arrays.asList( 4, 5, 6);
        List<Integer> row3 = Arrays.asList( 7, 8, 9);
        List<Integer> row4 = Arrays.asList(10,11,12);

        List<List<Integer>> arr = new ArrayList<>(Arrays.asList(row1, row2, row3, row4));
        List<List<Integer>> hourGlassValues = HourGlass.getHourGlassesValues(arr);
        assertEquals(Arrays.asList(1,2,3,5,7,8,9), hourGlassValues.get(0));
        assertEquals(Arrays.asList(4,5,6,8,10,11,12), hourGlassValues.get(1));
    }

    @Test
    void shouldReturnTheSumValueOfTheBiggesHorizontaltHourGlass() {
        List<Integer> row1 = Arrays.asList( 1, 1, 1, 2);
        List<Integer> row2 = Arrays.asList( 1, 1, 1, 1);
        List<Integer> row3 = Arrays.asList( 1, 1, 1, 1);

        List<List<Integer>> arr = new ArrayList<>(Arrays.asList(row1, row2, row3));
        int iBiggestHourGlass = HourGlass.hourglassSum(arr);
        assertEquals(8, iBiggestHourGlass);
    }

    @Test
    void shouldReturnTheSumValueOfTheBiggestVerticalHourGlass() {
        List<Integer> row1 = Arrays.asList( 1, 1, 1);
        List<Integer> row2 = Arrays.asList( 1, 1, 1);
        List<Integer> row3 = Arrays.asList( 1, 1, 1);
        List<Integer> row4 = Arrays.asList( 1, 1, 2);

        List<List<Integer>> arr = new ArrayList<>(Arrays.asList(row1, row2, row3, row4));
        int iBiggestHourGlass = HourGlass.hourglassSum(arr);
        assertEquals(8, iBiggestHourGlass);
    }
}