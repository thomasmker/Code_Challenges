package com.thomashayashi.ValidAnagram;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Full description: https://leetcode.com/problems/valid-anagram/
 */
class ValidAnagramTest {
    @Test
    void checkAnagram(){
        assertTrue(isAnagram("abc", "abc"));
        assertTrue(isAnagram("abc", "cab"));
        assertFalse(isAnagram("ab", "abc"));
        assertFalse(isAnagram("abc", "abd"));
        assertFalse(isAnagram("aacc", "ccac"));
    }

    private boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        if(s.equals(t)) return true;

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            sMap.merge(s.charAt(i), 1, Integer::sum);
            tMap.merge(t.charAt(i), 1, Integer::sum);
        }

        for(Character c : sMap.keySet())
            if(!sMap.get(c).equals(tMap.get(c))) return false;
        return true;
    }
}
