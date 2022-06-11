package com.thomashayashi.Palindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Full description: https://leetcode.com/problems/valid-palindrome/
 */
class PalindromeTest {
    @Test
    void checkIsValidPalindrome(){
        assertTrue(isPalindrome(" "));
        assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(isPalindrome("race a car"));
    }

    private boolean isPalindrome(String s) {
        StringBuilder content = new StringBuilder();
        for(int i = 0; i < s.length(); i++)
            if(Character.isLetterOrDigit(s.charAt(i)))
                content.append(s.charAt(i));
        content = new StringBuilder(content.toString().replace(" ", "").toLowerCase());
        String value = content.toString();
        return value.equals(content.reverse().toString());
    }
}
