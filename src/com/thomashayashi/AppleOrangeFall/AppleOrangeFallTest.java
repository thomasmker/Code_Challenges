package com.thomashayashi.AppleOrangeFall;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
* Full description: https://www.hackerrank.com/challenges/apple-and-orange/problem
*/
class AppleOrangeFallTest {
    private AppleOrangeFall appleOrangeFall;

    @BeforeEach
    void setUp() {
        appleOrangeFall = new AppleOrangeFall();
    }

    @Test
    void noApplesNoOrangesHaveFallen() {
        int startPointHouse = 3;
        int endPointHouse = 5;
        int appleTreeLocation = 0;
        int orangeTreeLocation = 10;
        List<Integer> fallenApplesLocation = new ArrayList<>();
        List<Integer> fallenOrangesLocation = new ArrayList<>();

        AppleOrangeFall.NumberFruit fruits = appleOrangeFall.countApplesAndOranges(
                startPointHouse,
                endPointHouse,
                appleTreeLocation,
                orangeTreeLocation,
                fallenApplesLocation,
                fallenOrangesLocation);

        assertEquals(0, fruits.apples);
        assertEquals(0, fruits.oranges);
    }

    @Test
    void applesHaveFallenButNotInTheHouse() {
        int startPointHouse = 3;
        int endPointHouse = 5;
        int appleTreeLocation = 0;
        int orangeTreeLocation = 10;
        List<Integer> fallenApplesLocation = Arrays.asList(-1,0,1);
        List<Integer> fallenOrangesLocation = new ArrayList<>();

        AppleOrangeFall.NumberFruit fruits = appleOrangeFall.countApplesAndOranges(
                startPointHouse,
                endPointHouse,
                appleTreeLocation,
                orangeTreeLocation,
                fallenApplesLocation,
                fallenOrangesLocation);

        assertEquals(0, fruits.apples);
        assertEquals(0, fruits.oranges);
    }

    @Test
    void oneAppleIsInsideTheHouse() {
        int startPointHouse = 3;
        int endPointHouse = 5;
        int appleTreeLocation = 0;
        int orangeTreeLocation = 10;
        List<Integer> fallenApplesLocation = Arrays.asList(-3,0,3);
        List<Integer> fallenOrangesLocation = new ArrayList<>();

        AppleOrangeFall.NumberFruit fruits = appleOrangeFall.countApplesAndOranges(
                startPointHouse,
                endPointHouse,
                appleTreeLocation,
                orangeTreeLocation,
                fallenApplesLocation,
                fallenOrangesLocation);

        assertEquals(1, fruits.apples);
        assertEquals(0, fruits.oranges);
    }

    @Test
    void applesAreIsInsideTheHouse() {
        int startPointHouse = 3;
        int endPointHouse = 5;
        int appleTreeLocation = 0;
        int orangeTreeLocation = 10;
        List<Integer> fallenApplesLocation = Arrays.asList(-3,0,3,4,5);
        List<Integer> fallenOrangesLocation = new ArrayList<>();

        AppleOrangeFall.NumberFruit fruits = appleOrangeFall.countApplesAndOranges(
                startPointHouse,
                endPointHouse,
                appleTreeLocation,
                orangeTreeLocation,
                fallenApplesLocation,
                fallenOrangesLocation);

        assertEquals(3, fruits.apples);
        assertEquals(0, fruits.oranges);
    }

    @Test
    void applesAndOrangesAreIsInsideTheHouse() {
        int startPointHouse = 3;
        int endPointHouse = 5;
        int appleTreeLocation = 0;
        int orangeTreeLocation = 10;
        List<Integer> fallenApplesLocation = Arrays.asList(-3,0,3,4,5);
        List<Integer> fallenOrangesLocation = Arrays.asList(-6,-5,0,1,3);

        AppleOrangeFall.NumberFruit fruits = appleOrangeFall.countApplesAndOranges(
                startPointHouse,
                endPointHouse,
                appleTreeLocation,
                orangeTreeLocation,
                fallenApplesLocation,
                fallenOrangesLocation);

        assertEquals(3, fruits.apples);
        assertEquals(2, fruits.oranges);
    }
}
