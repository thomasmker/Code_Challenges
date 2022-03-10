package com.thomashayashi.PalindromePermutation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*Given a string, write a function to check if it is a permutation of
a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
permutation is a rearrangement of letters. The palindrome does not need to be limited to just
dictionary words.*/
class PalindromePermutationTest {
    @Test
    void checkPermutationOfPalindrome() {
        assertTrue(isPalindromePermutation("a"));
        assertTrue(isPalindromePermutation("aa"));
        assertTrue(isPalindromePermutation("aab"));
        assertTrue(isPalindromePermutation("tactcoapapa"));

        assertFalse(isPalindromePermutation("caab"));
    }

    private boolean isPalindromePermutation(String phrase) {
        int[] table = buildCharFrequency(phrase);
        return checkMaxOneOdd(table);
    }

    private boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for(int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    private int[] buildCharFrequency(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for(char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1)
                table[x]++;
        }
        return table;
    }

    private int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);

        return (a <= val && val <= z) ? val - a : -1;
    }
}
