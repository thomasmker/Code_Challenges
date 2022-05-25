package com.thomashayashi.HappyLadybug;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/happy-ladybugs/problem
 */
class HappyLadybugTest {
    @Test
    void checkHappyLadybugs(){
        assertEquals("YES", happyLadybugs("_"));
        assertEquals("YES", happyLadybugs("__"));
        assertEquals("YES", happyLadybugs("AA"));
        assertEquals("YES", happyLadybugs("ABAB_"));
        assertEquals("NO", happyLadybugs("A"));
        assertEquals("NO", happyLadybugs("AB"));
        assertEquals("NO", happyLadybugs("ABAB"));
    }

    private String happyLadybugs(String b) {
        char[] ladybugs = getLadybugs(b);
        return isHappy(ladybugs) ? "YES" : "NO";
    }

    private char[] getLadybugs(String b) {
        char[] ladybugs = b.toCharArray();
        if(b.contains("_"))
            Arrays.sort(ladybugs);
        return ladybugs;
    }

    private boolean isHappy(char[] ladybugs) {
        for(int i = 0; i < ladybugs.length; i++) {
            if(isEmptySpace(ladybugs[i]))
                continue;

            if (!hasOneEqualNeighbour(ladybugs, i))
                return false;
        }

        return true;
    }

    private boolean isEmptySpace(char ladybugs) {
        return ladybugs == '_';
    }

    private boolean hasOneEqualNeighbour(char[] ladybugs, int i) {
        return  (i - 1 >= 0 && ladybugs[i] == ladybugs[i - 1]) ||
                (i + 1 < ladybugs.length && ladybugs[i] == ladybugs[i + 1]);
    }

}
