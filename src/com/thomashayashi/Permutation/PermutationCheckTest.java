package com.thomashayashi.Permutation;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PermutationCheckTest {
    @Test
    void givenTwoStringCheckIfTheyArePermutations() {
        assertTrue(isPermutation("a","a"));
        assertTrue(isPermutation("ab","ab"));
        assertTrue(isPermutation("ab","ba"));
        assertTrue(isPermutation("abc","abc"));
        assertTrue(isPermutation("abc","acb"));
        assertTrue(isPermutation("abc","bac"));
        assertTrue(isPermutation("abc","bca"));
        assertTrue(isPermutation("abc","cab"));
        assertTrue(isPermutation("abc","cba"));

        assertFalse(isPermutation("a","b"));
        assertFalse(isPermutation("a","ab"));
        assertFalse(isPermutation("cab","dab"));
    }

    public boolean isPermutation(String word1, String word2) {
        if(word1.length() != word2.length())
            return false;

        char[] letters1 = word1.toCharArray();
        char[] letters2 = word2.toCharArray();

        Arrays.sort(letters1);
        Arrays.sort(letters2);

        for(int i = 0; i <= letters1.length - 1; i++) {
            if (letters1[i] != letters2[i])
                return false;
        }

        return true;
    }
}
