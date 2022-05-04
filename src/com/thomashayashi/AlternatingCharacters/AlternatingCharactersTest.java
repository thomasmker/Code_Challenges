package com.thomashayashi.AlternatingCharacters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/alternating-characters/problem
 */
class AlternatingCharactersTest {
    @Test
    void checkIndex(){
        assertEquals(0, alternatingCharacters("A"));
        assertEquals(0, alternatingCharacters("AB"));
        assertEquals(3, alternatingCharacters("AAAA"));
        assertEquals(4, alternatingCharacters("AAABBB"));
    }

    private int alternatingCharacters(String s) {
        int deletions = 0;
        for(int i = 0; i < s.length() - 1; i++)
            if(s.charAt(i) == s.charAt(i+1))
                deletions++;
        return deletions;
    }
}
