package com.thomashayashi.UniqueChars;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/* Implement an algorithm to determine if a string has all unique characters.
What if you cannot use additional data structures?*/
class UniqueCharsTest {
    @Test
    void doesStringHasUniqueChars() {
        assertTrue(isUnique("a"));
        assertTrue(isUnique("ab"));
        assertTrue(isUnique("abc"));
        assertFalse(isUnique("aa"));
        assertFalse(isUnique("aba"));
        assertFalse(isUnique("abab"));

    }

    private boolean isUnique(String word) {
        Set<Character> letters = new HashSet<>();
        for(Character c : word.toCharArray())
            letters.add(c);
        return word.length() == letters.size();
    }

    @Test
    void doesStringHasUniqueCharsNoAdditionalStructure() {
        assertTrue(isUniqueNoAdditionalStructure("a"));
        assertTrue(isUniqueNoAdditionalStructure("ab"));
        assertTrue(isUniqueNoAdditionalStructure("abc"));
        assertFalse(isUniqueNoAdditionalStructure("aa"));
        assertFalse(isUniqueNoAdditionalStructure("aba"));
        assertFalse(isUniqueNoAdditionalStructure("abab"));
    }

    private boolean isUniqueNoAdditionalStructure(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        for(int i = 0; i < chars.length - 1; i++) {
            if(chars[i] == chars[i+1])
                return false;
        }

        return true;
    }

    @Test
    void doesStringHasUniqueCharsBook() {
        assertTrue(isUniqueCharsBookAnswer("a"));
        assertTrue(isUniqueCharsBookAnswer("ab"));
        assertTrue(isUniqueCharsBookAnswer("abc"));
        assertFalse(isUniqueCharsBookAnswer("aa"));
        assertFalse(isUniqueCharsBookAnswer("aba"));
        assertFalse(isUniqueCharsBookAnswer("abab"));
    }

    private boolean isUniqueCharsBookAnswer(String word) {
        if (word.length() > 128)
            return false;

        boolean[] char_set = new boolean[128];
        for (int i = 0; i < word.length(); i++) {
            int val = word.charAt(i);
            if(char_set[val])
                return false;
            else
                char_set[val] = true;
        }

        return true;
    }
}
