package com.thomashayashi.Gemstones;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/tutorial-intro/problem
 */
public class GemstonesTest {
    @Test
    void checkGems(){
        assertEquals(1, gemstones(Arrays.asList("a", "a")));
        assertEquals(1, gemstones(Arrays.asList("ab", "a")));
        assertEquals(2, gemstones(Arrays.asList("ab", "ab")));
        assertEquals(2, gemstones(Arrays.asList("abbc", "abbc", "bbc")));
        assertEquals(2, gemstones(Arrays.asList("abcdde", "baccd", "eeabg")));
    }

    private int gemstones(List<String> arr) {
        List<Set<Character>> lstGems = new ArrayList<>();
        for(String gem : arr) {
            Set<Character> singleGem = new HashSet<>();
            for(char c : gem.toCharArray())
                singleGem.add(c);
            lstGems.add(singleGem);
        }

        Set<Character> uniqueGems = lstGems.get(0);
        for(int i = 1; i < lstGems.size(); i++)
            uniqueGems.retainAll(lstGems.get(i));

        return uniqueGems.size();
    }
}
