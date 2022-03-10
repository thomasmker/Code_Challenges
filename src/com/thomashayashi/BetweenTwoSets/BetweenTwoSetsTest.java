package com.thomashayashi.BetweenTwoSets;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
* Full description: https://www.hackerrank.com/challenges/between-two-sets/problem
*/
class BetweenTwoSetsTest {
    @Test
    void whenThereIsOnlyFactorAndTheFactorIsTheSame_ThenOnlyOneNumberIsBetweenSets(){
        List<Integer> factorsOfTheNumbers = Collections.singletonList(1);
        List<Integer> numbersFactorAllElements = Collections.singletonList(1);
        int numbersBetweenSets = BetweenTwoSets.getTotalX(factorsOfTheNumbers, numbersFactorAllElements);
        assertEquals(1, numbersBetweenSets);
    }

    @Test
    void whenTheFactorsArePrimes_ThenThereIsNoNumberBetweenSets(){
        List<Integer> factorsOfTheNumbers = Collections.singletonList(2);
        List<Integer> numbersFactorAllElements = Collections.singletonList(3);
        int numbersBetweenSets = BetweenTwoSets.getTotalX(factorsOfTheNumbers, numbersFactorAllElements);
        assertEquals(0, numbersBetweenSets);
    }

    @Test
    void whenTheFactorsAreMultipleTakeTheBiggestMultipleAndFactorTheSmallestElement_ThenThreeNumbersAreExpected(){
        List<Integer> factorsOfTheNumbers = Arrays.asList(2,4);
        List<Integer> numbersFactorAllElements = Arrays.asList(16,32,96);
        int numbersBetweenSets = BetweenTwoSets.getTotalX(factorsOfTheNumbers, numbersFactorAllElements);
        assertEquals(3, numbersBetweenSets); // 4, 8 , 16
    }

    @Test
    void whenTheFactorsAreNotMultipleTakeTheLowestCommonDenominatorAndFactorTheSmallestElement_ThenTwoNumbersAreExpected(){
        List<Integer> factorsOfTheNumbers = Arrays.asList(3,4);
        List<Integer> numbersFactorAllElements = Arrays.asList(24,48);
        int numbersBetweenSets = BetweenTwoSets.getTotalX(factorsOfTheNumbers, numbersFactorAllElements);
        assertEquals(2, numbersBetweenSets); // 12, 24
    }
}
