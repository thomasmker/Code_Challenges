package com.thomashayashi.MakingAnagram;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/making-anagrams/problem
 */
class MakingAnagramTest {
    @Test
    void checkMinDeletionsToBecomeAnagram(){
        assertEquals(0, makingAnagrams("abc","cba"));
        assertEquals(1, makingAnagrams("a","ba"));
        assertEquals(4, makingAnagrams("abc","man"));
    }

    private int makingAnagrams(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);

        int i = 0;
        int j = 0;
        int commonLetters = 0;
        while(i< c1.length && j< c2.length) {
            if (c1[i] > c2[j])
                j++;
            else if (c1[i] < c2[j])
                i++;
            else {
                commonLetters++;
                i++;
                j++;
            }
        }

        return (c1.length - commonLetters) + (c2.length - commonLetters);
    }
}
