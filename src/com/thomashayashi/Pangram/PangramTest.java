package com.thomashayashi.Pangram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Full description: https://www.hackerrank.com/challenges/strong-password/problem
 */
class PangramTest {
    @Test
    void checkIsPangram(){
        assertTrue(pangrams("We promptly judged antique ivory buckles for the next prize"));
        assertFalse(pangrams("We promptly judged antique ivory buckles for the prize"));
    }

    private boolean pangrams(String s) {
        return s.toLowerCase()
                .replaceAll("[^a-z]", "")
                .replaceAll("(.)(?=.*\\1)", "")
                .length() == 26;
    }
}
