package com.thomashayashi.SalesByMatch;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
* Problem: There is a large pile of socks that must be paired by color. Given an array of integers representing
* the color of each sock, determine how many pairs of socks with matching colors there are.
*
* Example:
* n = 7
* ar = [1,2,1,2,1,3,2]
* There is one pair of color 1 and one of color 2. There are three odd socks left, one of each color.
* The number of pairs is 2.
*
* Constraints:
* 1 <= n <= 100
* 1 <= ar[i] <= 100 where 0 <= i < n
*
* Full description: https://www.hackerrank.com/challenges/sock-merchant/problem
*/
class SalesByMatchTest {


    @Test
    void shouldReturnZeroWithOnlyOneSock() {
        List<Integer> colorsEachSock = new ArrayList<>();
        colorsEachSock.add(1);
        int numberOfPairs = SockMerchant.calculatePairs(colorsEachSock);
        assertEquals(0, numberOfPairs);
    }

    @Test
    void shouldReturnZeroWithNoMatchingSocks()
    {
        List<Integer> colorsEachSock = Arrays.asList(1,2,3,4);
        int numberOfPairs = SockMerchant.calculatePairs(colorsEachSock);
        assertEquals(0, numberOfPairs);
    }

    @Test
    void shouldReturnOnePairWithTwoEqualSocks()
    {
        List<Integer> colorsEachSock = Arrays.asList(1,1);
        int numberOfPairs = SockMerchant.calculatePairs(colorsEachSock);
        assertEquals(1, numberOfPairs);
    }

    @Test
    void shouldReturnOnePairWithThreeEqualSocks()
    {
        List<Integer> colorsEachSock = Arrays.asList(1,1,1);
        int numberOfPairs = SockMerchant.calculatePairs(colorsEachSock);
        assertEquals(1, numberOfPairs);
    }

    @Test
    void shouldReturnTwoPairsWithTwoGreenSocksAnd2RedSocks()
    {
        List<Integer> colorsEachSock = Arrays.asList(1,1,2,2);
        int numberOfPairs = SockMerchant.calculatePairs(colorsEachSock);
        assertEquals(2, numberOfPairs);
    }

    @Test
    void shouldReturnTwoPairsWithTwoGreenSocksAnd2RedSocksWithoutOrder()
    {
        List<Integer> colorsEachSock = Arrays.asList(2,1,2,1);
        int numberOfPairs = SockMerchant.calculatePairs(colorsEachSock);
        assertEquals(2, numberOfPairs);
    }
}