package com.thomashayashi.UniqueChars;

import kotlin.collections.CollectionsKt;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/* Implement an algorithm to determine if a string has all unique characters.
What if you cannot use additional data structures?*/
public class UniqueCharsTest {
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
}