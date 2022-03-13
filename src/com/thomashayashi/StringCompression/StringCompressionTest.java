package com.thomashayashi.StringCompression;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
"compressed" string would not become smaller than the original string, your method should return
the original string. You can assume the string has only uppercase and lowercase letters (a - z).*/
class StringCompressionTest {
    @Test
    void checkCompressedWord(){
        assertEquals("",compress(""));
        assertEquals("a",compress("a"));
        assertEquals("aa",compress("aa"));
        assertEquals("a3",compress("aaa"));
        assertEquals("aab",compress("aab"));
        assertEquals("aabb",compress("aabb"));
        assertEquals("aaab",compress("aaab"));
        assertEquals("a4b1",compress("aaaab"));
        assertEquals("a2b1c5a3",compress("aabcccccaaa"));
    }

    private String compress(String word){
        if(word.length() <= 2)
            return word;

        StringBuilder compressedWord = new StringBuilder();
        char letter = word.charAt(0);
        int letterCount = 1;
        for(int i = 1; i < word.length(); i++) {
            if(letter == word.charAt(i)) {
                letterCount++;
            } else {
                compressedWord.append(String.format("%s%s", letter, letterCount));
                letterCount = 1;
                letter = word.charAt(i);
            }
        }
        compressedWord.append(String.format("%s%s", letter, letterCount));

        return compressedWord.length() < word.length() ? compressedWord.toString() : word;
    }

    @Test
    void checkCompressedWordBookSolution(){
        assertEquals("",compressBookSolution(""));
        assertEquals("a",compressBookSolution("a"));
        assertEquals("aa",compressBookSolution("aa"));
        assertEquals("a3",compressBookSolution("aaa"));
        assertEquals("aab",compressBookSolution("aab"));
        assertEquals("aabb",compressBookSolution("aabb"));
        assertEquals("aaab",compressBookSolution("aaab"));
        assertEquals("a4b1",compressBookSolution("aaaab"));
        assertEquals("a2b1c5a3",compressBookSolution("aabcccccaaa"));
    }

    private String compressBookSolution(String str) {
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

             if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }

        return compressed.length() < str.length() ? compressed .toString() : str;
    }
}
