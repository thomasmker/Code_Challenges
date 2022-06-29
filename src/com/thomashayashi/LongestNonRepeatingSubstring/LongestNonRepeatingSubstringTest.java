package com.thomashayashi.LongestNonRepeatingSubstring;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
class LongestNonRepeatingSubstringTest {
    @Test
    void checkSubstring() {
        assertEquals(1, lengthOfLongestSubstring("bbbb"));
        assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
        assertEquals(3, lengthOfLongestSubstring("pwwkew"));
    }

    private int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;

        int left = 0, right = 0;
        int longest = 0;
        HashSet<Character> window = new HashSet<>();
        while (right < s.length()) {
            if (!window.contains(s.charAt(right))) {
                window.add(s.charAt(right));
                right++;
            } else {
                window.remove(s.charAt(left));
                left++;
            }
            longest = Math.max(longest, right - left);
        }

        return longest;
    }
}
