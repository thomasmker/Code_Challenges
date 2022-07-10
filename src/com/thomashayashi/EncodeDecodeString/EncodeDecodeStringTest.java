package com.thomashayashi.EncodeDecodeString;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.lintcode.com/problem/659/
 */
class EncodeDecodeStringTest {
    private static final char SEPARATOR = '#';

    @Test
    void checkEncodeDecode() {
        List<String> words = Arrays.asList("lint","code","love","you");
        String expectedEncoded = "4#lint4#code4#love3#you";

        assertEquals(expectedEncoded, encode(words));
        assertEquals(words, decode(expectedEncoded));
    }

    private String encode(List<String> words) {
        StringBuilder encodedString = new StringBuilder();
        for(String word: words)
            encodedString.append(word.length()).append(SEPARATOR).append(word);

        return encodedString.toString();
    }



    private List<String> decode(String encodedWords) {
        List<String> decodedStrings = new ArrayList<>();
        for(int i = 0; i < encodedWords.length(); i++) {
            StringBuilder length = new StringBuilder();
            while(encodedWords.charAt(i) != SEPARATOR){
                length.append(encodedWords.charAt(i));
                i++;
            }
            int wordLength = Integer.parseInt(length.toString());
            i++;

            StringBuilder word = new StringBuilder();
            for(int j = i; j < wordLength+i; j++)
                word.append(encodedWords.charAt(j));

            decodedStrings.add(word.toString());
            i = i + wordLength - 1;
        }
        return decodedStrings;
    }
}
