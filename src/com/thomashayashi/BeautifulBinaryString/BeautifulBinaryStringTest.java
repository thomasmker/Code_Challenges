package com.thomashayashi.BeautifulBinaryString;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/beautiful-binary-string/problem
 */
class BeautifulBinaryStringTest {
    @Test
    void checkIndex(){
        assertEquals(0, beautifulBinaryString("000"));
        assertEquals(1, beautifulBinaryString("010"));
        assertEquals(1, beautifulBinaryString("0010"));
        assertEquals(2, beautifulBinaryString("0101010"));
    }

    private int beautifulBinaryString(String b) {
        int changes = 0;
        for (int i = 2; i < b.length(); i++){
            if (b.charAt(i) == '0' && b.charAt(i - 1) == '1' && b.charAt(i - 2) =='0') {
                changes++;
                i+=2;
            }
        }

        return changes;
    }
}
