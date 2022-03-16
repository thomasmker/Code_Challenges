package com.thomashayashi.StringRotation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/*Assume you have a method i5Substring which checks if one word is a substring
of another.
Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one
call to isSubstring (e.g., waterbottle a rotation erbottlewat ).*/
class StringRotationTest {
    @Test
    void checkIsWordRotation() {
        assertTrue(isRotationBookSolution("ab", "ba"));
        assertTrue(isRotationBookSolution("waterbottle", "erbottlewat"));
    }

    boolean isRotationBookSolution(String s1, String s2) {
        int len = s1.length();
        if(len == s2.length() && len > 0) {
            String s1s1 = s1 + s1;
            return s1s1.contains(s2);
        }
        return false;
    }
}
